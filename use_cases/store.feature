Feature: Store Management

  Scenario: View store details and add products to the inventory
    Given I am a logged-in user
    When I view the list of all stores
    Then I should see a list of stores with their details
    And I select a store to view its details
    Then I should see the store's detailed information including name, owner, and available products

    When I am logged in as a store owner
    And I view the store's current inventory
    Then I should see the list of products with their details

    When I add a new product to the inventory
    And I provide the product details including name, description, and price
    Then the new product should be added to the store's inventory
    And I should see a confirmation that the product was successfully added

    When I update the product information
    And I provide the new details including name, description, and price
    Then the product information should be updated in the store's inventory
    And I should see a confirmation that the product was successfully updated

    When I remove a product from the inventory
    Then the product should be removed from the store's inventory
    And I should see a confirmation that the product was successfully removed
