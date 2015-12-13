Feature: Email draft
  As a gmail user
  I want to create email draft and sent it later

    # sent email -> check that it's on sent folder
  Scenario: Check that send email is in Sent folder.

    # start email -> save it to draft -> go to draft folders - n>
    # sent email -> check that draft folder is empty.
    Scenario: Check that when you sent email from draft saved, it's no longer in Draft folder.
    Given I navigate to main page
    And I log in as "user1" with password "pwd1"
    And I create email to sent to "user2" with "subject" and "emailBody"
    # Drafts are saved automatically
    And I go to Drafts folder
    When I sent email from Drafts folder
    Then Draft folder is empty