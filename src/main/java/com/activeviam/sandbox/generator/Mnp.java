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
                sb.append(", MSISDN=").append(getMsisdn());
                sb.append(", RECIPIENT=").append(getRecipient());
                sb.append(", DONATOR=").append(getDonator());
                sb.append(", ROUTING_NUMBER=").append(getRouting_Number());
                sb.append(", ICCID=").append(getIccid());
                sb.append(", STATUS=").append(getStatus());
                sb.append(", REQUEST_TIME=").append(getRequest_Time());
                sb.append(", REQUEST_CHECK_TIME=").append(getRequest_Check_Time());
                sb.append(", PORT_IN_UPDATE_TIME=").append(getPort_In_Update_Time());
                sb.append(", PORT_OUT_UPDATE_TIME=").append(getPort_Out_Update_Time());
                sb.append(", QUOTA_STATUS=").append(getQuota_Status());
                sb.append(", CHECK_TIME_REQUEST_TIME=").append(getCheck_Time_Request_Time());
                sb.append(", PORT_IN_TIME_CHECK_TIME=").append(getPort_In_Time_Check_Time());
                sb.append(", PORT_OUT_TIME_PORT_IN_TIME=").append(getPort_Out_Time_Port_In_Time());
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

        public String getRouting_Number() {
                return this.routingNumber;
        }

        public void setRouting_Number(String Routing_Number) {
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

        public LocalDate getRequest_Time() {
                return this.requestTime;
        }

        public void setRequest_Time(LocalDate RequestTime) {
                this.requestTime = requestTime;
        }

        public LocalDate getRequest_Check_Time() {
                return this.requestCheckTime;
        }

        public void setRequest_Check_Time(LocalDate RequestCheckTime) {
                this.requestCheckTime = requestCheckTime;
        }

        public LocalDate getPort_In_Update_Time() {
                return this.portInUpdateTime;
        }

        public void setPort_In_Update_Time(LocalDate PortInUpdateTime) {
                this.portInUpdateTime = portInUpdateTime;
        }

        public LocalDate getPort_Out_Update_Time() {
                return this.portOutUpdateTime;
        }

        public void setPort_Out_Update_Time(LocalDate PortOutUpdateTime) {
                this.portOutUpdateTime = portOutUpdateTime;
        }

        public String getQuota_Status() {
                return this.quotaStatus;
        }

        public void setQuota_Status(String QuotaStatus) {
                this.quotaStatus = quotaStatus;
        }

        public String getCheck_Time_Request_Time() {
                return this.checkTimeRequestTime;
        }

        public void setCheck_Time_Request_Time(String CheckTimeRequestTime) {
                this.checkTimeRequestTime = checkTimeRequestTime;
        }

        public String getPort_In_Time_Check_Time() {
                return this.portInTimeCheckTime;
        }

        public void setPort_In_Time_Check_Time(String PortInTimeCheckTime) {
                this.portInTimeCheckTime = portInTimeCheckTime;
        }

        public String getPort_Out_Time_Port_In_Time() {
                return this.portOutTimePortInTime;
        }

        public void setPort_Out_Time_Port_In_Time(String PortOutTimePortInTime) {
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
