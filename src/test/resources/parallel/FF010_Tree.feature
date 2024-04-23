Feature: Tree Functionality with login

  Background: 
    Given User has already Logged in
      | username | password |
      | SDET152  | Team@004 |
    Given The user is on the "NumpyNinja" Home Page
    When User clicks on Get Started button index 5
    Then User should be on "Tree" page

  @RegressionTest
  Scenario Outline: Try Editor validation for Tree with testcodes
    Given User is on the "Tree" Home Page of URL "https://dsportalapp.herokuapp.com/tree/"
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
      | Topic                          | Title                          | Try Here | SheetName  |
      | Overview of Trees              | Overview of Trees              | Try Here | pythonCode |
      | Terminologies                  | Terminologies                  | Try Here | pythonCode |
      | Types of Trees                 | Types of Trees                 | Try Here | pythonCode |
      | Tree Traversals                | Tree Traversals                | Try Here | pythonCode |
      | Traversals-Illustration        | Traversals-Illustration        | Try Here | pythonCode |
      | Binary Trees                   | Binary Trees                   | Try Here | pythonCode |
      | Types of Binary Trees          | Types of Binary Trees          | Try Here | pythonCode |
      | Implementation in Python       | Implementation in Python       | Try Here | pythonCode |
      | Binary Tree Traversals         | Binary Tree Traversals         | Try Here | pythonCode |
      | Implementation of Binary Trees | Implementation of Binary Trees | Try Here | pythonCode |
      | Applications of Binary trees   | Applications of Binary trees   | Try Here | pythonCode |
      | Binary Search Trees            | Binary Search Trees            | Try Here | pythonCode |
      | Implementation Of BST          | Implementation Of BST          | Try Here | pythonCode |
