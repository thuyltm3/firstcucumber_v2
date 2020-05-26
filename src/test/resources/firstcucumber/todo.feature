Feature: Data table example
  @Sprint3
  Scenario: Show inserted item after refresh page
    Given The Todo page is open
    And The data as below list already inserted
      |item|
      |Cat |
      |Dog |
      |Duck|
      |Bear|
    When The user refresh the page
    Then The list with inserted items is displayed