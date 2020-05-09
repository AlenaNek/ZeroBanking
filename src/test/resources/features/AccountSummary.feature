
Feature: Account Summary


Background:
  Given the user is logged in
  And navigate to "Account Summary" page

Scenario: Account Summary Page Title
  Then verify that page title is "Zero - Account Summary"

  Scenario: Account types
    And verifies that account types are displayed
      | Cash Accounts |
      | Investment Accounts |
      | Credit Accounts |
      | Loan Accounts |

  Scenario: Credit Accounts table
  Then verifies that column names are displayed on Credits Accounts table
  | Account |
  | Credit Card |
  | Balance |

