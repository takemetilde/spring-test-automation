package com.org.cucumber.steps.ui;

import com.org.ui.pageobjects.impl.TravelHomePage;
import io.cucumber.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

public class UITravelHomePageSteps {

    @Autowired
    TravelHomePage homePage;

    @Given("the browser is on the Home Page")
    public void the_browser_is_on_the_page() {
        homePage.initializePage();
    }

    @Given("^the departure city (.*?) from the dropdown is selected on the Home Page$")
    public void the_departure_city_from_the_dropdown_is_selected_on_the_home_page(String depCity) {
        homePage.selectItemInDropDown(homePage.getDepartureCityDropDown(), depCity);
    }

    @Given("^the destination city (.*?) from the dropdown is selected on the Home Page$")
    public void the_destination_city_from_the_dropdown_is_selected_on_the_home_page(String desCity) {
        homePage.selectItemInDropDown(homePage.getDestinationCityDropDown(), desCity);
    }

    @Given("^the (.*?) button is clicked on the Home Page$")
    public void the_button_is_clicked_on_the_home_page(String buttonText) {
        homePage.selectButtonByText(homePage.getFindFlightsButton(), buttonText);
    }

}
