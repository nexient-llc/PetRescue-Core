package com.systemsinmotion.petrescue.config

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer

/**
 * @author kskronek
 * @since 2015-Jan-26
 */
@Configuration
@PropertySource("classpath:employeeService.properties")
class PropertyPlaceholderConfig {

    private static Logger LOGGER = LogManager.getLogger(PropertyPlaceholderConfig.class)

    PropertyPlaceholderConfig() {
        LOGGER.debug("Instance of PropertyPlaceholderConfig created.")
    }

    /**
     * Returns an instance of PropertySourcesPlaceholderConfigurer.
     *
     * @return the property sources placeholder configurer
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        LOGGER.debug("Instance of PropertySourcesPlaceholderConfigurer created.")
        return new PropertySourcesPlaceholderConfigurer()
    }
}
