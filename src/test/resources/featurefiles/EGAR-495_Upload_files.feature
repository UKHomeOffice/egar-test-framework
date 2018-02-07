Feature: [EGAR-495] - Upload document
  As a user
  I want to upload useful documents
  So that required information is declared well in advance

  Background:User on the page
    Given user is on "/welcome" page
    When "public" user logs in with username as "new1@testingworld.com" and password as "testing1234"

  @automated @EGAR-495 @EGAR-245 @EGAR-261
  Scenario:- public user uploads a single document and checks on Summary page
    When I now click anchor link "Submit a GAR" on page
    And I navigate to "Would you like to add any supporting files to accompany your GAR submission?" page
    Then I choose "Yes" option
    And I "Save and continue"
    Then I should successfully land on "Upload supporting files" page
    And I upload a single file "BMP_to_JPG.jpg"
    And I "Upload file"
    And I "Save and continue"
    And I navigate to "GAR summary" page
    Then I check on GAR summary page if "Supporting documents" feild asking user "Filename:" on/of flight "BMP_to_JPG.jpg"
    And I check on GAR summary page if "Supporting documents" feild asking user "Status:" on/of flight "Ready"

  @automated @EGAR-495  @EGAR-245 @EGAR-261
  Scenario:- public user uploads more then one document and checks on Summary page
    When I now click anchor link "Submit a GAR" on page
    And I navigate to "Would you like to add any supporting files to accompany your GAR submission?" page
    Then I choose "Yes" option
    And I "Save and continue"
    Then I should successfully land on "Upload supporting files" page
    And I upload a single file "BMP_to_JPG.jpg"
    And I "Upload file"
    And I upload a another file "word_doc.docx"
    And I "Upload file"
    And I "Save and continue"
    And I navigate to "GAR summary" page
    Then I check on GAR summary page if "Supporting documents" feild asking user "Filename:" on/of flight "BMP_to_JPG.jpg"
    And I check on GAR summary page if "Supporting documents" feild asking user "Status:" on/of flight "Ready"


  @automated @EGAR-495  @EGAR-245 @EGAR-261
  Scenario:- public user uploading document
    When I now click anchor link "Submit a GAR" on page
    And I navigate to "Would you like to add any supporting files to accompany your GAR submission?" page
    Then I choose "No" option
    And I "Save and continue"
    And I navigate to "GAR summary" page
    And user finds details related to "Supporting documents" and others similer feilds