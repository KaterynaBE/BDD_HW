package com.epam.auto.ui.services;

import com.epam.auto.ui.pages.BasePage;
import com.epam.auto.ui.pages.InboxPage;
import com.epam.auto.ui.pages.SentMailPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by ekaterinabut on 12/3/15.
 */
public class SentMailManager extends BaseManager {

    private InboxPage inboxPage;
    private BasePage basePage;
    private SentMailPage sentMailPage;
    public SentMailManager(WebDriver driver) {
    super(driver);
    }

    public void navigateToSendFolder() {
        basePage = new BasePage(driver);
        basePage.openSendMailFolder();
        sentMailPage = new SentMailPage(driver);
    }

    public String getSentMailListText() {
        return sentMailPage.sentMailList.getText();
    }
}
