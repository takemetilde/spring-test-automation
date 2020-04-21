package com.org.ui;

import com.org.config.WebDriverConfig;
import com.org.ui.pageobjects.impl.BasePage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.event.annotation.AfterTestClass;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.io.IOException;

@ComponentScan(basePackages = "com.org.ui", basePackageClasses = WebDriverConfig.class)
public class UIIntegrationTestContext {

    @Autowired BasePage basePage;

    @Autowired
    WebDriver webDriver;

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @BeforeTestClass
    public void beforeUI() {
        logger.info("Starting webdriver...");
        webDriver.manage().window().maximize();
    }

    @AfterTestClass
    public void afterUI() throws IOException
    {
        logger.info("Quitting current webdriver...");
        basePage.takeScreenShot();
        webDriver.quit();
    }

}
