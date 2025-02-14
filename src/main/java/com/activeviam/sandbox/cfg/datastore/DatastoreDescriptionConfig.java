/*
 * (C) ActiveViam 2018
 * ALL RIGHTS RESERVED. This material is the CONFIDENTIAL and PROPRIETARY
 * property of Quartet Financial Systems Limited. Any unauthorized use,
 * reproduction or transfer of this material is strictly prohibited
 */
package com.activeviam.sandbox.cfg.datastore;

import static com.qfs.literal.ILiteralType.DOUBLE;
import static com.qfs.literal.ILiteralType.INT;
import static com.qfs.literal.ILiteralType.LOCAL_DATE;
import static com.qfs.literal.ILiteralType.LONG;
import static com.qfs.literal.ILiteralType.STRING;

import java.util.Collection;
import java.util.LinkedList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.qfs.desc.IDatastoreSchemaDescription;
import com.qfs.desc.IReferenceDescription;
import com.qfs.desc.IStoreDescription;
import com.qfs.desc.impl.DatastoreSchemaDescription;
import com.qfs.desc.impl.ReferenceDescription;
import com.qfs.desc.impl.StoreDescriptionBuilder;
import com.qfs.server.cfg.IDatastoreDescriptionConfig;

/**
 * Spring configuration file that exposes the datastore
 * {@link IDatastoreSchemaDescription description}.
 *
 * @author ActiveViam
 *
 */
@Configuration
public class DatastoreDescriptionConfig implements IDatastoreDescriptionConfig {

	/******************** Formatters ***************************/
	public static final String DATE_FORMAT = "localDate[yyyy-MM-dd]";

	@Bean
	public IStoreDescription mnp() {
		return new StoreDescriptionBuilder().withStoreName("MNP")
				.withField("IDMNP", INT).asKeyField()
				.withField("MSISDN", STRING)
				.withField("RECIPIENT", STRING)
				.withField("DONATOR", STRING)
				.withField("ROUTING_NUMBER", STRING)
				.withField("ICCID", STRING)
				.withField("STATUS", STRING)
				.withField("REQUEST_TIME", LOCAL_DATE)
				.withField("REQUEST_CHECK_TIME", LOCAL_DATE)
				.withField("PORT_IN_UPDATE_TIME", LOCAL_DATE)
				.withField("PORT_OUT_UPDATE_TIME", LOCAL_DATE)
				.withField("QUOTA_STATUS", STRING)
				.withField("CHECK_TIME_REQUEST_TIME", STRING)
				.withField("PORT_IN_TIME_CHECK_TIME", STRING)
				.withField("PORT_OUT_TIME_PORT_IN_TIME", STRING)
				.withModuloPartitioning("IDMNP", 8)
				.build();
	}

	@Bean
	public Collection<IReferenceDescription> references(){
		final Collection<IReferenceDescription> references = new LinkedList<>();
		return references;
	}

	/**
	 *
	 * Provide the schema description of the datastore.
	 * <p>
	 * It is based on the descriptions of the stores in the datastore, the descriptions of the
	 * references between those stores, and the optimizations and constraints set on the schema.
	 *
	 * @return schema description
	 */
	@Override
	@Bean
	public IDatastoreSchemaDescription schemaDescription() {
		final Collection<IStoreDescription> stores = new LinkedList<>();
		stores.add(mnp());
		return new DatastoreSchemaDescription(stores, references());
	}

}
