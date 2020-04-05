package com.org.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
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

    @Value("${ui.webdriver.type}")
    String webDriverType;

    @Value("${ui.webdriver.version}")
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
                WebDriverManager.chromedriver().setup();
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
