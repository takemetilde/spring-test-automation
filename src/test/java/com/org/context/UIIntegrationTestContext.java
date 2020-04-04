package com.org.context;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration
@ComponentScan(basePackages = "com.org.ui.pageobjects.impl")
public class UIIntegrationTestContext {
}
