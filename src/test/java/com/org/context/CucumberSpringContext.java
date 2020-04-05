package com.org.context;

import com.org.ui.UITestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {UIIntegrationTestContext.class, APIIntegrationTestContext.class, UITestBase.class},
        initializers = ConfigFileApplicationContextInitializer.class)
@ActiveProfiles("test")
public class CucumberSpringContext {

    @Autowired
    UITestBase base;

    @Before
    public void beforeUI() {
        base.getLogger().info("Initializing webdriver...");
        base.initiateWebDriver();
    }

    @After
    public void afterUI() {
        base.getLogger().info("Tearing down webdriver...");
        base.getDriver().quit();
    }


}
