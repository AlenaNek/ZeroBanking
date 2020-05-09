Feature: Purchase Foreign Currency

  Background:
    Given the user is logged in
    And navigate to "Pay Bills" page

Scenario: Available currencies
Given the user accesses the "Purchase foreign currency" tab
Then following currencies should be available
|Australia (dollar) |
|Canada (dollar) |
|Switzerland (franc) |
|China (yuan) |
|Denmark (krone) |
|Eurozone (euro) |
|Great Britain (pound)|
|Japan (yen) |
|Mexico (peso) |
|Norway (krone) |
|New Zealand (dollar) |
|Singapore (dollar) |

  Scenario: Error message for not selecting currency
    Given the user accesses the "Purchase foreign currency" tab
    When user clicks on Calculate cost button
    Then error message "Please, ensure that you have filled all the required fields with valid values." should be displayed

  Scenario: Error message for not entering value
    Given the user accesses the "Purchase foreign currency" tab
    When user clicks on Calculate cost button
    Then error message "Please, ensure that you have filled all the required fields with valid values." should be displayed