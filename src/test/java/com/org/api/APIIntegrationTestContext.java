package com.org.api;

import com.org.config.RestClientConfig;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.org.api.rest.impl", basePackageClasses = RestClientConfig.class)
public class APIIntegrationTestContext {

}
