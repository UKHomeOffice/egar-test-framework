Feature:[EGAR-478] - User on Log-in page
  As a user
  I should be able to sign in or register new account
  So that I can process my Gar

  Background:[EGAR-27] user on Start page
    Given user is on "/welcome" page
    Then I should successfully land on "Submit a General Aviation Report (GAR)" page
    And I "Start now"
    Then I should successfully land on "Sign in or create an account" page

  @automated @EGAR-478
  Scenario:[EGAR-478] User On Sign In page
    And I click a link "Sign in with your email and password"
    When I see "Email address" field then I enter "new1@testingworld.com" as "username"
    And I see "Password" field then I enter "testing1234" as "password"
    And I "Sign in"
    Then I should successfully land on "General Aviation Report (GAR)" page
    And I should see link "Submit a GAR"
    And I should see link "Manage a GAR"
    When I now click anchor link "Sign out" on page
    Then I should successfully land on "Submit a General Aviation Report (GAR)" page

  @automated @EGAR-478
  Scenario:[EGAR-478]User enters no email address and gets error message on screen
    And I click a link "Sign in with your email and password"
    When I see "Email address" field then I enter "" as "username"
    When I see "Password" field then I enter "testing1234" as "password"
    And I "Sign in"
    Then I should be able to see error message "There is a problem with this form"
    And I should be able to see error message "Invalid username or password."

  @automated @EGAR-478
  Scenario:[EGAR-478]User enters no Password and gets error message on screen
    And I click a link "Sign in with your email and password"
    When I see "Email address" field then I enter "new1@testingworld.com" as "username"
    When I see "Password" field then I enter "" as "password"
    And I "Sign in"
    Then I should be able to see error message "There is a problem with this form"
    And I should be able to see error message "Invalid username or password."

  @automated @EGAR-478
  Scenario:[EGAR-478]User enters nothing nor email or Password and gets error message on screen
    And I click a link "Sign in with your email and password"
    When I see "Email address" field then I enter "" as "username"
    When I see "Password" field then I enter "" as "password"
    And I "Sign in"
    Then I should be able to see error message "There is a problem with this form"
    And I should be able to see error message "Invalid username or password."