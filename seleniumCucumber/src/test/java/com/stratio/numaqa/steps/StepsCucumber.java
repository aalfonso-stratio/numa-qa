package com.stratio.numaqa.steps;

import com.stratio.numaqa.page_objects.*;
import io.cucumber.java8.En;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class StepsCucumber implements En {

    WebDriver driver;

    public StepsCucumber()  {

        Before(()->{
            // Crear driver Chrome
            System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // Navegar a Google
            BasePage basePage = new BasePage(driver);
            basePage.navigateTo("http://www.google.com");
        });

        Given("we are in Google web page", () -> {
            // Aceptar cookies Google
            GooglePage googlePage = new GooglePage(driver);
            googlePage.acceptCookies();
        });

        Given("we are in Stratio web page and we accept cookies", () -> {
            StratioPage stratioPage = new StratioPage(driver);
            stratioPage.checkPageAndAcceptCookies("Stratio :: Transform and build your digital strategy around Big Data and AI");
        });

        Given("we are in Governance web page", () -> {
            GovernancePage govPage = new GovernancePage(driver);
            govPage.checkPage("Stratio :: Data reliability is the base of successful companies");
        });

        When("we search for {string}", (String text) -> {
            GooglePage googlePage = new GooglePage(driver);
            googlePage.searchSomething(text);
        });

        When("we click on Solutions drop down", () -> {
            StratioPage stratioPage = new StratioPage(driver);
            stratioPage.clickSolutions();
        });


        Then("the first result url is {string} and we click it", (String text) -> {
            // Comprobar primer link & click
            GoogleResultsPage resultsPage = new GoogleResultsPage(driver);
            resultsPage.checkFirstLinkAndClick(text);
        });

        Then("we click on Governance use case", () -> {
            StratioPage stratioPage = new StratioPage(driver);
            stratioPage.clickUseCaseGovernance();
        });

        Then("we print first use case title", () -> {
            GovernancePage govPage = new GovernancePage(driver);
            govPage.getFirstUseCaseAndPrintTitle();
        });

        After(()->{
            driver.close();
        });
    }

}
