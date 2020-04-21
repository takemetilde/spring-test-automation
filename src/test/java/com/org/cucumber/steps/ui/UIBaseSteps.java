package com.org.cucumber.steps.ui;

import com.org.ui.pageobjects.impl.BasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URI;

import static java.lang.String.format;
import static org.junit.Assert.assertEquals;

public class UIBaseSteps
{
    private Logger logger = LoggerFactory.getLogger( getClass().getName() );

    @Autowired
    BasePage basePage;

    @Autowired
    WebDriver webDriver;

    @Given( "^Open (.*?)$" )
    public void open( String url )
    {
        URI uri = URI.create( url );
        basePage.navigateToPage( uri );
        assertEquals( "", uri.toString(), webDriver.getCurrentUrl() );
        basePage.setUri( uri );
    }

    @Then( "the page should load correctly for {string}" )
    public void the_page_should_load_correctly( String location )
    {
        By errorCode = By.className( "error-code" );
        String errorStatusAct;
        if( basePage.isElementDisplayed( errorCode ) )
        {
            errorStatusAct = basePage.findElement( errorCode ).getText();
            Assert.fail( format( "The page load was an error: %s for site: %s ", errorStatusAct, location ) );
        }

        else
        {
            logger.info( "The page loaded successfully" );
        }
    }

}
