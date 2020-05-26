Feature: Tim kiem voi google
  Scenario: Show result page with searched keyword
    Given The user is staying at google homepage
    When The user attempt to search the keyword "Testmaster.vn"
    Then The result page with "Testmaster.vn" on the title