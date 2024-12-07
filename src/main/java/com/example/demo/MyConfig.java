package com.example.demo; // Adjust this based on your package structure

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class MyConfig {

    @Bean
    public org.glassfish.jersey.server.ResourceConfig resourceConfig() {
        org.glassfish.jersey.server.ResourceConfig resourceConfig = new org.glassfish.jersey.server.ResourceConfig();
        resourceConfig.packages("com.example.demo.resources");
        return resourceConfig;
    }
}
