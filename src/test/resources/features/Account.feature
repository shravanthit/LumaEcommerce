Feature: Account Page Feature

  Background:
    Given  user has already logged into application
    |username| password|

  Scenario: Accounts page title
    Given user is on Accounts page
    When user gets the title of the page
    Then page title should be "My account"
