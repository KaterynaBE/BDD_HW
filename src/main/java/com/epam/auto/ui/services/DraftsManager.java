package com.epam.auto.ui.services;

import com.epam.auto.ui.pages.BasePage;
import com.epam.auto.ui.pages.DraftsPage;
import com.epam.auto.ui.pages.NewMessagePopup;
import org.openqa.selenium.WebDriver;

/**
 * Created by ekaterinabut on 12/6/15.
 */
public class DraftsManager extends BaseManager {

    private BasePage basePage;
    private DraftsPage draftsPage;
    private NewMessagePopup newMessagePopup;
    public DraftsManager(WebDriver driver) {
        super(driver);
    }

    public void navigateToDraftsFolder() {
        basePage = new BasePage(driver);
        basePage.openDraftsFolder();
    }

    public void openAndSendDraft() {
        draftsPage = new DraftsPage(driver);
        draftsPage.openDraft();
        newMessagePopup = new NewMessagePopup(driver);
        newMessagePopup.clickSendButton();
    }
}