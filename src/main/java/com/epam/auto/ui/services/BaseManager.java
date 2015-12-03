package com.epam.auto.ui.services;

import org.openqa.selenium.WebDriver;


/**
 * Created by ekaterinabut on 11/11/15.
 */
public abstract class BaseManager {

    protected WebDriver driver;

    public BaseManager(WebDriver driver) {
        this.driver = driver;
    }
}