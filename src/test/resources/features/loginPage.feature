Feature: Login Page feature

  Scenario: Login with correct credentials
    Given the user is on signIn page
    When the user enters username "sraavanthi.thuma@gmail.com"
    And the user enters password "Shrav@123"
    And user clicks on Login button
    Then user is succesfully loggedIn
