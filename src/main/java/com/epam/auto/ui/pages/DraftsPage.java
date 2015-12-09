package com.epam.auto.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * 'Drafts' page elements and methods.
 */
public class DraftsPage extends BasePage {

    @FindBy(className = "nH")
    public WebElement itemInDrafts;

//    private WebDriver driver;

    public DraftsPage(WebDriver driver) {
        super(driver);
    }

    public NewMessagePopup openDraft() {
        itemInDrafts.click();
        return new NewMessagePopup(driver);
    }
}