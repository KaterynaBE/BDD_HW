package com.epam.auto.patterns.decorator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

/**
 * WebDriver decorator.
 */
public class CustomWebDriver implements WebDriver {

    protected WebDriver driver;

    public CustomWebDriver(WebDriver driver) {
        this.driver = driver;
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public String getPageSource() {
        return driver.getPageSource();
    }

    public void close() {
        driver.close();
    }

    // This method was updated on CustomWebDriver on demo purposes.
    public void quit() {
        System.out.println("Testing completed. See results below.");
        driver.quit();
    }

    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    public TargetLocator switchTo() {
        return driver.switchTo();
    }

    public void get(String url) {
        driver.get(url);
    }

    public Navigation navigate() {
        return driver.navigate();
    }

    public Options manage() {
        return driver.manage();
    }

    // Accept alert if present was created to usefully distinct CustomWebDriver from WebDriver.
    public boolean isAlertPresent(){
        try{
            driver.switchTo().alert();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public void acceptAlert()
    {
        if(isAlertPresent()){
            driver.switchTo().alert().accept();
        }
    }
}