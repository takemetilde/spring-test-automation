package com.org.cucumber.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"classpath:features"},
        glue = {"com.org.cucumber", "com.org.context"},
        plugin = {"pretty", "json:target/cucumber-report.json"})
public class CucumberRunnerAPIIntegrationTest {

    public static void main(String[] args) throws Exception {
        io.cucumber.core.cli.Main.main(args);
    }
}
