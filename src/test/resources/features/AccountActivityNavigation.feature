
  @test
  Feature: Navigating to specific accounts in Accounts Activity

    Scenario Outline: <accountType> account redirect
      Given the user is logged in as "<userType>"
      And the user clicks on Online Banking menu
      And the user clicks on Account Summary page
      When the user clicks on "<accountType>"
      Then the Account Activity page should be displayed
      And Account drop down should have "<account>" selected

      Examples:
        |userType  |accountType      |account     |
        |user      |Savings          |Savings     |
        |user      |Brokerage        |Brokerage   |
        |user      |Checking         |Checking    |
        |user      |Credit Card      |Credit Card |
        |user      |Loan             |Loan        |



