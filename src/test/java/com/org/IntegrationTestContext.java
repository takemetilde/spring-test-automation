package com.org;

import com.org.config.RestClientConfig;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.org.impl", basePackageClasses = RestClientConfig.class)
public class IntegrationTestContext {

}
