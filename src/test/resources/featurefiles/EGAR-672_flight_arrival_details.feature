Feature:[EGAR-672] - Arrival page

  As a user
  I want to add arrival details on GAR
  So that necessary information is sent to HO

  Background:User on the page
    Given user is on "/welcome" page
    When "public" user logs in with username as "new1@testingworld.com" and password as "testing1234"

  @automated @EGAR-672
  Scenario: 1.) [EGAR-672] - User Can see Arrival details options on arrival page
    When I now click anchor link "Submit a GAR" on page
    Then I navigate to "Arrival details" page
    And I should see subject titles as "Date of arrival" on page
    And I should see subject titles as "Time of arrival" on page
    And I should also see Dropdown List "Arrival ICAO code"
    And I click a link "I don't know the arrival ICAO code"
    And I "Save and continue"
    Then I should successfully land on "Are there any hazardous or prohibited goods on board?" page
    And I now click anchor link "Sign out" on page

  @automated @EGAR-672 @EGAR-245
  Scenario: 2.) [EGAR-672] - User enters all required details and checks on Summary page
    When I now click anchor link "Submit a GAR" on page
    Then I navigate to "Arrival details" page
    And I see "Day" field then I enter "31" in "date-day"
    And I see "Month" field then I enter "12" in "date-month"
    And I see "Year" field then I enter "2018" in "date-year"
    When I see "Hour" field then I enter "23" in "hour"
    And I see "Minute" field then I enter "59" in "minute"
    And I "Save and continue"
    Then I should successfully land on "Are there any hazardous or prohibited goods on board?" page
    And I navigate to "GAR summary" page
    Then I check on GAR summary page if "Arrival details" feild asking user "Date of arrival:" on/of flight "31 12 2018"
    And I check on GAR summary page if "Arrival details" feild asking user "Time of arrival:" on/of flight "23 59"
    And I now click anchor link "Sign out" on page

  @automated @EGAR-672 @EGAR-245
  Scenario: 3.) [EGAR-672] - User only enters valid date and checks on Summary page
    When I now click anchor link "Submit a GAR" on page
    Then I navigate to "Arrival details" page
    And I see "Day" field then I enter "30" in "date-day"
    And I see "Month" field then I enter "11" in "date-month"
    And I see "Year" field then I enter "2018" in "date-year"
    And I "Save and continue"
    Then I should successfully land on "Are there any hazardous or prohibited goods on board?" page
    And I navigate to "GAR summary" page
    Then I check on GAR summary page if "Arrival details" feild asking user "Date of arrival:" on/of flight "30 11 2018"
    And I now click anchor link "Sign out" on page

  @automated @EGAR-672
  Scenario: 4.) [EGAR-672] - User only selects Arrival ICAO code and checks on Summary page
    When I now click anchor link "Submit a GAR" on page
    Then I navigate to "Arrival details" page
    And I see "Arrival ICAO" field then I enter "HAAB" in "arrival-icao"
    And I "Save and continue"
    Then I should successfully land on "Are there any hazardous or prohibited goods on board?" page
    And I navigate to "GAR summary" page
    Then I check on GAR summary page if "Arrival details" feild asking user "Arrival location:" on/of flight "HAAB"
    And I now click anchor link "Sign out" on page

  @automated @EGAR-672
  Scenario: 5.) [EGAR-672] - User does not know Arrival ICAO code and selects "I don't know the arrival ICAO code" and checks on Summary page
    When I now click anchor link "Submit a GAR" on page
    Then I navigate to "Arrival details" page
    Then I click a link "I don't know the arrival ICAO code"
    And I "Save and continue"
    Then I should successfully land on "Are there any hazardous or prohibited goods on board?" page
    And I navigate to "GAR summary" page
    Then I check on GAR summary page if "Arrival details" feild asking user "Arrival location:" on/of flight ""
    And I now click anchor link "Sign out" on page

  @automated @EGAR-672
  Scenario: 6.) [EGAR-672] - User selects "I don't know the arrival ICAO code" and selects Latitude and longitude and checks on Summary page
    When I now click anchor link "Submit a GAR" on page
    Then I navigate to "Arrival details" page
    And I click a link " I don't know the exact arrival ICAO code"
    ##@Depricated And I should confirm checkbox
    Then I choose "Latitude and longitude" option
    And I see "Arrival latitude" field then I enter "51.23" in "latitude"
    And I see "Arrival longitude" field then I enter "23.51" in "longitude"
    And I "Save and continue"
    Then I should successfully land on "Are there any hazardous or prohibited goods on board?" page
    And I navigate to "GAR summary" page
    Then I check on GAR summary page if "Arrival details" feild asking user "Arrival location:" on/of flight "51.23, 23.51"
    And I now click anchor link "Sign out" on page

  @automated @EGAR-672
  Scenario: 7.) [EGAR-672] - User selects "I don't know the arrival ICAO code" and selects IATA code and checks on Summary page
    When I now click anchor link "Submit a GAR" on page
    Then I navigate to "Arrival details" page
    And I click a link "I don't know the arrival ICAO code"
    ##@Depricated And I should confirm checkbox
    Then I choose "IATA code" option
    And I see "Arrival IATA code" field then I enter "NAC" in "arrival-iata"
    And I "Save and continue"
    Then I should successfully land on "Are there any hazardous or prohibited goods on board?" page
    And I navigate to "GAR summary" page
    Then I check on GAR summary page if "Arrival details" feild asking user "Arrival location:" on/of flight "NAC"
    And I now click anchor link "Sign out" on page

  # =====================REDUNDANT TEST SUITE =======================================================================#
  #  @automated @EGAR-672
  #  Scenario: 8.)[EGAR-672] - User selects "I don't know the Arrival ICAO code" and selects No Code and checks on Summary page
  #  When I now click anchor link "Submit a GAR" on page
  #  Then I navigate to "Arrival details" page
  #  And I saw "I don't know the arrival ICAO code" checkBox
  #  And I should confirm checkbox
  #  Then I choose "No location code" option
  #  And I see "Arrival location name" field then I enter "Biggin hill" in "location"
  #  And I "Save and continue"
  #  Then I should successfully land on "Are there any hazardous or prohibited goods on board?" page
  #  And I navigate to "GAR summary" page
  #  Then I check on GAR summary page if "Arrival details" feild asking user "Arrival location:" on/of flight "Biggin hill"
  #  And I now click anchor link "Sign out" on page
  #    ---------Below text is Previous title of Goods-----------------
  #  Are there any dangerous or hazardous goods on board?