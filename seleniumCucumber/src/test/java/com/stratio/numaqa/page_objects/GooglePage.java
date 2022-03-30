package com.stratio.numaqa.page_objects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GooglePage extends BasePage {

    By searchBar = By.name("q");
    By acceptButton = By.id("L2AGLb");

    public GooglePage(WebDriver driver) {
        super(driver);
    }

    public void acceptCookies() {
        WebElement acceptCookiesButton = this.driver.findElement(acceptButton);
        acceptCookiesButton.click();
    }

    public void searchSomething(String searchText) {
        WebElement searchBarElement = this.driver.findElement(searchBar);
        searchBarElement.sendKeys(searchText);
        searchBarElement.sendKeys(Keys.ENTER);
    }
}
