package com.org.context;

import com.org.config.WebDriverConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.event.annotation.AfterTestClass;
import org.springframework.test.context.event.annotation.AfterTestExecution;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.context.event.annotation.BeforeTestExecution;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@ComponentScan(basePackages = "com.org.ui", basePackageClasses = WebDriverConfig.class)
public class UIIntegrationTestContext {

    @Autowired
    WebDriver webDriver;

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @BeforeTestClass
    public void beforeUI() {
        logger.info("Starting webdriver...");
        webDriver.manage().window().maximize();
    }

    @AfterTestClass
    public void afterUI() {
        logger.info("Quitting current webdriver...");
        webDriver.quit();
    }

}
