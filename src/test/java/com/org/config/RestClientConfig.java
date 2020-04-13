package com.org.config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RestClientConfig {

    @Bean
    public RequestSpecBuilder requestSpecBuilder() {
        return new RequestSpecBuilder().addFilter(new RequestLoggingFilter()).addFilter(new ResponseLoggingFilter())
                .addFilter(new ErrorLoggingFilter());
    }

    @Bean
    public Map<String, String> requestHeaders() {
        return new HashMap<>();
    }

}
