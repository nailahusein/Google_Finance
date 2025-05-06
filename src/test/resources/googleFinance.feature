Feature: Google Finance - Stock Symbol Comparison

  Scenario: Compare Stock Symbols from the page and expected list
  #  Given the user navigates to the Google Finance page
    When the user verifies that the page title contains "Google Finance"
    And the user retrieves the stock symbols and compares them with "expectedSymbols"
      | NFLX |
      | MSFT |
      | TSLA |
      | AAPL |
    Then print the stock symbols that are in the page but not in the expected list "expectedSymbols"
      | NFLX |
      | MSFT |
      | TSLA |
      | AAPL |
    And print the stock symbols that are in the expected list but not in the page "expectedSymbols"
      | NFLX |
      | MSFT |
      | TSLA |
      | AAPL |


