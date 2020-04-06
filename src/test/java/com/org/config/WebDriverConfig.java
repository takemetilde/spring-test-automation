package com.org.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebDriverConfig {

    @Value("${ui.webdriver.type}")
    String webDriverType;

    @Value("${ui.webdriver.version}")
    String webDriverVersion;

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Bean
    public WebDriver webDriver() {
        logger.info(String.format("Setting up %s browser with version: %s", webDriverType, webDriverVersion));
        switch (webDriverType) {
            case BrowserType.CHROME:
                chromeDriverSetup();
                return new ChromeDriver();
            case BrowserType.FIREFOX:
                firefoxDriverSetup();
                return new FirefoxDriver();
            default:
                Assert.fail("No webdriver instance created.");
                return null;
        }
    }

    private void chromeDriverSetup() {
        if (webDriverVersion.equals("auto")) {
            WebDriverManager.chromedriver().setup();
        } else {
            WebDriverManager.chromedriver().version(webDriverVersion).setup();
        }
    }

    private void firefoxDriverSetup() {
        if (webDriverVersion.equals("auto")) {
            WebDriverManager.firefoxdriver().setup();
        } else {
            WebDriverManager.firefoxdriver().version(webDriverVersion).setup();
        }
    }

}
