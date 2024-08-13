package org.example.AcceptanceTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class order {

    @Given("I am logged in as a store owner")
    public void iAmLoggedInAsAStoreOwner() {

    }
    @Given("I have a product {string} with no current discounts")
    public void iHaveAProductWithNoCurrentDiscounts(String string) {

    }
    @When("I apply a {int}% discount for quantities above {int}")
    public void iApplyADiscountForQuantitiesAbove(Integer int1, Integer int2) {

    }
    @Then("the discount should be set successfully")
    public void theDiscountShouldBeSetSuccessfully() {

    }
    @Then("I should see {string} on my dashboard")
    public void iShouldSeeOnMyDashboard(String string) {

    }


    @Given("I have a product {string} with a {int}% discount for quantities above {int}")
    public void iHaveAProductWithADiscountForQuantitiesAbove(String string, Integer int1, Integer int2) {

    }
    @When("I update the discount to {int}% for quantities above {int}")
    public void iUpdateTheDiscountToForQuantitiesAbove(Integer int1, Integer int2) {

    }
    @Then("the discount details should be updated successfully")
    public void theDiscountDetailsShouldBeUpdatedSuccessfully() {

    }



    @When("I remove the discount from {string}")
    public void iRemoveTheDiscountFrom(String string) {

    }
    @Then("the discount should be removed successfully")
    public void theDiscountShouldBeRemovedSuccessfully() {

    }
    @Given("I have a product {string} priced at ${int} with no current discounts")
    public void iHaveAProductPricedAt$WithNoCurrentDiscounts(String string, Integer int1) {

    }
    @When("I apply a promotional discount of {int}% valid from {string} to {string}")
    public void iApplyAPromotionalDiscountOfValidFromTo(Integer int1, String string, String string2) {

    }
    @Then("the promotional discount should be set successfully")
    public void thePromotionalDiscountShouldBeSetSuccessfully() {

    }

}
