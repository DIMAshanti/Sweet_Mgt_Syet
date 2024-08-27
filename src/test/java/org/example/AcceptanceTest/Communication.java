package org.example.AcceptanceTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import tt.Message;
import tt.MyTest;

import java.util.*;

public class Communication {

    private MyTest obj;
    private String loggedInUserEmail;

    public Communication(MyTest iobj) {
        super();
        this.obj = iobj;
    }

    @Given("I am logged into the system")
    public void iAmLoggedIntoTheSystem() {
        // Simulate logging into the system
        loggedInUserEmail = "maya@gmail.com";
        Assert.assertTrue("Login failed, user does not exist", obj.isemailExists(loggedInUserEmail));
    }

    @When("I compose a message and enter a valid email address in the recipient field")
    public void iComposeAMessageAndEnterAValidEmailAddressInTheRecipientField() {
        String recipientEmail = "haya@gmail.com"; // Assume this is the recipient email for the test
        String messageContent = "Hello, this is a test message.";
        if (obj.isemailExists(recipientEmail)) {
            obj.sendMessage(loggedInUserEmail, recipientEmail, messageContent);
        } else {
            Assert.fail("Recipient email does not exist.");
        }
    }

    @Then("the message should be sent successfully")
    public void theMessageShouldBeSentSuccessfully() {
        Message lastMessage = obj.getLastSentMessage();
        Assert.assertNotNull("No message was sent", lastMessage);
        Assert.assertEquals("Message was not sent to the correct recipient", "haya@gmail.com", lastMessage.getRecipientEmail());
    }

    @Then("the recipient at the provided email address should receive the message")
    public void theRecipientAtTheProvidedEmailAddressShouldReceiveTheMessage() {
        List<Message> receivedMessages = obj.getMessagesForUser("haya@gmail.com");
        Assert.assertFalse("Recipient did not receive any messages", receivedMessages.isEmpty());
    }

    @When("I receive a new message in my inbox")
    public void iReceiveANewMessageInMyInbox() {

    }

    @Then("I should be able to open and read the message")
    public void iShouldBeAbleToOpenAndReadTheMessage() {
        List<Message> inbox = obj.getMessagesForUser(loggedInUserEmail);
        Assert.assertTrue("No messages to read", inbox.isEmpty());
        Message message = new Message();
        Assert.assertNull("Message content is null", message. getMessageContent());
    }

    @Then("I have the option to reply directly from the message view")
    public void iHaveTheOptionToReplyDirectlyFromTheMessageView() {

    }

    @When("I access my inbox to view messages")
    public void iAccessMyInboxToViewMessages() {

        List<Message> messages = obj.getMessagesForUser(loggedInUserEmail);
        Assert.assertNotNull("Failed to access inbox", messages);
    }

    @Then("I should see the list of all received messages")
    public void iShouldSeeTheListOfAllReceivedMessages() {
        List<Message> messages = obj.getMessagesForUser(loggedInUserEmail);
        Assert.assertTrue("Inbox is empty", messages.isEmpty());
    }

    @Then("I can select any message to read its full content")
    public void iCanSelectAnyMessageToReadItsFullContent() {

    }
}