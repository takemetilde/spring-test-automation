package com.org.context.api;

import com.org.api.APIIntegrationTestContext;
import io.cucumber.java.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {
        APIIntegrationTestContext.class},
        initializers = ConfigFileApplicationContextInitializer.class)
@ActiveProfiles("test")
@DirtiesContext
public class CucumberSpringAPIContext {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Before
    public void beforeUI() {
        logger.info("Starting Cucumber in Spring context...");

    }

}
