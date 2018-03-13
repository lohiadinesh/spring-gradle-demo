package com.cap.config;

import java.beans.PropertyVetoException;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaDialect;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * DataConfig Configuration class configures the DataSource , Transaction
 * Manager, JPA Repository, EntityManagerFactory objects This class serves the
 * purpose of DataSource related entire configuration
 * 
 */

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.cap.repositories", entityManagerFactoryRef = "entityManagerFactory")
@Profile("deployment")
public class DataConfig {

	@Inject
	private Environment environment;

	@Bean
	public EntityManagerFactory entityManagerFactory() {

		final EclipseLinkJpaVendorAdapter vendorAdapter = new EclipseLinkJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(false);
		vendorAdapter.setShowSql(true);
		vendorAdapter.setDatabase(Database.ORACLE);
		vendorAdapter
				.setDatabasePlatform("org.eclipse.persistence.platform.database.OraclePlatform");
		final Map<String, String> jpaProperties = new HashMap<String, String>();
		jpaProperties.put("eclipselink.weaving", "false");
		jpaProperties.put("eclipselink.logging.parameters", "true");
		jpaProperties.put("eclipselink.logging.level", "SEVERE");// FINE ,
																	// FINEST
																	// for
																	// detailed
																	// logs.
		jpaProperties.put("eclipselink.logging.level.sql", "SEVERE");// FINE ,
																		// FINEST
																		// for
																		// detailed
																		// logs.
		jpaProperties.put("jpaDialect",
				" org.springframework.orm.jpa.vendor.EclipseLinkJpaDialect");
		final LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaPropertyMap(jpaProperties);

		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("com.cap.entities");
		factory.setDataSource(dataSource());

		factory.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
		factory.setJpaDialect(new EclipseLinkJpaDialect());

		factory.afterPropertiesSet();
		return factory.getObject();
	}

	/**
	 * Driver manager dataSource configuration
	 * 
	 * @return DataSource
	 * @throws PropertyVetoException
	 */
	@Bean
	public DataSource dataSource() {
		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment
				.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(environment.getProperty("jdbc.url"));
		dataSource.setUsername(environment.getProperty("jdbc.username"));
		dataSource.setPassword(environment.getProperty("jdbc.password"));
		return dataSource;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager(entityManagerFactory());
	}

}
