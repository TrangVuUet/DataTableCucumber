Feature: Data table
  
  Verify that the new user registration is unsuccessful after passing incorrect inputs.

  Scenario: 
    Given I am on the new user registration page
    When I enter invalid data on the page
      | Fields                 | Values              |
      | First Name             | Tom                 |
      | Last Name              | Kenny               |
      | Email Address          | someone@someone.com |
      | Re-enter Email Address | someone@someone.com |
      | Password               | Password1           |
      | Birthdate              |                  01 |
    Then the user registration should be unsuccessful
