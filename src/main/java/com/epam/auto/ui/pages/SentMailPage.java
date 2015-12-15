package com.epam.auto.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by ekaterinabut on 12/2/15.
 */
public class SentMailPage extends BasePage {

    @FindBy(className="nH")
    public WebElement sentMailList;

    public SentMailPage(WebDriver driver) {
        super(driver);
    }
}