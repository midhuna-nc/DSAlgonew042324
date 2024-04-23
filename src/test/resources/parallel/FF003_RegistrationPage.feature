@Register
Feature: Test new user register functionality

  Background: 
    Given User is already in the Register page

  @RP_TC_001
  Scenario Outline: User Register Validation with empty input fields
    When The user enters "<username>" and "<password>" and "<confirm password>" input fields with no values
    And User clicks the register button
    Then The validation message "Please fill out this field." appears below the input field.

    Examples: 
      | username | password | confirm password |
      |          |          |                  |
      | midhuna  |          |                  |
      |          | pwd@123  | pwd@123          |
      | Nallan   | abcd111  |                  |

  @RP_TC_002
  Scenario Outline: User Register validation with invalid values in the input fields
    When The user enters "<username>" and "<password>" and "<confirm password>" input fields with invalid values
    And User clicks the register button
    Then The user should able to see warning message "password_mismatch:The two password fields didn’t match"

    Examples: 
      | username | password | confirm password |
      | &&&&^!!  | pwd@123  | pwd@123          |
      | Nallan   |    12345 |            12345 |
      | midhuna  | pwd@123  | pwd1231          |
