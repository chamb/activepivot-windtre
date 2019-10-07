/*
 * (C) ActiveViam 2007-2014
 * ALL RIGHTS RESERVED. This material is the CONFIDENTIAL and PROPRIETARY
 * property of ActiveViam. Any unauthorized use,
 * reproduction or transfer of this material is strictly prohibited
 */
package com.activeviam.sandbox.generator;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.time.LocalDate;

import com.quartetfs.fwk.IClone;
import com.quartetfs.fwk.format.impl.DateFormatter;
import com.quartetfs.fwk.format.impl.LocalDateParser;

/**
 * <b>MNP Definition</b>
 *
 * @author ActiveViam
 */
public class Mnp implements IClone<Mnp>, Serializable{

	/** serialVersionUID */
	private static final long serialVersionUID = -3147979015813031848L;

	/**
	 * The pattern used for parsing/formatting dates
	 */
	public static final String DATE_PATTERN = LocalDateParser.DEFAULT_PATTERN;

	/**
	 * The CSV format to parse/format dates.
	 */
	public static final DateFormatter MNP_CSV_DATE_FORMAT = new DateFormatter(DATE_PATTERN);

	protected long idMnp;
	protected String msisdn;
	protected String recipient;
	protected String donator;
	protected String routingNumber;
	protected String iccid;
	protected String status;
	protected LocalDate requestTime;
	protected LocalDate requestCheckTime;
	protected LocalDate portInUpdateTime;
	protected LocalDate portOutUpdateTime;
	protected String quotaStatus;
	protected String checkTimeRequestTime;
	protected String portInTimeCheckTime;
	protected String portOutTimePortInTime;

	/** Default constructor */
	public Mnp() { }

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder(getClass().getSimpleName());
                sb.append("IDMNP=").append(getIdMnp());
                sb.append(", msisdn").append(getMsisdn());
                sb.append(", recipient").append(getRecipient());
                sb.append(", donator").append(getDonator());
                sb.append(", routingNumber").append(getRoutingNumber());
                sb.append(", iccid").append(getIccid());
                sb.append(", status").append(getStatus());
                sb.append(", requestTime").append(getRequestTime());
                sb.append(", requestCheckTime").append(getRequestCheckTime());
                sb.append(", portInUpdateTime").append(getPortInUpdateTime());
                sb.append(", portOutUpdateTime").append(getPortOutUpdateTime());
                sb.append(", quotaStatus").append(getQuotaStatus());
                sb.append(", checkTimeRequestTime").append(getCheckTimeRequestTime());
                sb.append(", portInTimeCheckTime").append(getPortInTimeCheckTime());
                sb.append(", portOutTimePortInTime").append(getPortOutTimePortInTime());
		sb.append(")");
		return sb.toString();
	}

	@Override
	public Mnp clone(){
		try {
		        Mnp clone= (Mnp) super.clone();
			return clone;
		} catch (CloneNotSupportedException e){
			return null;
		}
	}

        public long getIdMnp() {
                return this.idMnp;
        }

        public void setIdMnp(long idMnp) {
                this.idMnp = idMnp;
        }

        public String getMsisdn() {
                return this.msisdn;
        }

        public void setMsisdn(String Msisdn) {
                this.msisdn = msisdn;
        }

        public String getRecipient() {
                return this.recipient;
        }

        public void setRecipient(String Recipient) {
                this.recipient = recipient;
        }

        public String getDonator() {
                return this.donator;
        }

        public void setDonator(String Donator) {
                this.donator = donator;
        }

        public String getRoutingNumber() {
                return this.routingNumber;
        }

        public void setRoutingNumber(String RoutingNumber) {
                this.routingNumber = routingNumber;
        }

        public String getIccid() {
                return this.iccid;
        }

        public void setIccid(String Iccid) {
                this.iccid = iccid;
        }

        public String getStatus() {
                return this.status;
        }

        public void setStatus(String Status) {
                this.status = status;
        }

        public LocalDate getRequestTime() {
                return this.requestTime;
        }

        public void setRequestTime(LocalDate RequestTime) {
                this.requestTime = requestTime;
        }

        public LocalDate getRequestCheckTime() {
                return this.requestCheckTime;
        }

        public void setRequestCheckTime(LocalDate RequestCheckTime) {
                this.requestCheckTime = requestCheckTime;
        }

        public LocalDate getPortInUpdateTime() {
                return this.portInUpdateTime;
        }

        public void setPortInUpdateTime(LocalDate PortInUpdateTime) {
                this.portInUpdateTime = portInUpdateTime;
        }

        public LocalDate getPortOutUpdateTime() {
                return this.portOutUpdateTime;
        }

        public void setPortOutUpdateTime(LocalDate PortOutUpdateTime) {
                this.portOutUpdateTime = portOutUpdateTime;
        }

        public String getQuotaStatus() {
                return this.quotaStatus;
        }

        public void setQuotaStatus(String QuotaStatus) {
                this.quotaStatus = quotaStatus;
        }

        public String getCheckTimeRequestTime() {
                return this.checkTimeRequestTime;
        }

        public void setCheckTimeRequestTime(String CheckTimeRequestTime) {
                this.checkTimeRequestTime = checkTimeRequestTime;
        }

        public String getPortInTimeCheckTime() {
                return this.portInTimeCheckTime;
        }

        public void setPortInTimeCheckTime(String PortInTimeCheckTime) {
                this.portInTimeCheckTime = portInTimeCheckTime;
        }

        public String getPortOutTimePortInTime() {
                return this.portOutTimePortInTime;
        }

        public void setPortOutTimePortInTime(String PortOutTimePortInTime) {
                this.portOutTimePortInTime = portOutTimePortInTime;
        }

	@Override
	public int hashCode() {
		return (int) (idMnp ^ (idMnp >>> 32));
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Mnp other = (Mnp) obj;
		if (idMnp != other.idMnp) {
			return false;
		}
		return true;
	}

}
