package com.stratio.numaqa.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

public class GovernancePage extends BasePage {

    By useCaseTitle = By.xpath("(//section[@class='section-duo-box ng-star-inserted'])[1]/descendant::div/descendant::h2");

    public GovernancePage(WebDriver driver) {
        super(driver);
    }

    public void checkPage(String expectedTitle) {
        Boolean loaded = (new WebDriverWait(driver, 10)).until(ExpectedConditions.titleIs(expectedTitle));
        assertTrue(loaded);
    }

    public void getFirstUseCaseAndPrintTitle() {
        WebElement useCase = this.driver.findElement(useCaseTitle);
        System.out.println("Use Case is: " + useCase.getText());
    }
}
