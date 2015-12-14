Feature: Sent Email
As a gmail user
I want to be able to sent email

    # sent email -> check that it's on sent folder
    Scenario Outline: Check that send email is in Sent folder.
        Given I navigate to main page
        And I log in as "<user>" with password "<password>"
        When I sent email to "<addressee>" with "subject" and "emailBody"
        And I go to Sent Mail folder
        Then email sent is on Send folder

    Examples:
      | user                    | password         | addressee                |
      | testtasktask@gmail.com  | testtasktaskpwd  | testtasktask2@gmail.com  |
      | testtasktask2@gmail.com | testtasktaskpwd2 | testtasktask@gmail.com   |