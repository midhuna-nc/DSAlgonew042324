Feature: Graph Functionality with login

  Background: 
    Given User has already Logged in
      | username | password |
      | SDET152  | Team@004 |
    Given The user is on the "NumpyNinja" Home Page
    When User clicks on Get Started button index 6
    Then User should be on "Graph" page

  @RegressionTest
  Scenario Outline: Try Editor validation for Graph with testcodes
    Given User is on the "Graph" Home Page of URL "https://dsportalapp.herokuapp.com/graph/"
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
    When User click back button and navigate to URL "https://dsportalapp.herokuapp.com/graph/graph-representations/"
    And User click on Signout button
    Then The user is on the "NumpyNinja" Home Page

    Examples: 
      | Topic                 | Title                 | Try Here | SheetName  |
      | Graph                 | Graph                 | Try Here | pythonCode |
      | Graph Representations | Graph Representations | Try Here | pythonCode |
