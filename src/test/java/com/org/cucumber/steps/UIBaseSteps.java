package com.org.cucumber.steps;

import com.org.ui.pageobjects.impl.BasePage;
import io.cucumber.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URI;

public class UIBaseSteps {

    @Autowired
    BasePage basePage;

    @Given("^Open (.*?)$")
    public void open(String url) {
        URI uri = URI.create(url);
        basePage.navigateToPage(uri);
    }

}
