Feature: Test view a table of all models of the popular make

  Scenario Outline: User is able to see a table of all models of the popular make without logging in with valid credentials
    Given user5 opens the browser and goes to <url>
    When user5 clicks on popular make card
    Then user5 is able to see a table of all models of the popular make

    Examples: 
      | url                           |
      | https://buggy.justtestit.org/ |
