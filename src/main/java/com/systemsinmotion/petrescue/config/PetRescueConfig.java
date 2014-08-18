package com.systemsinmotion.petrescue.config;

import javax.sql.DataSource;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
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
	velocityEngine.setProperty("class.resource.loader.class", ClasspathResourceLoader.class.getName());
	velocityEngine.init();
	return velocityEngine;
    }
    
    @Bean
    public DataSource dataSource() {
        String driverClassName = "org.hsqldb.jdbcDriver";
        String url = "jdbc:hsqldb:hsql://localhost:9001?defaultSchema=gaar";
        String username = "sa";
        String password = "";

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

}
