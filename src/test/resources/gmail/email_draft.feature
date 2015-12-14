Feature: Email draft
  As a gmail user
  I want to create email draft and sent it later

    # sent email -> check that it's on sent folder
  Scenario: Check that send email is in Sent folder.

    # start email -> save it to draft -> go to draft folders - n>
    # sent email -> check that draft folder is empty.
    Scenario Outline: Check that when you sent email from draft saved, it's no longer in Draft folder.
      Given I navigate to main page
      And I log in as "<user>" with password "<password>"
      And I create email to sent to "<addressee>" with "subject" and "emailBody"
      # Drafts are saved automatically
      And I go to Drafts folder
      When I sent email from Drafts folder
      Then Draft folder is empty

    Examples:
      | user                    | password         | addressee                |
      | testtasktask@gmail.com  | testtasktaskpwd  | testtasktask2@gmail.com  |
      | testtasktask2@gmail.com | testtasktaskpwd2 | testtasktask@gmail.com   |