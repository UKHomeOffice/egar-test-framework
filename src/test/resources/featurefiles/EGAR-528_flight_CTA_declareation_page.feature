@not-run @redundant
Feature:user on declares CTA status
  As a user
  I want to CTA
  So that if required Border force, police or customs can allow / stop access

  Background:User on the page
    Given user is on "/welcome" page
    Then I should successfully land on "Submit a general aviation report (GAR)" page
    And I navigate to "General Aviation Report (GAR)" page
    Then I now click anchor link "Submit a GAR" on page
    And I should successfully land on "Aircraft details" page

  @not-run @EGAR-528 @not-run @redundant
  Scenario:[EGAR-528] IN PROGRESS  User declares dangerous goods on egar
    When I navigate to "Is this flight within the Common travel area (CTA)?" page
    And I click a link "What flights are within the CTA?"
    And I can also see radio buttons "Yes" or "No"
    Then I choose "Yes" option
    And I "Save and continue"

  @not-run @EGAR-528 @not-run @redundant
  Scenario:[EGAR-528] IN PROGRESS  User declares no dangerous goods on egar
    When I navigate to "Is this flight within the Common travel area (CTA)?" page
    And I click a link "What flights are within the CTA?"
    And I can also see radio buttons "Yes" or "No"
    Then I choose "No" option
    And I "Save and continue"