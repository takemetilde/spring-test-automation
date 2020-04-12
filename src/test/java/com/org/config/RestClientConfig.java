package com.org.config;

import io.restassured.builder.RequestSpecBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RestClientConfig {

    @Bean
    public RequestSpecBuilder requestSpecBuilder() {
        return new RequestSpecBuilder();
    }

    @Bean
    public Map<String, String> requestHeaders() {
        return new HashMap<>();
    }

}
