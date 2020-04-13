package com.org.cucumber.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"classpath:features/api"},
        glue = {"com.org.cucumber", "com.org.context.api"},
        plugin = {"pretty", "json:target/cucumber-report.json"})
public class CucumberRunnerAPIIntegrationTest {

}
