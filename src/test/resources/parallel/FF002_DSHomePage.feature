@HomePage
Feature: DS Indtroduction Home Page without logging into it
  @HomePageTC001
  Scenario: DataStructures Dropdown validation
    Given User is on the Data Structures Home Page
    When User clicks the data structure dropdown arrow
    Then User should see the list of six options in the DS dropdown arrow
    When User selects any DS item from dropdown without sign in
    Then User should see the error message "You are not logged in"
    
  @HomePageTC002
  Scenario: GetStarted buttons of DataStructures 
    Given User is on the Data Structures Home Page
    When User clicks on GET Started button of  any DataStructures items without sign in
    Then User should see the error message "You are not logged in"
    
   @HomePageTC003
  Scenario: Register link on DS Home Page
    Given User is on the Data Structures Home Page
    When User clicks the Register link on DS Algo Intoduction Home page
    Then User should be redirected to Register page and see the Login link at the bottom of the page
   
  Scenario:  SignIn link on DS Home Page
  Given User is on the Data Structures Home Page
  When User clicks the SignIn link on DS Algo Intoduction Home page
  Then User should be redirected to SignIn page and User should see the Register link at the bottom of the page
  
  

    