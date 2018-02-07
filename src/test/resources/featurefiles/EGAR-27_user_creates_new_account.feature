Feature:[EGAR-27] - User registers new account
  As a public user
  I want to register new account
  So that the created account can be used

  Background:[EGAR-27] user on Start page
    Given user is on "/welcome" page
    Then I should successfully land on "Submit a General Aviation Report (GAR)" page
    And I "Start now"
    Then I should successfully land on "Sign in or create an account" page

  @automated @EGAR-27
  Scenario:[EGAR-27]User creates new account with email address
    And I now click anchor link "Create an account for GAR submissions" on page
    Then I should successfully land on "Create a new GAR account" page
    When in "Email address" field I enter "Random" "email"
    And I "Continue"
    Then I should successfully land on "General aviation report account terms and conditions" page
    And I should see Instructions "Please review and agree with this important information before you proceed to creating a GAR account"
    And I should see Instructions "Please confirm that you have read the information above and agree with the conditions of use"
    When "I agree" conditions
    And I "Create an account"
    Then I should successfully land on "Verify your email address" page
    And I should see Instructions "An email has been sent. Please check your email and follow the link to activate your account."
    And I should see link "Resend Email."

  @automated @EGAR-27
  Scenario:[EGAR-27]User varifies email received
    Given user logs in "http://key.egarteam.co.uk:8092/" email
    When user clicks email in inbox
    Then I should see email with title "General Aviation Report (GAR)"
    When I click verification link
    Then I should see Instructions "Your email address has been verified."
    And I close the page

  @automated @EGAR-27
  Scenario: [EGAR-27] User uses previously used email address to register then error should appear
     When I now click anchor link "Create an account for GAR submissions" on page
     Then I should successfully land on "Create a new GAR account" page
     When I see "Email address" field then I enter "test@dev.egarteam.co.uk" in "email"
     And I "Continue"
     Then I should be able to see error message "There is a problem with this form"
     And I should be able to see error message "Email already exists."
     And I should see Instructions "Enter your email. We'll send you a link to create your account."

  @automated @EGAR-27
  Scenario:[EGAR-27]User does not enter any email address to register then error should appear
    When I now click anchor link "Create an account for GAR submissions" on page
    Then I should successfully land on "Create a new GAR account" page
    When I see "Email address" field then I enter "" in "email"
    When I "Continue"
    And I should be able to see error message "There is a problem with this form"
    Then I should be able to see error message "Please specify email."
    Then I should see Instructions "Enter your email. We'll send you a link to create your account."

#  @Manual @EGAR-27
#   Scenario: User clicks expired email link
#    Then I should successfully land on "There was a problem" page
#    And I should see Instructions "The link you clicked is a old stale link and is no longer valid. Maybe you have already verified your email?" like to how to apply for GAR registration