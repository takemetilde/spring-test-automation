package com.org.cucumber.steps;

import com.org.ui.pageobjects.impl.BasePage;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URI;

import static org.junit.Assert.assertEquals;

public class UIBaseSteps {

    @Autowired
    BasePage basePage;

    @Autowired
    WebDriver webDriver;

    @Given("^Open (.*?)$")
    public void open(String url) {
        URI uri = URI.create(url);
        basePage.navigateToPage(uri);
        assertEquals("", uri.toString(), webDriver.getCurrentUrl());
        basePage.setUri(uri);
    }

}
