package com.google_finance.steps;

import com.google_finance.pages.GoogleFinancePage;
import com.google_finance.utility.BrowserUtils;
import com.google_finance.utility.ConfigurationReader;
import com.google_finance.utility.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class GoogleFinanceStepDefs {

    WebDriver driver = Driver.getDriver();
    GoogleFinancePage googleFinancePage = new GoogleFinancePage();
    List<String> retrievedSymbols = googleFinancePage.getStockSymbols();


    @Given("the user opens the Google Finance page")
    public void theUserOpensTheGoogleFinancePage() {
        driver.get(ConfigurationReader.getProperty("practice_url"));
        BrowserUtils.waitFor(3);
    }

    @Then("the page title should be {string}")
    public void thePageTitleShouldBe(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle), "Page title is incorrect.");
    }


    @When("the user retrieves the stock symbols and compares them with the expected stock symbols <expectedSymbols>")
    public void retrieveAndCompareStockSymbols(List<String> expectedStockSymbols) {
        Assert.assertTrue(retrievedSymbols.containsAll(expectedStockSymbols), "Expected stock symbols were not found.");
    }

    @And("print the stock symbols that are in the page but not in the expected list <expectedSymbols>")
    public void printSymbolsInPageNotInExpected(List<String> expectedStockSymbols) {
        List<String> notInExpected = new ArrayList<>(retrievedSymbols);
        notInExpected.removeAll(expectedStockSymbols);
        System.out.println("Stock symbols in the page but not in expected: " + notInExpected);
    }

    @And("print the stock symbols that are in the expected list but not in the page <expectedSymbols>")
    public void printSymbolsInExpectedNotInPage(List<String> expectedStockSymbols) {
        List<String> notInPage = new ArrayList<>(expectedStockSymbols);
        notInPage.removeAll(retrievedSymbols);
        System.out.println("Stock symbols in the expected list but not in the page: " + notInPage);
    }
}
