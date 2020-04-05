package com.org.context;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.org.ui.pageobjects.impl")
public class UIIntegrationTestContext {

}
