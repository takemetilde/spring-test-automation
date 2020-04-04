package com.org.ui.pageobjects.impl;

import com.org.ui.UITestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.List;

public class BasePage {

    private static final int WAIT_TIMEOUT = 10;
    @Autowired
    UITestBase base;

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

    protected Boolean isElementDisplayed(By selector) {
        return findElement(selector).isDisplayed();
    }

    protected String getElementText(By selector) {
        return StringUtils.trimWhitespace(findElement(selector).getText());
    }

    public void selectRadioButtonByValue(By radioGroup, String valueToSelect) {
        List<WebElement> radioLabels = getDriver().findElements(radioGroup);
        String trim = StringUtils.trimWhitespace(valueToSelect);
        for (WebElement radioLabel : radioLabels) {
            if (StringUtils.trimWhitespace(radioLabel.getText()).equalsIgnoreCase(trim)) {
                radioLabel.click();
                break;
            }
        }
    }

    public void selectItemInDropDown(By dropDownList, String itemToSelect) {
        WebElement dropDownElement = findElement(dropDownList);
        List<WebElement> options = dropDownElement.findElements(By.tagName("li"));
        String toUpperCase = itemToSelect.toUpperCase();
        for (WebElement option : options) {
            if (option.getText().toUpperCase().contains(toUpperCase)) {
                option.click();
                break;
            }
        }
    }
}
