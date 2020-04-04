package com.org.ui.pageobjects.impl;

import com.org.ui.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageObject
public class TravelHomePage extends BasePage {

    @FindBy(name = "fromPort")
    private WebElement departureCityDropDown;

    @FindBy(name = "toPort")
    private WebElement destinationCityDropDown;

    @FindBy(className = "btn btn-primary")
    private WebElement findFlightsButton;

}
