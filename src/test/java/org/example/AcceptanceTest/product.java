package org.example.AcceptanceTest;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tt.Tproduct;
import tt.mytest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class product {
    private final mytest testInstance = new mytest();
    private final Map<String, Tproduct> inventory = new HashMap<>();
    private String dashboardMessage;

    @When("I add a product with the following details")
    public void iAddAProductWithTheFollowingDetails(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> columns : rows) {
            String productName = columns.get("name");
            String category = columns.get("category");
            double price = Double.parseDouble(columns.get("price"));

            Tproduct newProduct = new Tproduct(productName, category, price, 0);  // Assuming quantity is 0 when first added
            String productId = "P" + (inventory.size() + 1);  // Generating a unique ID

            inventory.put(productId, newProduct);
            testInstance.addproduct(newProduct);  // Add to the main product list in mytest
            dashboardMessage = "Product added successfully";
        }
    }

    @Then("the product should be added successfully")
    public void theProductShouldBeAddedSuccessfully() {
        assert dashboardMessage.equals("Product added successfully");
    }

    @Given("I have a product with ID {string} in the inventory")
    public void iHaveAProductWithIDInTheInventory(String productId) {
        // For testing purposes, we simulate having a product with the given ID
        Tproduct existingProduct = new Tproduct("Sample Product", "Sample Category", 10.00, 100);
        inventory.put(productId, existingProduct);
        testInstance.addproduct(existingProduct);  // Add to the main product list in mytest
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
}