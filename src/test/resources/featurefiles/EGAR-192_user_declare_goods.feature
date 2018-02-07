  Feature:[EGAR-192] - User on goods Deceleration page
  As a user
  I want to declare goods
  So that if required Border force, police or customs can allow / stop access

  Background:User on the page
    Given user is on "/welcome" page
    When "public" user logs in with username as "new1@testingworld.com" and password as "testing1234"

  @automated @EGAR-192 @EGAR-245
  Scenario:[EGAR-192]User declares dangerous goods on egar and checks on Summery page
    When I now click anchor link "Submit a GAR" on page
    And I navigate to "Are there any hazardous or prohibited goods on board?" page
    Then I click a link "What items are classified as dangerous or hazardous"
    And I can also see radio buttons "Yes" or "No"
    Then I choose "Yes" option
    And I "Save and continue"
    And I navigate to "GAR summary" page
    Then I check on GAR summary page if "Hazardous goods" feild asking user "Are there any dangerous or hazardous goods on board?" on/of flight "Yes"
    And I now click anchor link "Sign out" on page
    Then I should successfully land on "Submit a General Aviation Report (GAR)" page


  @automated @EGAR-192 @EGAR-245
  Scenario:[EGAR-192]User declares no dangerous goods on egar and checks on Summary page
    When I now click anchor link "Submit a GAR" on page
    And I navigate to "Are there any hazardous or prohibited goods on board?" page
    Then I click a link "What items are classified as dangerous or hazardous"
    And I can also see radio buttons "Yes" or "No"
    Then I choose "No" option
    And I "Save and continue"
    And I navigate to "GAR summary" page
    Then I check on GAR summary page if "Hazardous goods" feild asking user "Are there any dangerous or hazardous goods on board?" on/of flight "No"
    And I now click anchor link "Sign out" on page
    Then I should successfully land on "Submit a General Aviation Report (GAR)" page
    # =====================REDUNDANT BACKGROUND STEPS=====================================#
    # Then I should successfully land on "Submit a General Aviation Report (GAR)" page
    # And I "Start now"
    # And I click a link "Sign in with your email and password"
    # When I see "Email address" field then I enter "test@dev.egarteam.co.uk" as "username"
    # And I see "Password" field then I enter "abc123" as "password"
    # And I "Sign in"
    # Then I should successfully land on "Aircraft details" page