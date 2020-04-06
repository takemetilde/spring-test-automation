package com.org.context;

import com.org.config.WebDriverConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.org.ui", basePackageClasses = WebDriverConfig.class)
public class UIIntegrationTestContext {

}
