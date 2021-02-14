
  @test
  Feature: Find Transactions in Account Activity

    Scenario: Search date range
      Given the user accesses the Find Transactions tab
      When the user enters date range from "2012-09-01" to "2012-09-06"
      And clicks search
      Then results table should only show transactions dates between "2012-09-01" to "2012-09-06"
      And the results should be sorted by most recent date
      When the user enters date range from "2012-09-02" to " 2012-09-06"
      And clicks search
      Then results table should only show transactions dates between "2012-09-02" to " 2012-09-06"
      And the results table should only not contain transactions dates "2012-09-01"



    Scenario Outline: Search description results for <description>
      Given the user accesses the Find Transactions tab
      When the user enters description "<description>"
      And clicks search
      Then results table should only show descriptions containing "<resultsTableContains>"
      But results table should not show descriptions containing "<resultsTableNotContains>"

      Examples:
        |description  |resultsTableContains|resultsTableNotContains|
        |ONLINE       |ONLINE              |OFFICE                 |
        |OFFICE       |OFFICE              |ONLINE                 |
        |online       |ONLINE              |OFFICE                 |




    Scenario: Type
      Given the user accesses the Find Transactions tab
      When user selects type "Deposit"
      And clicks search
      Then results table should show at least one result under Deposit
      But results table should show no result under Withdrawal
      When user selects type "Withdrawal"
      And clicks search
      Then results table should show at least one result under Withdrawal
      But results table should show no result under Deposit


