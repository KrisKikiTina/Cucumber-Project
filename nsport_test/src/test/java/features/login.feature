Feature: Website testing
  Scenario: Check Login Page
    Given Navigate to home page
    And Navigate to login page
    When Click Login button
    Then Validate login error message
    When Enter login email
    And Enter login password
    When Click login button
    Then Login confirmation
    And Website is closed

