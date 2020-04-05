package com.org.ui;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UITestBase {

    private static ThreadLocal<WebDriver> threadLocalWebDriver = new ThreadLocal<>();

    @Value("ui.webdriver.type")
    String webDriverType;

    @Value("ui.webdriver.version")
    String webDriverVersion;

    private WebDriver driver;

    private Logger logger;

    public UITestBase() {
        logger = LoggerFactory.getLogger(getClass().getName());
    }

    public static WebDriver getWebDriver() {
        return threadLocalWebDriver.get();
    }

    private WebDriver createWebDriver() {
        getLogger().info(String
                .format("Creating webdriver type: %s version: %s", getWebDriverType(), getWebDriverVersion()));

        switch (webDriverType) {
            case BrowserType.CHROME:
                return new ChromeDriver();
            case BrowserType.FIREFOX:
                return new FirefoxDriver();
            default:
                Assert.fail("No webdriver instance created.");
                return null;
        }
    }

    public void initiateWebDriver() {
        driver = threadLocalWebDriver.get();
        if (driver == null) {
            driver = createWebDriver();
            threadLocalWebDriver.set(driver);
        }
    }

    @Before
    public void beforeUI() {
        getLogger().info("Initializing webdriver...");
        initiateWebDriver();
    }

    @After
    public void afterUI() {
        getLogger().info("Tearing down webdriver...");
        getDriver().quit();
    }

    public String getWebDriverType() {
        return webDriverType;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public Logger getLogger() {
        return logger;
    }

    public String getWebDriverVersion() {
        return webDriverVersion;
    }

}
