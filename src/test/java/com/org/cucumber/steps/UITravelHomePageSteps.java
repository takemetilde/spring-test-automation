package com.org.cucumber.steps;

import com.org.ui.pageobjects.impl.TravelHomePage;
import io.cucumber.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

public class UITravelHomePageSteps {

    @Autowired
    TravelHomePage homePage;

    @Given("^the departure city (.*?) from the dropdown is selected on the Home Page$")
    public void the_departure_city_from_the_dropdown_is_selected_on_the_home_page(String depCity) {
        homePage.selectItemInDropDown(homePage.getDepartureCityDropDown(), depCity);
    }

}
