package com.org.impl;

import com.org.IntegrationTestContext;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.Map;

@ContextConfiguration(classes = IntegrationTestContext.class)
public class TestBase {

    @Autowired
    protected RequestSpecBuilder specBuilder;

    protected RequestSpecification spec;

    @Autowired
    protected Map<String, String> headers;

}
