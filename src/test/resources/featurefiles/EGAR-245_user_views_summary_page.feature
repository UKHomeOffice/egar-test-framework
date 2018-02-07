Feature:[EGAR-245] Summary Page

  As a user
  I want to view Summary page
  So that what I have added and not added to GAR can be seen clearly

  Background:User starting from Start Page and then navigating to
    Given user is on "/welcome" page
    When "public" user logs in with username as "new1@testingworld.com" and password as "testing1234"

  @automated @EGAR-245
  Scenario:[EGAR-245] User on Summary page checks if the all the summary fields are available or not
    When I now click anchor link "Submit a GAR" on page
    Given I navigate to "GAR summary" page
    And user finds details related to "GAR Reference" and others similer feilds
    And user finds details related to "Flight Status" and others similer feilds
    And user finds details related to "Aircraft details" and others similer feilds
    And user finds details related to "Departure details" and others similer feilds
    And user finds details related to "Arrival details" and others similer feilds
    And user finds details related to "Hazardous goods" and others similer feilds
    And user finds details related to "Captain details" and others similer feilds
    And user finds details related to "Crew details" and others similer feilds
    And user finds details related to "Passenger details" and others similer feilds
    And I now click anchor link "Sign out" on page