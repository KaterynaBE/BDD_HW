Feature: Sent Email
As a gmail user
I want to be able to sent email

    # sent email -> check that it's on sent folder
    Scenario: Check that send email is in Sent folder.
        Given I navigate to main page
        And I log in as "user1" with password "pwd1"
        And I sent email to "user2" with "subject" and "emailBody"
        When I go to Sent Mail folder
        Then email sent is on Send folder