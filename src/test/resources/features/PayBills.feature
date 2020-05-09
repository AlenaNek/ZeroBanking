Feature: Pay Bills
  Background:
    Given the user is logged in
    And I navigate to "Pay Bills" page

  Scenario: Pay Bills Page Title
    Then verify that page title is "Zero - Pay Bills"

  Scenario: Verify successful pay operation
    When user selects random payee option
    And user selects random account option
    And user enters random amount
    And user enters valid date
    And user clicks on pay button
    Then "The payment was successfully submitted." message should be displayed.


  Scenario: Verify failed pay operation
    When user selects random payee option
    And user selects random account option
    And user clicks on pay button
    Then "Please fill out this field message!" alert message should be displayed.