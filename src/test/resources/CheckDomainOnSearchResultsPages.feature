Feature: Check expected domain

  Scenario: Verify that expected domain is present on result pages
    Given I am on the google.com page
    When Enter 'automation' in the search field and click search button
    Then Check that expected domain 'testautomationday.com' on search 5 results pages