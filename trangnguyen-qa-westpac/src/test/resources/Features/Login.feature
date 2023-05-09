Feature: Test login function

  Scenario Outline: User is able to login successfully with valid credentials
    Given user1 opens the browser and goes to <url>
    When user1 enters <username> and <password>
    And user1 clicks login button
    Then user1 is able to login successfully

    Examples: 
      | url                           | username | password  |
      | https://buggy.justtestit.org/ | camellia | Aa123456@ |
