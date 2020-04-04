package com.org.api.rest.config;

import io.restassured.builder.RequestSpecBuilder;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

@TestComponent
public class ResponseConfig {

    @Bean
    public RequestSpecBuilder requestSpecBuilder() {
        return new RequestSpecBuilder();
    }

    @Bean
    public Map<String, String> requestHeaders() {
        return new HashMap<>();
    }
}
