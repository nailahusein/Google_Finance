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
import java.util.Arrays;
import java.util.List;

public class GoogleFinanceStepDefs {

    WebDriver driver = Driver.getDriver();
    GoogleFinancePage googleFinancePage = new GoogleFinancePage();
    List<String> retrievedSymbols = googleFinancePage.getStockSymbols();

    @Given("the user navigates to the Google Finance page")
    public void the_user_navigates_to_the_google_finance_page() {
        driver.get(ConfigurationReader.getProperty("url"));
        BrowserUtils.waitFor(3);
    }

    @When("the user verifies that the page title contains {string}")
    public void theUserVerifiesThatThePageTitleContains(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle), "Page title is incorrect.");
    }

    @And("the user retrieves the stock symbols and compares them with {string}")
    public void the_user_retrieves_the_stock_symbols_and_compares_them_with (String string, List < String > expectedStockSymbols){
            System.out.println(retrievedSymbols);
            System.out.println(expectedStockSymbols);

            List<String> matchingSymbols = new ArrayList<>();

            for (String symbol : expectedStockSymbols) {
                if (retrievedSymbols.contains(symbol)) {
                    matchingSymbols.add(symbol);
                }
            }

            System.out.println("Matching stock symbols: " + matchingSymbols);

            Assert.assertFalse(matchingSymbols.isEmpty(), "No matching symbols found!");
    }

        @Then("print the stock symbols that are in the page but not in the expected list {string}")
        public void print_the_stock_symbols_that_are_in_the_page_but_not_in_the_expected_list (String
        string, List < String > expectedStockSymbols){
            List<String> notInExpected = new ArrayList<>(retrievedSymbols);
            notInExpected.removeAll(expectedStockSymbols);
            System.out.println("Stock symbols in the page but not in expected: " + notInExpected);
        }
        @Then("print the stock symbols that are in the expected list but not in the page {string}")
        public void print_the_stock_symbols_that_are_in_the_expected_list_but_not_in_the_page (String
        string, List < String > expectedStockSymbols){
            List<String> notInPage = new ArrayList<>(expectedStockSymbols);
            notInPage.removeAll(retrievedSymbols);
            System.out.println("Stock symbols in the expected list but not in the page: " + notInPage);
        }

}

