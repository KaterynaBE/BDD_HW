package com.epam.auto.ui.services;

import com.epam.auto.ui.pages.BasePage;
import org.openqa.selenium.WebDriver;

/**
 * Created by ekaterinabut on 12/6/15.
 */
public class DraftsManager extends BaseManager {

    private BasePage basePage;
    public DraftsManager(WebDriver driver) {
        super(driver);
    }

    public void navigateToDraftsFolder() {
        basePage = new BasePage(driver);
        basePage.openDraftsFolder();
    }
}
