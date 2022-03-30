Feature: Selenium-Cucumber testing

  Scenario: Example
    Given we are in Google web page
    When we search for "Stratio"
    Then the first result url is "https://stratio.com/" and we click it

    Given we are in Stratio web page and we accept cookies
    When we click on Solutions drop down
    Then we click on Governance use case

    Given we are in Governance web page
    Then we print first use case title