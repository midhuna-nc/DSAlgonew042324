Feature: Queue Functionality with login

  Background: 
    Given User has already Logged in
      | username | password |
      | SDET152  | Team@004 |
    Given The user is on the "NumpyNinja" Home Page
    When User clicks on Get Started button index 4
    Then User should be on "Queue" page

  @RegressionTest
  Scenario Outline: Try Editor validation for Queue with testcodes
    Given User is on the "Queue" Home Page of URL "https://dsportalapp.herokuapp.com/queue/"
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
      | Topic                                  | Title                                  | Try Here | SheetName  |
      | Implementation of Queue in Python      | Implementation of Queue in Python      | Try Here | pythonCode |
      | Implementation using collections.deque | Implementation using collections.deque | Try Here | pythonCode |
      | Implementation using array             | Implementation using array             | Try Here | pythonCode |
      | Queue Operations                       | Queue Operations                       | Try Here | pythonCode |
