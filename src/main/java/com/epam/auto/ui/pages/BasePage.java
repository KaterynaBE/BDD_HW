package com.epam.auto.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Base page containing elements and methods from left menu and Google bar (on Inbox, Spam, etc pages).
 */
public class BasePage {

    @FindBy(className = "z0")
    protected WebElement buttonCompose;

    @FindBy(xpath="//a[@href='https://accounts.google.com/SignOutOptions?hl=en&continue=https://mail.google.com/" +
            "mail&service=mail']")
    private WebElement iconAccount;

    @FindBy(xpath="//a[text()='Sign out']")
    private WebElement buttonSignOut;

    @FindBy(className="ait")
    private WebElement expanderMoreLess;

    @FindBy(partialLinkText = "Spam")
    private WebElement linkSpam;

    @FindBy(linkText = "Sent Mail")
    private WebElement linkSentMail;

    @FindBy(linkText = "Drafts (1)")
    private WebElement linkDrafts1;

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public NewMessagePopup initiateNewEmail() {
        buttonCompose.click();
        return new NewMessagePopup(driver);
    }

    public SignInPage signOut() {
        iconAccount.click();
        buttonSignOut.click();
        return new SignInPage(driver);
    }

    public SentMailPage openSendMailFolder() {
        linkSentMail.click();
        return new SentMailPage(driver);
    }

    public DraftsPage openDraftsFolder() {

        linkDrafts1.click();
        return new DraftsPage(driver);
    }
}