Feature:[EGAR-714] - Departure page

  As a user
  I want to add departure details on GAR
  So that necessary information is sent to HO

  Background:User on the page
    Given user is on "/welcome" page
    When "public" user logs in with username as "new1@testingworld.com" and password as "testing1234"

  @automated @EGAR-714
  Scenario: 1.) [EGAR-714] - User Can see departure details options on departure page
    When I now click anchor link "Submit a GAR" on page
    And I navigate to "Departure details" page
    Then I should see subject titles as "Date of departure" on page
    And I should see subject titles as "Time of departure" on page
    And I should also see Dropdown List "Departure ICAO code"
    And I click a link "I don't know the departure ICAO code"
    And I "Save and continue"
    And I now click anchor link "Sign out" on page
    Then I should successfully land on "Submit a General Aviation Report (GAR)" page

  @automated @EGAR-714 @EGAR-245
  Scenario: 2.) [EGAR-714] - User enters date and Time on depature page and checks on Summary Page
    When I now click anchor link "Submit a GAR" on page
    And I navigate to "Departure details" page
    Then I see "Day" field then I enter "31" in "date-day"
    And I see "Month" field then I enter "12" in "date-month"
    And I see "Year" field then I enter "2018" in "date-year"
    When I see "Hour" field then I enter "00" in "hour"
    And I see "Minute" field then I enter "01" in "minute"
    And I "Save and continue"
    And I navigate to "GAR summary" page
    Then I check on GAR summary page if "Departure details" feild asking user "Date of departure:" on/of flight "31 12 2018"
    And I check on GAR summary page if "Departure details" feild asking user "Time of departure:" on/of flight "00 01"
    And I now click anchor link "Sign out" on page
    Then I should successfully land on "Submit a General Aviation Report (GAR)" page

  @automated @EGAR-714 @EGAR-245
  Scenario: 3.) [EGAR-714] - User only enters valid date on depature page and checks on Summary Page
    When I now click anchor link "Submit a GAR" on page
    And I navigate to "Departure details" page
    Then I see "Day" field then I enter "30" in "date-day"
    And I see "Month" field then I enter "11" in "date-month"
    And I see "Year" field then I enter "2018" in "date-year"
    And I "Save and continue"
    And I navigate to "GAR summary" page
    Then I check on GAR summary page if "Departure details" feild asking user "Date of departure:" on/of flight "30 11 2018"
    And I now click anchor link "Sign out" on page
    Then I should successfully land on "Submit a General Aviation Report (GAR)" page

  @automated @EGAR-714 @EGAR-245
  Scenario: 4.) [EGAR-714] - User only selects Depature ICAO code on depature page and checks on Summary Page
    When I now click anchor link "Submit a GAR" on page
    And I navigate to "Departure details" page
    And I see "Departure ICAO" field then I enter "HAAL" in "departure-icao"
    And I "Save and continue"
    And I navigate to "GAR summary" page
    Then I check on GAR summary page if "Departure details" feild asking user "Departure location:" on/of flight "HAAL"
    And I now click anchor link "Sign out" on page
    Then I should successfully land on "Submit a General Aviation Report (GAR)" page

  @automated @EGAR-714 @EGAR-245
  Scenario: 5.) [EGAR-714] - User does not know Depature ICAO code and selects "I don't know the departure ICAO code" on depature page and checks on Summary Page
    When I now click anchor link "Submit a GAR" on page
    And I navigate to "Departure details" page
    Then I click a link "I don't know the departure ICAO code"
    ## @Depricated And I should confirm checkbox
    And I "Save and continue"
    And I navigate to "GAR summary" page
    Then I check on GAR summary page if "Departure details" feild asking user "Departure location:" on/of flight ""
    And I now click anchor link "Sign out" on page
    Then I should successfully land on "Submit a General Aviation Report (GAR)" page

  @automated @EGAR-714 @EGAR-245
  Scenario: 6.) [EGAR-714] - User selects "I don't know the departure ICAO code" and selects Latitude/Longitude on depature page and checks on Summary Page
    When I now click anchor link "Submit a GAR" on page
    And I navigate to "Departure details" page
    Then I click a link "I don't know the departure ICAO code"
    ## @Depricated And I should confirm checkbox
    Then I choose "Latitude and longitude" option
    And I see "Departure latitude" field then I enter "51.23" in "latitude"
    And I see "Departure longitude" field then I enter "23.51" in "longitude"
    And I "Save and continue"
    And I navigate to "GAR summary" page
    Then I check on GAR summary page if "Departure details" feild asking user "Departure location:" on/of flight "51.23, 23.51"
    And I now click anchor link "Sign out" on page
    Then I should successfully land on "Submit a General Aviation Report (GAR)" page

  @automated @EGAR-714 @EGAR-245
  Scenario: 7.) [EGAR-714] - User selects "I don't know the departure ICAO code" and selects IATA Code on depature page and checks on Summary Page
    When I now click anchor link "Submit a GAR" on page
    And I navigate to "Departure details" page
    Then I click a link "I don't know the departure ICAO code"
    ## @Depricated And I should confirm checkbox
    Then I choose "IATA code" option
    And I see "Departure IATA code" field then I enter "ABA" in "departure-iata"
    And I "Save and continue"
    And I navigate to "GAR summary" page
    Then I check on GAR summary page if "Departure details" feild asking user "Departure location:" on/of flight "ABA"
    And I now click anchor link "Sign out" on page
    Then I should successfully land on "Submit a General Aviation Report (GAR)" page

    # =====================REDUNDANT TEST SUITE =======================================================================#
    # @not-to-run @redundant @EGAR-714 @EGAR-245
    # Scenario:[EGAR-714] - User selects "I don't know the departure ICAO code" and selects No Code on depature page and checks on Summary Page
    # When I now click anchor link "Submit a GAR" on page
    # And I navigate to "Departure details" page
    # Then I saw "I don't know the departure ICAO code" checkBox
    # And I should confirm checkbox
    # Then I choose "No location code" option
    # And I see "Departure location name" field then I enter "Biggin hill" in "location"
    # And I "Save and continue"
    # And I navigate to "GAR summary" page
    # Then I check on GAR summary page if "Departure details" feild asking user "Departure location:" on/of flight "Biggin hill"
    # And I now click anchor link "Sign out" on page
    # Then I should successfully land on "Submit a General Aviation Report (GAR)" page