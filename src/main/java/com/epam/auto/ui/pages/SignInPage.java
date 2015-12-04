package com.epam.auto.ui.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


/**
 * 'Sign in' page elements and methods.
 */

public class SignInPage {

    @FindBy(id = "Email")
    private WebElement inputEmail;

    @FindBy(id="next")
    private WebElement buttonNext;

    @FindBy(id="Passwd")
    private WebElement inputPassword;

    @FindBy(id="signIn")
    private WebElement buttonSignIn;

    @FindBy(id="PersistentCookie")
    private WebElement checkboxStaySigned;

    private WebDriver driver;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public InboxPage signIn(String email, String password) {
        inputEmail.clear();
        inputEmail.sendKeys(email);

        buttonNext.click();
        inputPassword.clear();
        inputPassword.sendKeys(password);

        // making sure that Stay Signed in checkbox is not ticked - for easier switching accounts.
        if (checkboxStaySigned.isSelected()) {
            checkboxStaySigned.click();
        }
        buttonSignIn.click();
        return new InboxPage(driver);
    }
}