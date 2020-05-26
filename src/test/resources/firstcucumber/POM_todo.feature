
Feature: Todo example
  Scenario: Hien thi cac item insert sau khi refress page
    Given Mo page todo
    And Insert vao textbox todo cac data ben duoi
      |item|
      |Cat |
      |Dog |
      |Duck|
      |Bear|
    When Refress page
    Then Thu tu cac item hien thi theo thu tu nhu luc insert