/*
 * (C) ActiveViam 2018
 * ALL RIGHTS RESERVED. This material is the CONFIDENTIAL and PROPRIETARY
 * property of Quartet Financial Systems Limited. Any unauthorized use,
 * reproduction or transfer of this material is strictly prohibited
 */
package com.activeviam.sandbox.cfg;

import java.io.IOException;
import java.lang.ClassNotFoundException;
import java.util.Arrays;
import java.util.Properties;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.env.Environment;

import com.qfs.msg.IMessageChannel;
import com.qfs.msg.impl.QfsResultSetRow;
import com.qfs.msg.jdbc.IJDBCSource;
import com.qfs.msg.jdbc.impl.JDBCTopic;
import com.qfs.msg.jdbc.impl.NativeJDBCSource;
import com.qfs.source.impl.JDBCMessageChannelFactory;
import com.qfs.store.IDatastore;
import com.qfs.store.impl.SchemaPrinter;
import com.qfs.store.transaction.ITransactionManager;
import com.qfs.util.timing.impl.StopWatch;

/**
 * Spring configuration for data sources
 *
 * @author ActiveViam
 */
public class DataLoadingConfig {

	private static final Logger LOGGER = Logger.getLogger(DataLoadingConfig.class.getSimpleName());

	@Autowired
	protected Environment env;

	@Autowired
	protected IDatastore datastore;

	/**
	 * @return JDBC Source
	 */
	@Bean
	public IJDBCSource<QfsResultSetRow> jdbcSource() {

		LOGGER.info("Starting JDBC Source configuration");

		Properties applicationProperties = new Properties();
		try {
			applicationProperties.load(
					DataLoadingConfig.class.getClassLoader().getResourceAsStream("application.properties"));
		} catch (IOException e) {
			LOGGER.warning("The application.properties could not be loaded. Using default properties.");
		}

		// Initialize the database
		Properties sourceProperties = new Properties();
		final String username = applicationProperties.getProperty("jdbc.username", "user");
		final String password = applicationProperties.getProperty("jdbc.password", "user");
		sourceProperties.setProperty("username", username);
		sourceProperties.setProperty("password", password);

		// Create the JDBC Source
		final String uri = applicationProperties.getProperty("jdbc.URI", "jdbc:h2:mem:test");
		LOGGER.info("Configured a JDBC Source with URI " + uri + " for user " + username);

		final String driver = "com.leanxcale.client.Driver";
//		try {
//			final Class driverClass = Class.forName(driver);
//			LOGGER.info("Driver class " + driverClass + " succesfully loaded");
//		} catch (ClassNotFoundException e) {
//			LOGGER.warning("Could not find class " + driver);
//		}
		NativeJDBCSource jdbcSource = new NativeJDBCSource(
				uri,
				driver, // DRIVER
				sourceProperties,
				"ActivePivot JDBC Source",
				2, // pool size
				5000  // append batch size
		);

		// Register topics
//		jdbcSource.addTopic(new JDBCTopic("USERAPP", "SELECT * from USERAPP"));
//		jdbcSource.addTopic(new JDBCTopic("PLAN", "SELECT * from PLAN"));
//		jdbcSource.addTopic(new JDBCTopic("QUOTA", "SELECT * from QUOTA"));
		jdbcSource.addTopic(new JDBCTopic("MNP", "SELECT * from MNP"));

		return jdbcSource;
	}

	@Bean
	@DependsOn(value = "jdbcSource")
	public Void loadData(IJDBCSource<QfsResultSetRow> jdbcSource) throws Exception {

		final ITransactionManager tm = datastore.getTransactionManager();

		// Load data into ActivePivot
		final long before = System.nanoTime();

		// Transaction for TV data
		tm.startTransaction();

		JDBCMessageChannelFactory jdbcChannelFactory = new JDBCMessageChannelFactory(jdbcSource, datastore);
		IMessageChannel<String, QfsResultSetRow> mnpChannel = jdbcChannelFactory.createChannel("MNP");

		jdbcSource.fetch(Arrays.asList(mnpChannel));

		tm.commitTransaction();

		final long elapsed = System.nanoTime() - before;
		LOGGER.info("Data load completed in " + elapsed / 1000000L + "ms");

		printStoreSizes();

		return null;
	}


	private void printStoreSizes() {

		// Print stop watch profiling
		StopWatch.get().printTimings();
		StopWatch.get().printTimingLegend();

		// print sizes
		SchemaPrinter.printStoresSizes(datastore.getHead().getSchema());
	}

}
