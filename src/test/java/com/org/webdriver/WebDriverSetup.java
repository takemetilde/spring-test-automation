package com.org.webdriver;

import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

@Component
public abstract class WebDriverSetup {

    public abstract void setup();

    public abstract WebDriver instantiate();
}
