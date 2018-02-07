Feature:[EGAR-205] - User adds or amends Details of Captain, Crew or Passengers

  As a public user
  I should be able to amend gar submission
  So that I can either add, remove or edit the details of Captain, crew or passenger

  Background:User starting from Start Page and then navigating to
    Given user is on "/welcome" page
    When "public" user logs in with username as "new1@testingworld.com" and password as "testing1234"

  @automated @EGAR-205
  Scenario:User on the Adding Captain, Crew and Passengers
    When I now click anchor link "Submit a GAR" on page
    Then I navigate to "Adding Captain, Crew and Passengers" page
    When I choose to "Add new"
    Then I should successfully land on "Select the type of person you wish to add to this flight" page
    And user should see '3' radio buttons
    Then I see them as "Captain"
    And I see them as "Crew"
    And I see them as "Passenger"
    And I "Save and continue"
    Then I should see validation error message "Please select a person"
    And I now click anchor link "Sign out" on page
    Then I should successfully land on "Submit a General Aviation Report (GAR)" page

  @automated @EGAR-205 @EGAR-245
  Scenario:[EGAR - 205] - User selects Captain and adds "Captain's details" and then checks on Summary Page
    When I now click anchor link "Submit a GAR" on page
    Given I navigate to "Adding Captain, Crew and Passengers" page
    When I choose to "Add new"
    And I choose "Captain" option
    And I "Save and continue"
    Then I should successfully land on "Information about the captain" page
    When I see "Given name(s)" field then I enter "Captain Testing" as "given-name"
    When I see "Family Name" field then I enter "TESTING-SURNAME" as "family-name"
    And I choose "Male" option
    When I see "UK home address or address visiting in UK" field then I enter "1 Bank road, HC1 1CH" as "address"
    Then I "Save and continue"
    And I see "Day" field then I enter "01" in "dob-day"
    And I see "Month" field then I enter "01" in "dob-month"
    And I see "Year" field then I enter "1990" in "dob-year"
    And I see "Place of birth" field then I enter "Britain" in "birth-place"
    And I should be able to select "Andorra" from dropdown list
    Then I "Save and continue"
    And I choose "Passport" option
    And I see "Travel document number (if available)" field then I enter "ABCD012345678" in "document-number"
    Then I see "Day" field then I enter "01" in "expiry-day"
    Then I see "Month" field then I enter "12" in "expiry-month"
    And I see "Year" field then I enter "2018" in "expiry-year"
    And I should be able to select "Andorra" from dropdown list
    Then I "Save and continue"
    Then I should successfully land on "Please specify who is responsible for goods and people on this flight?" page
    And I "Save and continue"
    Then I should be able to see "Captain" added in "Type"
    And I navigate to "GAR summary" page
    Then I check on GAR summary page if "Captain details" feild asking user "Given names(s)" on/of flight "Captain Testing"
    And I check on GAR summary page if "Captain details" feild asking user "Family name:" on/of flight "TESTING-SURNAME"
    And I check on GAR summary page if "Captain details" feild asking user "Gender" on/of flight "Male"
    And I now click anchor link "Sign out" on page

  @automated @EGAR-205 @EGAR-245
  Scenario:[EGAR - 205] - User selects Captain and adds "Crew's details" and then checks on Summary Page
    When I now click anchor link "Submit a GAR" on page
    Given I navigate to "Adding Captain, Crew and Passengers" page
    When I choose to "Add new"
    And I choose "Crew" option
    And I "Save and continue"
    Then I should successfully land on "Information about the crew" page
    When I see "Given name(s)" field then I enter "Crew Testing" as "given-name"
    When I see "Family Name" field then I enter "Crew-SURNAME" as "family-name"
    And I choose "Female" option
    When I see "UK home address or address visiting in UK" field then I enter "1 Bank road, HC1 1CH" as "address"
    Then I "Save and continue"
    And I see "Day" field then I enter "02" in "dob-day"
    And I see "Month" field then I enter "02" in "dob-month"
    And I see "Year" field then I enter "1991" in "dob-year"
    And I see "Place of birth" field then I enter "Algeria" in "birth-place"
    And I should be able to select "Algeria" from dropdown list
    Then I "Save and continue"
    And I choose "Passport" option
    And I see "Travel document number (if available)" field then I enter "ABCD012345678" in "document-number"
    Then I see "Day" field then I enter "30" in "expiry-day"
    Then I see "Month" field then I enter "11" in "expiry-month"
    And I see "Year" field then I enter "2018" in "expiry-year"
    And I should be able to select "Albania" from dropdown list
    Then I "Save and continue"
    Then I should be able to see "Crew" added in "Type"
    And I navigate to "GAR summary" page
    Then I check on GAR summary page if "Crew details" feild asking user "UK home address:" on/of flight "1 Bank road, HC1 1CH"
    And I check on GAR summary page if "Crew details" feild asking user "Date of birth:" on/of flight "02 02 1991"
    And I check on GAR summary page if "Crew details" feild asking user "Place of birth:" on/of flight "Algeria"
    And I check on GAR summary page if "Crew details" feild asking user "Country of nationality:" on/of flight "Algeria"
    And I now click anchor link "Sign out" on page

  @automated @EGAR-205 @EGAR-245
  Scenario:[EGAR - 205] - User selects Captain and adds "Passenger's details" and then checks on Summary Page
    When I now click anchor link "Submit a GAR" on page
    Given I navigate to "Adding Captain, Crew and Passengers" page
    When I choose to "Add new"
    And I choose "Passenger" option
    And I "Save and continue"
    Then I should successfully land on "Information about the passenger" page
    When I see "Given name(s)" field then I enter "Passenger Testing" as "given-name"
    When I see "Family Name" field then I enter "Passenger-SURNAME" as "family-name"
    And I choose "Unspecified" option
    When I see "UK home address or address visiting in UK" field then I enter "1 Bank road, HC1 1CH" as "address"
    Then I "Save and continue"
    And I see "Day" field then I enter "03" in "dob-day"
    And I see "Month" field then I enter "03" in "dob-month"
    And I see "Year" field then I enter "1992" in "dob-year"
    And I see "Place of birth" field then I enter "Algeria" in "birth-place"
    And I should be able to select "Algeria" from dropdown list
    Then I "Save and continue"
    And I choose "Passport" option
    And I see "Travel document number (if available)" field then I enter "ABCD012345678" in "document-number"
    Then I see "Day" field then I enter "29" in "expiry-day"
    Then I see "Month" field then I enter "11" in "expiry-month"
    And I see "Year" field then I enter "2018" in "expiry-year"
    And I should be able to select "Albania" from dropdown list
    Then I "Save and continue"
    Then I should be able to see "Passenger" added in "Type"
    And I navigate to "GAR summary" page
    Then I check on GAR summary page if "Passenger details" feild asking user "Travel document type:" on/of flight "passport"
    And I check on GAR summary page if "Crew details" feild asking user "Travel document number:" on/of flight "ABCD012345678"
    And I check on GAR summary page if "Crew details" feild asking user "Travel document expiry date:" on/of flight "29 11 2018"
    And I check on GAR summary page if "Crew details" feild asking user "Travel document issuing country:" on/of flight "Albania"
    And I now click anchor link "Sign out" on page