Feature:[EGAR-43] - User on Start Page
  As a user
  I want to see Start Page
  So that I can initiate GAR submission through the link available on the page

  Background: user on the page
    Given user is on "/welcome" page
    Then I should successfully land on "Submit a General Aviation Report (GAR)" page

  @automated @EGAR-43
  Scenario:[EGAR-43] User on landing Page(Start page)
    When I land on the page, I should see a link indicating "Check if you need to submit a GAR"
    And I should see Instructions "aircraft details (including registration number and base)" like to how to apply for GAR registration
    And I should see Instructions "arrival and departure details (date, location and scheduled times)" like to how to apply for GAR registration
    And I should see Instructions "name and telephone number of the person responsible for goods on board" like to how to apply for GAR registration
    And I should see Instructions "aircraft tax information (whether taxes have been paid and accounted for in the EU)" like to how to apply for GAR registration
    And I should see Instructions "captain, crew and passenger details (including travel documents and UK visiting address)" like to how to apply for GAR registration
    And I should also see "Other ways to submit a GAR" like "By email", "In an emergency"
    And I "Start now"
    And I should successfully land on "Sign in or create an account" page