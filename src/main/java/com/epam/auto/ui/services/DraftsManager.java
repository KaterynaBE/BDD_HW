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
    public DraftsManager(WebDriver driver) {
        super(driver);
    }

    public void navigateToDraftsFolder() {
        basePage = new BasePage(driver);
        basePage.openDraftsFolder();
    }

    public void openDraftsFolder() {
        draftsPage = new DraftsPage(driver);
        draftsPage.openDraft();
    }

    public String getDraftsListText() {
        return draftsPage.itemInDrafts.getText();
    }
}