package com.org.context;

import io.cucumber.java.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {UIIntegrationTestContext.class, APIIntegrationTestContext.class})
public class CucumberSpringContext {

    @Before
    public void before() {
    }

}
