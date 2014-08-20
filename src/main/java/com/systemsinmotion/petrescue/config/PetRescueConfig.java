package com.systemsinmotion.petrescue.config;

import javax.sql.DataSource;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories({ "com.systemsinmotion.petrescue.data" })
@EnableTransactionManagement
@PropertySource("classpath:/shelter.properties")
public class PetRescueConfig {

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public static VelocityEngine velocityEngine() {
		VelocityEngine velocityEngine = new VelocityEngine();
		velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "class");
		velocityEngine.setProperty("class.resource.loader.class",
				ClasspathResourceLoader.class.getName());
		velocityEngine.init();
		return velocityEngine;
	}

	@Bean
	public DataSource dataSource() {
		String driverClassName = "org.hsqldb.jdbcDriver";
		String url = "jdbc:hsqldb:hsql://localhost:9001/gaar";
		String username = "sa";
		String password = "";

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}

	// @Bean
	// public LocalSessionFactoryBean sessionFactory() {
	// LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	// sessionFactory.setDataSource(dataSource());
	// sessionFactory.setPackagesToScan("com.systemsinmotion.petrescue.entity");
	//
	// Properties props = new Properties();
	// props.setProperty("hibernate.show_sql", "true");
	//
	// sessionFactory.setHibernateProperties(props);
	//
	// return sessionFactory();
	// }

	public static final String ENTITIES_PACKAGE = "com.systemsinmotion.petrescue.entity";

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setDatabase(Database.HSQL);
		vendorAdapter.setShowSql(true);

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setDataSource(dataSource());
		factory.setPackagesToScan(ENTITIES_PACKAGE);

		return factory;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager();
	}
}
