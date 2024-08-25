Feature: Content Management

  # Admin Scenarios
  Scenario: Approve a Submitted Recipe
    Given I am logged in as an admin
    When I approve a submitted recipe titled "Chocolate Cake"
    Then the recipe "Chocolate Cake" should be publicly visible on the platform

  Scenario: Reject a Submitted Recipe
    Given I am logged in as an admin
    When I reject a submitted recipe titled "Chocolate Cake" with reason "Incomplete ingredient list"
    Then the submitter should receive a notification "Incomplete ingredient list"
    And the recipe "Chocolate Cake" should not be publicly visible

  Scenario: Delete a Publicly Visible Recipe
    Given I am logged in as an admin
    And the recipe "Lemon Tart" is publicly visible
    When I delete the recipe "Lemon Tart"
    Then the recipe "Lemon Tart" should no longer be visible on the platform


  # User Scenarios
  Scenario: Post a New Recipe as a User
    Given I am logged in as a user
    When I post a new dessert recipe with the title "Chocolate Cake" and description "Step-by-step guide"
    Then the recipe should be visible on my profile awaiting admin approval

  Scenario: Delete a User-Posted Recipe
    Given I am logged in as a user
    And I have posted a dessert recipe titled "Chocolate Cake"
    When I delete the dessert recipe
    Then the recipe should no longer be visible on my profile


