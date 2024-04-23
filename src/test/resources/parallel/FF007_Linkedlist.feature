Feature: Linkedlist Functionality with login

  Background: 
    Given User has already Logged in
      | username | password |
      | SDET152  | Team@004 |
    Given The user is on the "NumpyNinja" Home Page
    When User clicks on Get Started button index 2
    Then User should be on "Linked List" page

  @RegressionTest
  Scenario Outline: Try Editor validation for Linkedlist with testcodes
    Given User is on the "Linked List" Home Page of URL "https://dsportalapp.herokuapp.com/linked-list/"
    When User click on '<Topic>'
    Then User should navigate to page that contains title '<Title>'
    When User clicks Try Here button of "<Topic>"
    And The user is on the "Assessment" Home Page
    When The user write code in Editor from sheetname '<SheetName>' and rownumber 0
    And Click the run button
    Then The user should able to see output in the console "hello"
    And The user is on the "Assessment" Home Page
    When The user write code in Editor from sheetname '<SheetName>' and rownumber 1
    And Click the run button
    Then The user should able to see an error message in alert window
    And The user is on the "Assessment" Home Page

    Examples: 
      | Topic                           | Title                           | Try Here | SheetName  |
      | Introduction                    | Introduction                    | Try Here | pythonCode |
      | Creating Linked LIst            | Creating Linked LIst            | Try Here | pythonCode |
      | Types of Linked List            | Types of Linked List            | Try Here | pythonCode |
      | Implement Linked List in Python | Implement Linked List in Python | Try Here | pythonCode |
      | Traversal                       | Traversal                       | Try Here | pythonCode |
      | Insertion                       | Insertion                       | Try Here | pythonCode |
      | Deletion                        | Deletion                        | Try Here | pythonCode |
