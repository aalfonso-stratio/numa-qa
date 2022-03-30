package com.stratio.numaqa.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class StratioPage extends BasePage {

    By acceptCookiesButton = By.xpath("//*[@id=\"cookies\"]/div/div[2]/button[1]");
    By dropDown = By.xpath("(//div[@class='menu-option option-solutions npa-font--14 ng-tns-c11-0 ng-star-inserted'])");
    By useCase = By.xpath("(//div[@class='npa-dropdown__group ng-star-inserted']/descendant::div[@class='npa-dropdown__option npa-dropdown__option-3 ng-star-inserted'])[2]");

    public StratioPage(WebDriver driver) {
        super(driver);
    }

    public void checkPageAndAcceptCookies(String title) {
        assertEquals(title, driver.getTitle());
        WebElement acceptButton = driver.findElement(acceptCookiesButton);
        acceptButton.click();
    }

    public void clickSolutions() {
        WebElement dropDownSolutions = driver.findElement(dropDown);
        dropDownSolutions.click();
    }

    public void clickUseCaseGovernance() {
        WebElement useCaseGovernance = driver.findElement(useCase);
        useCaseGovernance.click();
    }
}
