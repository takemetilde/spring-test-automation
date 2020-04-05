package com.org.ui.pageobjects.impl;

import com.org.ui.PageObject;
import com.org.ui.UITestBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.net.URI;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@PageObject
public class BasePage {

    private static final int WAIT_TIMEOUT = 10;

    private URI uri;

    @Autowired


    public static void handledSleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }

    protected WebElement findElement(By selector) {
        return findElement(ExpectedConditions.presenceOfElementLocated(selector));
    }

    protected WebElement findElement(WebElement selector) {
        return findElement(ExpectedConditions.visibilityOf(selector));
    }

    private WebElement findElement(ExpectedCondition<WebElement> expectedCondition) {
        return getWebDriverWait().until(expectedCondition);
    }

    protected WebDriverWait getWebDriverWait() {
        return new WebDriverWait(getDriver(), WAIT_TIMEOUT);
    }

    private WebDriver getDriver() {
        return UITestBase.getWebDriver();
    }

    public void navigateToPage(URI url) {
        getDriver().get(url.toString());
        getWebDriverWait().until(ExpectedConditions.jsReturnsValue("return document.readyState=='complete';"));
    }

    public Boolean isElementDisplayed(By selector) {
        return findElement(selector).isDisplayed();
    }

    public String getElementText(By selector) {
        return StringUtils.trimWhitespace(findElement(selector).getText());
    }

    public Boolean isClickable(WebElement element) {
        try {
            findElement(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void selectButtonByText(WebElement button, String buttonText) {
        assertTrue("Button is not clickable: " + button.getTagName(), isClickable(button));
        assertEquals("Button text is incorrect:" + buttonText, button.getText(), buttonText);
        button.click();
    }

    public void selectRadioButtonByValue(WebElement radioGroup, String valueToSelect) {
        List<WebElement> radioLabels = radioGroup.findElements(By.tagName(""));
        String trim = StringUtils.trimWhitespace(valueToSelect);
        for (WebElement radioLabel : radioLabels) {
            if (StringUtils.trimWhitespace(radioLabel.getText()).equalsIgnoreCase(trim)) {
                radioLabel.click();
                break;
            }
        }
    }

    public void selectItemInDropDown(WebElement dropDownElement, String itemToSelect) {
        List<WebElement> options = dropDownElement.findElements(By.tagName("li"));
        for (WebElement option : options) {
            if (option.getText().contains(itemToSelect)) {
                option.click();
                break;
            } else {
                Assert.fail("No items in dropdown exist that match: " + itemToSelect);
            }
        }
    }

}
