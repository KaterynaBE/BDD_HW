package com.epam.auto.ui.services;

import org.openqa.selenium.WebDriver;

import com.epam.auto.ui.pages.NewMessagePopup;
import com.epam.auto.ui.pages.BasePage;

import com.epam.auto.patterns.staticfactorymethod.Email;

/**
 * Created by ekaterinabut on 11/12/15.
 */
public class EmailManager extends BaseManager {

    private BasePage basePage;
    public EmailManager(WebDriver driver) {
        super(driver);
    }

    public void sendEmail(Email email) {
        NewMessagePopup newMessagePopup = new BasePage(driver).initiateNewEmail();
        newMessagePopup.sendEmail(email);
        basePage = new BasePage(driver);
    }

    public void createEmailClosePopup(Email email) {
        NewMessagePopup newMessagePopup = new BasePage(driver).initiateNewEmail();
        newMessagePopup.createEmailClosePopup(email);

    }


}
