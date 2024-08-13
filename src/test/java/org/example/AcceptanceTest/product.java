package org.example.AcceptanceTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class product {

    @When("I add a product with the following details")
    public void iAddAProductWithTheFollowingDetails(io.cucumber.datatable.DataTable dataTable) {

    }
    @Then("the product should be added successfully")
    public void theProductShouldBeAddedSuccessfully() {

    }

    @Given("I have a product with ID {string} in the inventory")
    public void iHaveAProductWithIDInTheInventory(String string) {

    }
    @When("I update the product {string} with the following details")
    public void iUpdateTheProductWithTheFollowingDetails(String string, io.cucumber.datatable.DataTable dataTable) {

    }
    @Then("the product details should be updated successfully")
    public void theProductDetailsShouldBeUpdatedSuccessfully() {

    }

    @When("I remove the product {string}")
    public void iRemoveTheProduct(String string) {

    }
    @Then("the product should be removed successfully")
    public void theProductShouldBeRemovedSuccessfully() {

    }

}
