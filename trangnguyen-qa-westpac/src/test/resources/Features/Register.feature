Feature: Test register account function

  Scenario Outline: User is unable to register for a new account using existing username
    Given user3 opens the browser and goes to <url>
    And user3 clicks register link
    When user3 enters existingUsername <existingUsername>
    And user3 enters firstName <firstName>
    And user3 enters lastName <lastName>
    And user3 enters valid password <password>
    And user3 enters valid confirmPassword <confirmPassword>
    And user3 clicks register button
    Then user3 encounters the errmsg <expectedValidationErrorMessage>

    Examples: 
      | url                           | existingUsername | firstName | lastName | password   | confirmPassword | expectedValidationErrorMessage               |
      | https://buggy.justtestit.org/ | camellia         | ABC       | XYZ      | Aa1234567@ | Aa1234567@      | UsernameExistsException: User already exists |
