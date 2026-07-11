Feature: Login Functionality
  As a user
  I want to login to the application
  So that I can access the dashboard

  Scenario: Successful login with valid credentials
    Given User is on the login page
    When User enters valid email and password
    And User clicks the login button
    Then User should be redirected to the dashboard

  Scenario: Failed login with invalid credentials
    Given User is on the login page
    When User enters invalid email and password
    And User clicks the login button
    Then User should see an error message
