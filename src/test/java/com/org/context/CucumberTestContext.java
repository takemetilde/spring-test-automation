package com.org.context;

import cucumber.api.java.Before;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(classes = CucumberTestContext.class)
@ContextConfiguration
@ActiveProfiles("test")
public class CucumberTestContext {

    @Before
    public void before() {

    }

}
