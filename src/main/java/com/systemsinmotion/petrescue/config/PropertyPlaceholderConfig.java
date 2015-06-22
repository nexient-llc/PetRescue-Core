package com.systemsinmotion.petrescue.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author kskronek
 * @since 2015-Jan-26
 */
@Configuration
@PropertySource("classpath:shelter.properties")
class PropertyPlaceholderConfig {

    /**
     * Returns an instance of PropertySourcesPlaceholderConfigurer.
     *
     * @return the property sources placeholder configurer
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
