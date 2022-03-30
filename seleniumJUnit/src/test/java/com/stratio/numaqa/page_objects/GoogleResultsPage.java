package com.stratio.numaqa.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleResultsPage extends BasePage {

    By first_result_url = By.xpath("(//div[@id='search']/descendant::div[@class='g tF2Cxc']/descendant::a)");

    public GoogleResultsPage(WebDriver driver) {
        super(driver);
    }

    public void checkFirstLinkAndClick(String url) {
        WebElement firstResult = driver.findElement(first_result_url);
        assertEquals(url, firstResult.getAttribute("href"));
        firstResult.click();
    }


}
