package com.stratio.numaqa.page_objects;

import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return this.driver.getTitle();
    }

    public void navigateTo(String url) {
        this.driver.get(url);
    }
}
