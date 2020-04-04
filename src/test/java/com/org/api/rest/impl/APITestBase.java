package com.org.api.rest.impl;

import com.org.context.APIIntegrationTestContext;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.Map;

@ContextConfiguration(classes = APIIntegrationTestContext.class)
public class APITestBase {

    @Autowired
    protected RequestSpecBuilder specBuilder;

    protected RequestSpecification spec;

    @Autowired
    protected Map<String, String> headers;

}
