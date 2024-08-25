package org.example.AcceptanceTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tt.mytest;
import tt.mytest.Recipe;
import tt.recipe;
import static org.junit.Assert.*;
public class feedback {
    private mytest obj;

    public feedback() {
        this.obj = new mytest();
    }

    @When("I view feedback for the recipe titled {string}")
    public void iViewFeedbackForTheRecipeTitled(String recipeTitle) {
        obj.viewRecipeFeedback(recipeTitle);
    }

    @Then("I should see all user comments and ratings for {string}")
    public void iShouldSeeAllUserCommentsAndRatingsFor(String recipeTitle) {
        // assertTrue("All comments and ratings should be visible", obj.areAllCommentsAndRatingsVisible(recipeTitle));
    }

    @Given("there is a feedback comment {string} on the recipe titled {string}")
    public void thereIsAFeedbackCommentOnTheRecipeTitled(String feedback, String recipeTitle) {
        obj.addFeedbackToRecipe(recipeTitle, feedback);
    }

    @When("I remove the inappropriate feedback on {string}")
    public void iRemoveTheInappropriateFeedbackOn(String recipeTitle) {
        obj.removeFeedbackFromRecipe(recipeTitle, "Inappropriate language");
    }

    @Then("the feedback should no longer be visible under the {string} recipe")
    public void theFeedbackShouldNoLongerBeVisibleUnderTheRecipe(String recipeTitle) {
        assertFalse("Feedback should no longer be visible", obj.isFeedbackVisible(recipeTitle, "Inappropriate language"));
    }

    @Given("there is a feedback question {string} on the recipe {string}")
    public void thereIsAFeedbackQuestionOnTheRecipe(String question, String recipeTitle) {
        obj.addFeedbackToRecipe(recipeTitle, question);
    }

    @When("I respond to the feedback with {string}")
    public void iRespondToTheFeedbackWith(String response) {
        obj.respondToFeedback(response);
    }

    @Then("my response should be visible under the feedback question")
    public void myResponseShouldBeVisibleUnderTheFeedbackQuestion() {
        assertTrue("Response should be visible under the feedback question", obj.isFeedbackResponseVisible());
    }
    @When("I leave feedback on the {string} recipe with the comment {string}")
    public void iLeaveFeedbackOnTheRecipeWithTheComment(String recipeTitle, String comment) {
        obj.leaveFeedbackOnRecipe(recipeTitle, comment);
    }

    @Then("my feedback should be visible under the {string} recipe")
    public void myFeedbackShouldBeVisibleUnderTheRecipe(String recipeTitle) {
        assertTrue("Feedback should be visible under the recipe", obj.isFeedbackVisible(recipeTitle, "Great taste, but needs more baking time."));
    }

    @Given("I have left feedback with titled {string} with the comment {string}")
    public void iHaveLeftFeedbackWithTitledWithTheComment(String recipeTitle, String comment) {
        obj.leaveFeedbackOnRecipe(recipeTitle, comment);
    }

    @When("I delete my feedback on the {string}")
    public void iDeleteMyFeedbackOnThe(String recipeTitle) {
        obj.deleteFeedbackOnRecipe(recipeTitle, "Very powerful and easy to use!");
    }

    @Then("my feedback should no longer be visible under the {string} recipe")
    public void myFeedbackShouldNoLongerBeVisibleUnderTheRecipe(String recipeTitle) {
        assertFalse("Feedback should no longer be visible under the recipe", obj.isFeedbackVisible(recipeTitle, "Very powerful and easy to use!"));
    }
    @Then("my feedback should no longer be visible under the {string}")
    public void myFeedbackShouldNoLongerBeVisibleUnderThe(String  recipeTitle) {
        boolean feedbackVisible = obj.isFeedbackVisible(recipeTitle, "feedback content");

        // Assert that the feedback is no longer visible
        assertFalse("Feedback should no longer be visible under the " + recipeTitle + " recipe", feedbackVisible);
    }

}