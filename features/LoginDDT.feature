Feature: Login with valid Credentials

  @sanity
  Scenario Outline: Successful Login with credentials
    Given User Launch Browser
    And opens url "https://www.facebook.com/"
    When I enter username as "<name>" and password as "<value>"
    And click on login
    Then navigates to account page

    Examples: 
      | name       | value       |
      | BHAVYA     | Bhavya      |
      | 9347066679 | Bhavya@2000 |
