package com.org.context;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {UIIntegrationTestContext.class, APIIntegrationTestContext.class},
        initializers = ConfigFileApplicationContextInitializer.class)
@ActiveProfiles("test")
@DirtiesContext
public class CucumberSpringContext {

    @Autowired
    WebDriver webDriver;

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Before
    public void beforeUI() {
        logger.info("Starting Cucumber in Spring context...");
        webDriver.manage().window().maximize();
    }

    @After
    public void afterUI() {
        logger.info("Quitting current webdriver...");
        webDriver.quit();
    }

}
