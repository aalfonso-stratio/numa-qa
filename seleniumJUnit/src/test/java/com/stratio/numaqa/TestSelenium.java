package com.stratio.numaqa;

import com.stratio.numaqa.page_objects.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSelenium {

//    ChromeDriver driver;
    FirefoxDriver driver;

    @BeforeEach
    public void starting() {
//        // Crear driver Chrome
//        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver");
//        this.driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Crear driver Firefox
        System.setProperty("webdriver.gecko.driver", "src/drivers/geckodriver");
        File pathBinary = new File("/home/aalfonso/Apps/firefox/firefox");
        FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(false);
        options.setCapability("marionette", true);
        options.setBinary(firefoxBinary);
        this.driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Navegar a Google
        BasePage basePage = new BasePage(driver);
        basePage.navigateTo("http://www.google.com");
    }

    @Test
    public void testNuma() {
        // Aceptar cookies Google
        GooglePage googlePage = new GooglePage(driver);
        googlePage.acceptCookies();

        // Buscar Stratio
        googlePage.searchSomething("Stratio");
        Boolean loaded = (new WebDriverWait(driver, 10)).until(ExpectedConditions.titleIs("Stratio - Buscar con Google"));
        assertTrue(loaded);

        // Comprobar primer link & click
        GoogleResultsPage resultsPage = new GoogleResultsPage(driver);
        resultsPage.checkFirstLinkAndClick("https://stratio.com/");

        // Comprobar que estamos en web de Stratio y aceptar cookies
        StratioPage stratioPage = new StratioPage(driver);
        stratioPage.checkPageAndAcceptCookies("Stratio :: Transform and build your digital strategy around Big Data and AI");

        // Hacer click en Drop-down 'Solutions'
        stratioPage.clickSolutions();

        // Entrar en Governance
        stratioPage.clickUseCaseGovernance();

        // Comprobar que estamos en página de Governance
        GovernancePage govPage = new GovernancePage(driver);
        govPage.checkPage("Stratio :: Data reliability is the base of successful companies");

        // Obtener título de primer Use Case e imprimir por pantalla
        govPage.getFirstUseCaseAndPrintTitle();
    }

    @AfterEach
    public void finishing() {
        driver.close();
    }
}
