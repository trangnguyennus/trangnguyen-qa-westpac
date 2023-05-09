Feature: Test public voting function on Popular Model page

  Scenario Outline: User is unable to vote when they do not log in with valid credentials
    Given user4 opens the browser and goes to <url>
    When user4 clicks Popular Model
    Then user4 should not be able to vote or leave the comment about the model, and encounters <expectedMessage>

    Examples: 
      | url                           | expectedMessage                   |
      | https://buggy.justtestit.org/ | You need to be logged in to vote. |
