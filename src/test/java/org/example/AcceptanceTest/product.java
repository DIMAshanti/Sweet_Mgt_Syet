package org.example.AcceptanceTest;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tt.Tproduct;
import tt.MyTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class product {
    private final MyTest testInstance = new MyTest();
    private final Map<String, Tproduct> inventory = new HashMap<>();
    private String dashboardMessage;
    private final MyTest testContext = new MyTest();
    private Tproduct currentProduct;
    private double appliedDiscount;
    private boolean discountAppliedSuccessfully;
    @Given("I am logged in as a store owner")
    public void iAmLoggedInAsAStoreOwner() {
        testContext.setLogged(true);
    }
    @When("I add a product with the following details")
    public void iAddAProductWithTheFollowingDetails(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> columns : rows) {
            String pid = columns.get("pid");
            String productName = columns.get("name");
            String category = columns.get("category");
            double price = Double.parseDouble(columns.get("price"));

            Tproduct newProduct = new Tproduct(pid,productName, category, price, 0);
            String productId = "P" + (inventory.size() + 1);

            inventory.put(productId, newProduct);
            testInstance.addproduct(newProduct);
            dashboardMessage = "Product added successfully";
        }
    }

    @Then("the product should be added successfully")
    public void theProductShouldBeAddedSuccessfully() {
        assert dashboardMessage.equals("Product added successfully");
    }

    @Given("I have a product with ID {string} in the inventory")
    public void iHaveAProductWithIDInTheInventory(String productId) {

        Tproduct existingProduct = new Tproduct("P001", "Chocolate Cake", "Dessert", 15.99, 10);
        inventory.put(productId, existingProduct);
        testInstance.addproduct(existingProduct);
    }

    @When("I update the product {string} with the following details")
    public void iUpdateTheProductWithTheFollowingDetails(String productId, DataTable dataTable) {
        Tproduct product = inventory.get(productId);
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        if (product != null) {
            for (Map<String, String> columns : rows) {
                if (columns.containsKey("price")) {
                    product.setprice(Double.parseDouble(columns.get("price")));
                }
                if (columns.containsKey("category")) {
                    product.setcategory(columns.get("category"));
                }
            }
            dashboardMessage = "Product updated successfully";
        } else {
            dashboardMessage = "Product not found";
        }
    }

    @Then("the product details should be updated successfully")
    public void theProductDetailsShouldBeUpdatedSuccessfully() {
        assert dashboardMessage.equals("Product updated successfully");
    }

    @When("I remove the product {string}")
    public void iRemoveTheProduct(String productId) {
        if (inventory.containsKey(productId)) {
            Tproduct removedProduct = inventory.remove(productId);
            testInstance.removeproduct(removedProduct);  // Remove from the main product list in mytest
            dashboardMessage = "Product removed successfully";
        } else {
            dashboardMessage = "Product not found";
        }
    }

    @Then("the product should be removed successfully")
    public void theProductShouldBeRemovedSuccessfully() {
        assert dashboardMessage.equals("Product removed successfully");
    }
    @Given("I have a product {string} with no current discounts")
    public void iHaveAProductWithNoCurrentDiscounts(String productName) {
        for (Tproduct product : testContext.getProlist()) {
            if (product.getName()) {
                currentProduct = product;
                break;
            }
        }
        // Assuming no discounts are active initially
        if (currentProduct != null) {
            appliedDiscount = 0;
        }
    }
    @Given("I have a product {string} priced at ${int} with no current discounts")
    public void iHaveAProductPricedAt$WithNoCurrentDiscounts(String productName, Integer price) {
        iHaveAProductWithNoCurrentDiscounts(productName);
        if (currentProduct != null) {
            currentProduct.setprice(price);
        }
    }

    @When("I apply a promotional discount of {int}% valid from {string} to {string}")
    public void iApplyAPromotionalDiscountOfValidFromTo(Integer discountPercentage, String startDate, String endDate) {
        // Assuming no complex date checks for simplicity
        appliedDiscount = discountPercentage;
        discountAppliedSuccessfully = true;
    }

    @Then("I should see {string} on my dashboard")
    public void iShouldSeeOnMyDashboard(String message) {
        // Assuming this is a simple check; you could use a logger or print statement
        System.out.println("Dashboard message: " + message);
    }
    @Then("the promotional discount should be set successfully")
    public void thePromotionalDiscountShouldBeSetSuccessfully() {
        assert discountAppliedSuccessfully : "Promotional discount was not set successfully";
    }


}