Feature: Communication
  Scenario: Send Message to Any Email
    Given I am logged into the system
    When I compose a message and enter a valid email address in the recipient field
    Then the message should be sent successfully
    And the recipient at the provided email address should receive the message


  Scenario: Receive and Reply to a Message
    Given I am logged into the system
    When I receive a new message in my inbox
    Then I should be able to open and read the message
    And I have the option to reply directly from the message view

  Scenario: View a Message from Inbox
    Given I am a registered user and logged in
    When I access my inbox to view messages
    Then I should see the list of all received messages
   And I can select any message to read its full content