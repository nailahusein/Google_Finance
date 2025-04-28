package com.google_finance.pages;

import com.google_finance.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class GoogleFinancePage {

    public GoogleFinancePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//ul[@class=\"sbnBtf\"]//li//div[@class=\"COaKTb\"]")
    private List<WebElement> stockSymbols;

    public List<String> getStockSymbols() {
        List<String> retrievedSymbols = new ArrayList<>();
        for (WebElement symbol : stockSymbols) {
            retrievedSymbols.add(symbol.getText());
        }
        return retrievedSymbols;
    }




}
