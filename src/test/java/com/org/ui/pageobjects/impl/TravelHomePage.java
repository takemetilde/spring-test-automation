package com.org.ui.pageobjects.impl;

import com.org.ui.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@PageObject
public class TravelHomePage extends BasePage {

    @FindBy(name = "fromPort")
    private WebElement departureCityDropDown;

    @FindBy(name = "toPort")
    private WebElement destinationCityDropDown;

    @FindBy(className = "btn-primary")
    private WebElement findFlightsButton;

    @Override
    public void initializePage() {
        PageFactory.initElements(webDriver, this);
        //TODO: Check for unique element
    }

    public WebElement getDepartureCityDropDown() {
        return departureCityDropDown;
    }

    public WebElement getDestinationCityDropDown() {
        return destinationCityDropDown;
    }

    public WebElement getFindFlightsButton() {
        return findFlightsButton;
    }

}
