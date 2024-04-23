@LoginPage
Feature: SignIn Page Functionality

  Background: 
    Given user is on Login Page

  @RegressionTest
  Scenario: Login page title
    When user gets the title of the page
    Then page title should be "Login"

  @RegressionTest
  Scenario: Login with correct credentials
    When user enters username "SDET152"
    And user enters password "Team@004"
    And user clicks on the Login button
    Then user gets the title of the page

  Scenario Outline: Login Page Validation with Valid input
    When User enters username "<Username>" and password "<Password>"
    And User Click on Login button
    Then User should navigate to HomePage with message "<Message>"

    Examples: 
      | Username | Password | Message           |
      | SDET152  | Team@004 | You are logged in |

  Scenario Outline: Login Page Validation with Invaid input
    When User enters username "<Username>" and password "<Password>"
    And User Click on Login button
    Then User should see alert message "<Alert_Message>"

    Examples: 
      | Username | Password | Alert_Message                 |
      |          |          | Please fill out this field    |
      | SDET152  |          | Please fill out this field    |
      |          | Team@004 | Please fill out this field    |
      | abc@123  | abc123   | Invalid Username and Password |
      | SDET152  | Team@222 | Invalid Username and Password |
      | ema      | Team@004 | Invalid Username and Password |
  