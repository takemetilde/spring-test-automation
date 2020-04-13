package com.org.cucumber.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"classpath:features/ui"},
        glue = {"com.org.cucumber", "com.org.context.ui"},
        plugin = {"pretty", "json:target/cucumber-report.json"})
public class CucumberRunnerUIIntegrationTest {

}
