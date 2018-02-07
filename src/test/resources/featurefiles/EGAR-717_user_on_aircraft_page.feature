Feature:[EGAR-717] - User on Aircraft Page

  As a user
  I want to enter Aircraft Details on GAR
  So that important information related to Aircraft can be informed to Border Force

  Background:User on the page
    Given user is on "/welcome" page
    When "public" user logs in with username as "new1@testingworld.com" and password as "testing1234"

  @automated @EGAR-717 @EGAR-245 @EGAR-525
  Scenario:[EGAR-717] Registered user on Aircraft Details page able to view required fields, button and enters details to Saves the GAR as draft
    When I now click anchor link "Submit a GAR" on page
    Then I should successfully land on "Aircraft details" page
    And I see "Aircraft registration" field then I enter "ATR123" in "aircraft-registration"
    And I see "Type of aircraft" field then I enter "Boeing passenger" in "aircraft-type"
    And I see "Usual base of aircraft" field then I enter "Biggin Hill" in "aircraft-base"
    And I can also see radio buttons "Yes" or "No" asking if the due taxes are paid
    Then I choose "Yes" option
    And I "Save and continue"
    And I navigate to "GAR summary" page
    Then I check on GAR summary page if "Aircraft details" feild asking user "Aircraft Registration:" on/of flight "ATR123"
    And I check on GAR summary page if "Aircraft details" feild asking user "Type of Aircraft:" on/of flight "Boeing passenger"
    And I check on GAR summary page if "Aircraft details" feild asking user "Usual base of aircraft:" on/of flight "Biggin Hill"
    And I check on GAR summary page if "Aircraft details" feild asking user "Have all taxes due on the aircraft been paid and accounted for within the UK?" on/of flight "Yes"
    And I now click anchor link "Sign out" on page
    Then I should successfully land on "Submit a General Aviation Report (GAR)" page

    