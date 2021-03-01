Feature: Check title contains searched word

  Scenario: Verify that title contains search word
    Given I am on the 'google.com' page
    When Enter 'automation' in the search field and click search button
    And Open first result page
    Then Check that title contains 'automation' word
