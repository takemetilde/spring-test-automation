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
import org.springframework.util.StringUtils;

import java.net.URI;
import java.util.List;

@PageObject
public class BasePage {

    private static final int WAIT_TIMEOUT = 10;

    public static void handledSleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected WebElement findElement(By selector) {
        return findElement(ExpectedConditions.presenceOfElementLocated(selector));
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
    }

    public Boolean isElementDisplayed(By selector) {
        return findElement(selector).isDisplayed();
    }

    public String getElementText(By selector) {
        return StringUtils.trimWhitespace(findElement(selector).getText());
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
