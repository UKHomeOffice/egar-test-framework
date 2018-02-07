Feature:[EGAR-484] - User wants to logout
  As a user
  I want to log out from my current logged in Session
  So that no unauthorised access can be taken

  Background:User on the page
    Given user is on "/welcome" page
    When "public" user logs in with username as "new1@testingworld.com" and password as "testing1234"

  @automated @EGAR-484
  Scenario:[EGAR-484] - 1  user logging out immediately after logged in
    When I now click anchor link "Sign out" on page
    Then I should successfully land on "Submit a General Aviation Report (GAR)" page
    And I navigate "back"
    Then I should not see "Sign out" anchor link on top

  @automated @EGAR-484
  Scenario:[EGAR-484] - 2 user logging out on Aircraft Detail page
    When I now click anchor link "Submit a GAR" on page
    And I should successfully land on "Aircraft details" page
    When I now click anchor link "Sign out" on page
    Then I should successfully land on "Submit a General Aviation Report (GAR)" page
    And I navigate "back"
    Then I should not see "Sign out" anchor link on top

  @automated @EGAR-484
  Scenario:[EGAR-484] - 3 user logging out on Departure details page
    When I now click anchor link "Submit a GAR" on page
    And I navigate to "Departure details" page
    When I now click anchor link "Sign out" on page
    Then I should successfully land on "Submit a General Aviation Report (GAR)" page
    And I navigate "back"
    Then I should not see "Sign out" anchor link on top

  @automated @EGAR-484
  Scenario:[EGAR-484] - 4 user logging out on Arrival details page
    When I now click anchor link "Submit a GAR" on page
    And I navigate to "Arrival details" page
    When I now click anchor link "Sign out" on page
    Then I should successfully land on "Submit a General Aviation Report (GAR)" page
    And I navigate "back"
    Then I should not see "Sign out" anchor link on top

  @automated @EGAR-484
  Scenario:[EGAR-484] - 5 user logging out on Goods declaration page
    When I now click anchor link "Submit a GAR" on page
    And I navigate to "Are there any hazardous or prohibited goods on board?" page
    When I now click anchor link "Sign out" on page
    Then I should successfully land on "Submit a General Aviation Report (GAR)" page
    And I navigate "back"
    Then I should not see "Sign out" anchor link on top

  @automated @EGAR-484
  Scenario:[EGAR-484] - 6 user logging out on People page
    When I now click anchor link "Submit a GAR" on page
    And I navigate to "Adding Captain, Crew and Passengers" page
    When I now click anchor link "Sign out" on page
    Then I should successfully land on "Submit a General Aviation Report (GAR)" page
    And I navigate "back"
    Then I should not see "Sign out" anchor link on top

  Scenario:[EGAR-484] - 6.1 user logging out from selecting type of person page
    When I now click anchor link "Submit a GAR" on page
    And I navigate to "Adding Captain, Crew and Passengers" page
    And I choose to "Add new"
    When I now click anchor link "Sign out" on page
    Then I should successfully land on "Submit a General Aviation Report (GAR)" page
    And I navigate "back"
    Then I should not see "Sign out" anchor link on top

  Scenario:[EGAR-484] - 6.2 user logging out from Information about captain page
    When I now click anchor link "Submit a GAR" on page
    And I navigate to "Adding Captain, Crew and Passengers" page
    And I choose to "Add new"
    And I choose "Captain" option
    Then I "Save and continue"
    When I now click anchor link "Sign out" on page
    Then I should successfully land on "Submit a General Aviation Report (GAR)" page
    And I navigate "back"
    Then I should not see "Sign out" anchor link on top

  @automated @EGAR-484
  Scenario:[EGAR-484] - 6.3 user logging out from Information about crew page
    When I now click anchor link "Submit a GAR" on page
    And I navigate to "Adding Captain, Crew and Passengers" page
    And I choose to "Add new"
    And I choose "Crew" option
    Then I "Save and continue"
    When I now click anchor link "Sign out" on page
    Then I should successfully land on "Submit a General Aviation Report (GAR)" page
    And I navigate "back"
    Then I should not see "Sign out" anchor link on top

  @automated @EGAR-484
  Scenario:[EGAR-484] - 6.4 user logging out from Information about passenger page
    When I now click anchor link "Submit a GAR" on page
    And I navigate to "Adding Captain, Crew and Passengers" page
    And I choose to "Add new"
    And I choose "Passenger" option
    Then I "Save and continue"
    When I now click anchor link "Sign out" on page
    Then I should successfully land on "Submit a General Aviation Report (GAR)" page
    And I navigate "back"
    Then I should not see "Sign out" anchor link on top

  @not-automated @EGAR-484
  Scenario:[EGAR-484] - 7 user logging out on Gar summary page
    When I now click anchor link "Submit a GAR" on page
    And I navigate to "GAR summary" page
    When I now click anchor link "Sign out" on page
    Then I should successfully land on "Submit a General Aviation Report (GAR)" page
    And I navigate "back"
    Then I should not see "Sign out" anchor link on top

  @not-automated @EGAR-484
  Scenario:[EGAR-484] - 8 user logging out on Submission page
    When I now click anchor link "Submit a GAR" on page
    And I navigate to "Submit GAR" page
    When I now click anchor link "Sign out" on page
    Then I should successfully land on "Submit a General Aviation Report (GAR)" page
    And I navigate "back"
    Then I should not see "Sign out" anchor link on top

  @automated @EGAR-484
  Scenario:[EGAR-484] - 9 user logging out on Manage a GAR page
    When I now click anchor link "Manage a GAR" on page
    Then I should successfully land on "Manage my GARs" page
    When I now click anchor link "Sign out" on page
    Then I should successfully land on "Submit a General Aviation Report (GAR)" page
    And I navigate "back"
    Then I should not see "Sign out" anchor link on top

  @not-to-run-becuase-of-bug-EGAR-1317 @EGAR-484
  Scenario:[EGAR-484] - 10 user logging out on My account page
    When I now click anchor link "My details" on page
    Then I should successfully land on "Update your details" page
    When I now click anchor link "Sign out" on page
    Then I should successfully land on "Submit a General Aviation Report (GAR)" page
    And I navigate "back"
    Then I should not see "Sign out" anchor link on top