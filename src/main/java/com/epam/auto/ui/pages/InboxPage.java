package com.epam.auto.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * 'Home' page elements and methods.
 */

public class InboxPage extends BasePage {

    @FindBy(className="UI")
    private WebElement listOfEmails;

    @FindBy(xpath="//div[@aria-label='Report spam']")
    private WebElement buttonReportSpam;

    public InboxPage(WebDriver driver) {
        super(driver);
    }
}
