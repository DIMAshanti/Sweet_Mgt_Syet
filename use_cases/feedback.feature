Feature: feedback
Scenario: View Feedback for a Recipe
Given I am logged in as an admin
When I view feedback for the recipe titled "Banana Bread"
Then I should see all user comments and ratings for "Banana Bread"

Scenario: Remove Inappropriate Feedback
Given I am logged in as an admin
And there is a feedback comment "Inappropriate language" on the recipe titled "Apple Pie"
When I remove the inappropriate feedback on "Apple Pie"
Then the feedback should no longer be visible under the "Apple Pie" recipe

Scenario: Respond to a Feedback Question
Given I am logged in as an admin
And there is a feedback question "Can I use a substitute for butter?" on the recipe "Chocolate Chip Cookies"
When I respond to the feedback with "You can use margarine as a substitute."
Then my response should be visible under the feedback question
Scenario: provide feedback
Given I am logged in as a user
And I have tried the recipe titled "Banana Bread"
When I leave feedback on the "Banana Bread" recipe with the comment "Great taste, but needs more baking time."
Then my feedback should be visible under the "Banana Bread" recipe

Scenario: Delete User Feedback
Given I am logged in as a user
And I have left feedback with titled "Banana Bread" with the comment "Very powerful and easy to use!"
When I delete my feedback on the "Banana Bread"
Then my feedback should no longer be visible under the "Banana Bread"