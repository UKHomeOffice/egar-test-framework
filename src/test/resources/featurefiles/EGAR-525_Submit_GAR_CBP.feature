Feature: [EGAR - 525] User submits GAR to CBP

  As a user
  I want to submit a GAR to CBP

  Background:User on the page
    Given user is on "/welcome" page
    And "public" user logs in with username as "new1@testingworld.com" and password as "testing1234"

 @automated @EGAR-525 @EGAR-245
  Scenario:[EGAR - 525] User enters valid details in all feilds of GAR and then submits the GAR
    When I now click anchor link "Submit a GAR" on page
    Then user lands on "Aircraft details" and fills all valid details
    And user lands on "Departure details" and fills all valid details
    Then user lands on "Arrival details" and fills all valid details
    And user lands on "Are there any hazardous or prohibited goods on board?" and fills all valid details
    Then user lands on "Adding Captain, Crew and Passengers" and fills all valid details
    And user lands on "Would you like to add any supporting files to accompany your GAR submission?" and fills all valid details
    And user lands on "GAR summary" and fills all valid details
    And user lands on "Submit GAR" and fills all valid details
    Then I should be able to view "Submission complete" success message
    And I now click anchor link "Sign out" on page