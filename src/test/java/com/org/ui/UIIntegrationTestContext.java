package com.org.ui;

import com.org.config.WebDriverConfig;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.event.annotation.AfterTestClass;
import org.springframework.test.context.event.annotation.BeforeTestClass;

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
