Feature: Array Functionality with login

  Background: 
    Given User has already Logged in
      | username | password |
      | SDET152  | Team@004 |
    Given The user is on the "NumpyNinja" Home Page
    When User clicks on Data Structures dropdown arrow
    Then User should able to see six option in DataStructure Dropdown
    When User clicks on the Arrays List
    Then User should be on "Array" page

  @RegressionTest
  Scenario Outline: Try Editor validation for Array with testcodes
    Given User is on the "Arrays in Python" Home Page of URL "https://dsportalapp.herokuapp.com/array/arrays-in-python/"
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
      | Topic                     | Title                     | Try Here | SheetName  |
      | Arrays in Python          | Arrays in Python          | Try Here | pythonCode |
      | Arrays Using List         | Arrays Using List         | Try Here | pythonCode |
      | Basic Operations in Lists | Basic Operations in Lists | Try Here | pythonCode |
      | Applications of Array     | Applications of Array     | Try Here | pythonCode |

  @RegressionTest
  Scenario Outline: Practice Questions Validation with valid codes
    Given The user is on the "Practice Questions" page
    When User click on "<Practice_Topic>" page
    And User clear the text-editor
    When The user write code in PracQn Editor from sheetname '<SheetName>' and rownumber <RowNum>
    And Click the run button
    Then The user is on the "Assessment" Page1

    Examples: 
      | Practice_Topic                          | URL                                          | SheetName  | RowNum | Result             |
      | Search the array                        | https://dsportalapp.herokuapp.com/question/1 | pythonCode |      2 | not exist          |
      | Max Consecutive Ones                    | https://dsportalapp.herokuapp.com/question/2 | pythonCode |      4 |                  4 |
      | Find Numbers with Even Number of Digits | https://dsportalapp.herokuapp.com/question/3 | pythonCode |      6 |                  2 |
      | Squares of a Sorted Array               | https://dsportalapp.herokuapp.com/question/4 | pythonCode |      9 | [4, 9, 9, 49, 121] |
