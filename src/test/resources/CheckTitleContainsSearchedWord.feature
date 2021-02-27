Feature: Check title contains searched word

  Scenario: Verify that title contains search word
    Given I am on the google.com page
    When I enter 'automation' in the search field and click search button
    Then I check that title contains search word
