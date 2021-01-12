package com.org.context;

import com.org.api.APIIntegrationTestContext;
import io.cucumber.java.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

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
