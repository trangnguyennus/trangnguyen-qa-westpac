Feature: Test logout function

  Scenario Outline: User is able to logout successfully right after logging in
    Given user2 opens the browser and goes to <url>
    When user2 enters <username> and <password>
    And user2 clicks login button
    When user2 clicks logout navigation link
    Then user2 is able to logout successfully

    Examples: 
      | url                           | username | password  |
      | https://buggy.justtestit.org/ | camellia | Aa123456@ |
