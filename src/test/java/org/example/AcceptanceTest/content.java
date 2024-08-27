package org.example.AcceptanceTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tt.MyTest;

import static org.junit.Assert.*;

public class content {

    private MyTest obj;

    public content() {
        this.obj = new MyTest();
    }

    @Given("I am logged in as an admin")
    public void iAmLoggedInAsAnAdmin() {
        obj.setCurrentUserRole("admin");
        assertTrue("User should be logged in as admin", obj.isLoggedInAs("admin"));
    }

    @When("I approve a submitted recipe titled {string}")
    public void iApproveASubmittedRecipeTitled(String recipeTitle) {

    }

    @Then("the recipe {string} should be publicly visible on the platform")
    public void theRecipeShouldBePubliclyVisibleOnThePlatform(String recipeTitle) {

    }


    @When("I reject a submitted recipe titled {string} with reason {string}")
    public void iRejectASubmittedRecipeTitledWithReason(String recipeTitle, String reason) {
        obj.rejectRecipe(recipeTitle, reason);
    }

    @Then("the submitter should receive a notification {string}")
    public void theSubmitterShouldReceiveANotification(String notification) {
        //assertEquals(notification, obj.getLastNotification());
    }

    @Then("the recipe {string} should not be publicly visible")
    public void theRecipeShouldNotBePubliclyVisible(String recipeTitle) {
        assertFalse("Recipe should not be publicly visible", obj.isRecipePubliclyVisible(recipeTitle));
    }

    @Given("the recipe {string} is publicly visible")
    public void theRecipeIsPubliclyVisible(String recipeTitle) {
        obj.makeRecipePubliclyVisible(recipeTitle);
    }

    @When("I delete the recipe {string}")
    public void iDeleteTheRecipe(String recipeTitle) {
        obj.deleteRecipe(recipeTitle);
    }

    @Then("the recipe {string} should no longer be visible on the platform")
    public void theRecipeShouldNoLongerBeVisibleOnThePlatform(String recipeTitle) {
       // assertFalse("Recipe should no longer be visible", obj.isRecipePubliclyVisible(recipeTitle));
    }


/*
    @Given("I am logged in as a user")
    public void iAmLoggedInAsAUser() {
        obj.setCurrentUserRole("user");
        assertTrue("User should be logged in as user", obj.isLoggedInAs("user"));
    }*/

    @When("I post a new dessert recipe with the title {string} and description {string}")
    public void iPostANewDessertRecipeWithTheTitleAndDescription(String title, String description) {
        obj.submitNewRecipe(title, description);
    }

    @Then("the recipe should be visible on my profile awaiting admin approval")
    public void theRecipeShouldBeVisibleOnMyProfileAwaitingAdminApproval() {
        assertTrue("Recipe should be visible on profile awaiting approval", obj.isRecipeAwaitingApprovalOnProfile());
    }

    @Given("I have posted a dessert recipe titled {string}")
    public void iHavePostedADessertRecipeTitled(String recipeTitle) {
        obj.submitNewRecipe(recipeTitle, "Description");
    }

    @When("I delete the dessert recipe")
    public void iDeleteTheDessertRecipe() {
        obj.deleteOwnRecipe("Chocolate Cake");
    }

    @Then("the recipe should no longer be visible on my profile")
    public void theRecipeShouldNoLongerBeVisibleOnMyProfile() {
        assertFalse("Recipe should no longer be visible on profile", obj.isRecipeVisibleOnProfile("Chocolate Cake"));
    }

    @Given("I have tried the recipe titled {string}")
    public void iHaveTriedTheRecipeTitled(String recipeTitle) {
        obj.markRecipeAsTried(recipeTitle);
    }

    }

