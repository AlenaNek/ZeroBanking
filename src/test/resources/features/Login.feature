#Only authorized users should be able to login to the application.
# When user logs in with valid credentials, Account summary page should be displayed.
# Users with wrong username or wrong password should not be able to login.
# Users with blank username or password should also not be able to login.
# When user tries to login with invalid information,
# error message Login and/or password are wrong. should be displayed.
@login
Feature:Login
  As an authorized user,I should be able to login

Background:
Given I am on the login page


  Scenario:authorized users login
  When the user is logged in
  Then Account summary page should be displayed

  Scenario:Users with wrong username should not be able to login
  When I login with wrong username
  Then Error message should be displayed

  Scenario:Users with wrong password should not be able to login
    When I login with wrong password
    Then Error message should be displayed


  Scenario:Users with blank username or password should also not be able to login
    When I login with blank username
    Then Error message should be displayed


  Scenario:Users with blank username or password should also not be able to login
    When I login with blank password
    Then Error message should be displayed






