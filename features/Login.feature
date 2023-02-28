Feature: Login with Valid Credentilas
 
@sanity
  Scenario: Successful Login with credentials
    Given User Launch Browser
    And opens url "https://www.facebook.com/"
    When I enter username as "9347066679" and password as "Bhavya@2000"
    And click on login
    Then navigates to account page
   

