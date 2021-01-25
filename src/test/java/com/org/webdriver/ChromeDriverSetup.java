package com.org.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ChromeDriverSetup extends WebDriverSetup{

    @Value("${ui.browser.chrome.version}")
    private String browserVersion;

    @Override
    public void setup() {
        WebDriverManager.chromedriver().setup();
    }

    @Override
    public WebDriver instantiate() {
        return new ChromeDriver();
    }

}
