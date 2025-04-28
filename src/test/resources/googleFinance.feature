Feature: Validate Stock Symbols on Google Finance

  Scenario Outline: Verify stock symbols from Google Finance match expected list
    Given the user opens the Google Finance page
    Then the page title should be "Google Finance"
    When the user retrieves the stock symbols and compares them with the expected stock symbols <expectedSymbols>
    And print the stock symbols that are in the page but not in the expected list <expectedSymbols>
    And print the stock symbols that are in the expected list but not in the page <expectedSymbols>


    Examples:
      | expectedSymbols               |
      | ["NFLX", "MSFT", "TSLA"]      |
      | ["AAPL", "GOOGL", "AMZN"]     |
      | ["FB", "TWTR", "SPY", "NFLX"] |
