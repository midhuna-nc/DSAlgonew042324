@BPage
Feature: Landing Page feature
  @BpageTC_001
  Scenario: Browser page
    When User enters the DSAlgo portal URL
    Then The user should landed on the DS_Algo Get Started page with message "You are at the right place"
    
  @BpageTC_001
  Scenario: DS Algo Get Started page
    Given The user should open the DS Algo Portal URL in any supported browser
    When The user clicks the "Get Started" button
    Then The user should land in Data Structure Introduction Page with "register" and "Sign in" links
