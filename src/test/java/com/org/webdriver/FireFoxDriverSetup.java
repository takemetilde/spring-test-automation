package com.org.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FireFoxDriverSetup extends WebDriverSetup{

    @Value("${ui.browser.firefox.version}")
    private String browserVersion;

    @Override
    public void setup() {
        WebDriverManager.firefoxdriver().browserVersion(browserVersion).setup();
    }

    @Override
    public WebDriver instantiate() {
        return new FirefoxDriver();
    }

}
