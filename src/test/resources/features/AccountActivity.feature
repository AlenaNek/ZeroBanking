Feature: Account Activity

  Background:
    Given the user is logged in
    And navigate to "Account activity" page

  Scenario: Account Activity Page Title
    Then verify that page title is "Zero - Account Activity"

    Scenario: Verify account drop down default option
      Then Account drop down should have Savings selected

  Scenario: Verify Account drop down options
    Then verify that Account drop down has
      |Savings    |
      |Checking   |
      |Savings    |
      |Loan       |
      |Credit Card|
      |Brokerage  |

    Scenario: Verify Transactions table column names are displayed
      Then verify Transactions table options are displayed
    |Date       |
    |Description|
    |Deposit    |
    |Withdrawal |



