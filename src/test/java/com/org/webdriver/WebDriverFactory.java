package com.org.webdriver;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class WebDriverFactory {

    private static final WebDriverSetup CHROME = new ChromeDriverSetup();
    private static final WebDriverSetup FIREFOX = new FireFoxDriverSetup();

    private static final Map<String, WebDriverSetup> MAP = new HashMap<>();

    static {
        MAP.put("chrome", CHROME);
        MAP.put("firefox", FIREFOX);
    }

    public static WebDriverSetup get(String browser) {
        return MAP.get(browser);
    }


}
