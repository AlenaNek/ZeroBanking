Feature: Add new payee under pay bills
  Background:

    Given the user is logged in
    And navigate to "Pay Bills" page

  Scenario: Add a new payee

Given  the user accesses the "Add New Payee" tab
And creates new payee using following information
  |Payee Name    | The Law Offices of Hyde, Price & Scharks|
  |Payee Address | 100 Same st, Anytown, USA, 10001        |
  |Account       | checking                               |
  |Payee details| XYZ account                             |
Then message "The new payee The Law Offices of Hyde, Price & Scharks was successfully created." should be displayed
