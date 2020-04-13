package com.org.cucumber.steps.ui;

import com.org.ui.pageobjects.impl.ReservePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UIReservationPageSteps
{
    @Autowired
    ReservePage reservePage;

    @Given("the browser is on the Reservation Page")
    public void the_browser_is_on_the_page() {
        reservePage.initializePage();
    }

    @Then("^the heading should show (.*) on the Reservation Page$")
    public void the_heading_should_show_on_the_reservation_page(String string) throws InterruptedException
    {
        assertTrue( reservePage.getBanner().isDisplayed());
        assertEquals( string, reservePage.getBanner().getText() );
        Thread.sleep( 2000 );
    }
}
