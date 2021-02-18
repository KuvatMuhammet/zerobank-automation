@test
Feature: Login as different users

@wip
  Scenario: login as an authorized user
    Given the user is on the login page
    When the user logs in using "username" and "password"
    Then the user should be able to login
    Then the title contains "Zero Bank"


  Scenario Outline: login with invalid information <userType>
    Given the user is on the login page
    When the user logs in using "<userName>" and "<passWord>"
    Then the error message "<errorMessage>" should be displayed
    Examples:
      |userType |userName  |passWord | errorMessage                      |
      |user1    |KKMM      |password | Login and/or password are wrong.  |
      |user2    |username  |KKMM123  | Login and/or password are wrong.  |
      |user3    |          |password | Login and/or password are wrong.  |
      |user4    |username  |         | Login and/or password are wrong.  |


