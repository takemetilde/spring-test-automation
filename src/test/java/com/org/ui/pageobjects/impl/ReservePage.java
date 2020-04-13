package com.org.ui.pageobjects.impl;

import com.org.ui.PageInitialization;
import com.org.ui.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@PageObject
public class ReservePage extends BasePage implements PageInitialization
{

    @FindBy(tagName = "h3")
    private WebElement banner;

    @Override
    public void initializePage() {
        PageFactory.initElements(webDriver, this);
    }

    public WebElement getBanner()
    {
        return banner;
    }
}
