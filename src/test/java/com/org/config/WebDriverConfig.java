package com.org.config;

import com.org.webdriver.WebDriverFactory;
import com.org.webdriver.WebDriverSetup;
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

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Value("${ui.webdriver.type}")
    String webDriverType;

    @Bean
    public WebDriver webDriver() {
        WebDriverSetup setup = WebDriverFactory.get(webDriverType);
        setup.setup();
        return setup.instantiate();
    }
}
