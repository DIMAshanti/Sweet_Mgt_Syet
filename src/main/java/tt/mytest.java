package tt;

import java.util.*;
import java.util.regex.Pattern;

public class mytest {

    private boolean validation;
    private boolean isLogged;

    private String enteredemail;
    private boolean forget=false;

    private boolean purchaseConfirmed = false;

    private static String currentUserRole;
    private String lastNotification;
    private final Map<String, Recipe> recipes = new HashMap<>();
    private final Map<String, List<String>> feedbacks = new HashMap<>();
    private boolean recipePubliclyVisible;
    private final Map<String, List<String>> recipeCommentsAndRatings = new HashMap<>();
    private String feedbackResponse;

    public mytest() {
        Person u1 = new Person("1", "haya", "123456", "haya@gmail.com", "Qalqilya", "0599221233", "user");
        Person u2 = new Person("2", "rama", "123456", "rama@gmail.com", "nablus", "0599221233", "user");
        Person o2 = new Person("3", "sara", "123456", "sara@gmail.com", "Tulkarm", "0599221233", "owner");
        Person o3 = new Person("4", "maya", "123456", "maya@gmail.com", "nablus", "0599221233", "owner");
        Person sup1 = new Person("5", "nora", "123456", "nora@gmail.com", "Qalqilya", "0599221233", "supplier");
        Person sup2 = new Person("6", "ali", "123456", "ali@gmail.com", "Tulkarm", "0599221233", "supplier");
       // Person admin = new Person("admin", "2024", "admin@gmail.com");
        addUser(u1);
        addUser(u2);
        addUser(o2);
        addUser(o3);
        addUser(sup1);
        addUser(sup2);
       // addUser(admin);


        Tproduct p1 = new Tproduct("Chocolate Cake", "Desserts", 15, 50);
        Tproduct p2 = new Tproduct("Vanilla Ice Cream", "Frozen Desserts", 15, 30);
        Tproduct p3 = new Tproduct("Apple Pie", "Baked Goods", 15, 20);
        Tproduct p4 = new Tproduct("Cinnamon Roll", "Pastries", 10, 40);

        addproduct(p1);
        addproduct(p2);
        addproduct(p3);
        addproduct(p4);


        // Example recipes
        recipe r1 = new recipe("001", "Chocolate Chip Cookies", "Delicious classic cookies with chocolate chips.", "Alice Johnson", "Dessert", "Contains Gluten, Contains Dairy");
        recipe r2 = new recipe("002", "Apple Pie", "Traditional apple pie with a flaky crust.", "Bob Smith", "Dessert", "Contains Gluten");
        recipe r3 = new recipe("003", "Cheesecake", "Creamy cheesecake with a graham cracker crust.", "Carol Lee", "Dessert", "Contains Gluten, Contains Dairy");
        recipe r4 = new recipe("004", "Banana Bread", "Moist bread made with ripe bananas.", "Dave Wilson", "Snack", "Contains Gluten");
        recipe r5 = new recipe("005", "Gluten-Free Chocolate Cake", "A delicious gluten-free chocolate cake.", "John Doe", "Dessert", "Gluten-Free");
        recipe r6 = new recipe("006", "Nut-Free Brownies", "Delicious brownies that are completely nut-free.", "Jane Doe", "Dessert", "Nut-Free");



        addrecipe(r1);
        addrecipe(r2);
        addrecipe(r3);
        addrecipe(r4);
        addrecipe(r5);
        addrecipe(r6);



        List<Tproduct> order1Products = new ArrayList<>();
        order1Products.add(p1);
        order1Products.add(p3);
        Torder myOrder1 = new Torder("Order 1: Cakes and Pies", new Date(), "Includes various cakes and pies", order1Products);

        List<Tproduct> order2Products = new ArrayList<>();
        order2Products.add(p2);
        order2Products.add(p4);
        Torder myOrder2 = new Torder("Order 2: Ice Cream and Rolls", new Date(), "Ice cream and pastries combo", order2Products);


        List<Tproduct> order3Products = new ArrayList<>(List.of(p1, p2, p3, p4));
        Torder myOrder3 = new Torder("Order 3: Full Menu", new Date(), "A full range of desserts", order3Products);

        addorder(myOrder2);
        addorder(myOrder1);
        addorder(myOrder3);


    }


    private static final List<Person> up = new ArrayList<>();
    private final List<Tproduct> prolist = new ArrayList<>();
    private static List<recipe> reclist = new ArrayList<>();
    private final List<Torder> orderlist = new ArrayList<>();


    public void addUser(Person user) {
        up.add(user);
    }

    public void addproduct(Tproduct product) {
        prolist.add(product);
    }

    public void removeproduct(Tproduct product) {
        prolist.remove(product);
    }


    public void addrecipe(recipe recipe) {
        reclist.add(recipe);
    }

    public void addorder(Torder order) {
        orderlist.add(order);
    }

    public void setLogged(boolean isLogged) {
        this.isLogged = isLogged;
    }
    public void iAmNotInSystem(mytest obj) {
        obj.isLogged = false;
    }
    private static boolean searchinusernullflag;
    public void setUsernameAndPassAndPassFromSystem(String email, String pass) {
        validation = false;
        for (Person u : up) {

            if (email.equals(u.getEmail()) && u.getPass().equals(pass)) {
                validation = true;

                break;

            }
        }
    }

    public boolean getValidation() {
        return validation;
    }


    public void setEmptyUsernameOrEmptyPass(String name, String pass) {

        if (name.isEmpty() || pass.isEmpty()) {
            validation = false;

        }


    }

    public void takePass(String newPass) {
        for (Person user : up) {

            if (user.getEmail().equals(enteredemail)) {
                user.setPass(newPass);

            }
            passwordUpdated = true;
        }

    }
    public void setEnteredemail(String s){

        enteredemail=s;
    }
    private boolean passwordUpdated = false;
    public boolean getPasswordUpdated() {



            return passwordUpdated;

    }


    public boolean getForget() {

        return forget;
    }

    public void setForget(boolean forget) {
        this.forget = forget;
    }
    public void validUserPass(String userName, String pass) {
        setForget(false);
        for (Person u : up) {
            if (userName.equals(u.getEmail()) && pass.equals("Forget")) {
                setForget(true);
                enteredemail = userName;
                break;

            }
        }
    }

    public static boolean idTest(String id) {
        if (id == null || id.length() < 5 || id.length() > 10) {
            return false;
        }

        if (!Character.isLetter(id.charAt(0))) {
            return false;
        }

        for (char c : id.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
        }

        return true;
    }

    // Validate Name: Must be non-null and contain only letters and spaces

    // Validate Gmail: Basic email validation using regex
    public static boolean gmailTest(String email) {
        if (email == null) {
            return false;
        }

        // Regex pattern for validating Gmail address
        String emailRegex = "^[a-zA-Z0-9._%+-]+@gmail\\.com$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    // Validate Password: Must be 8-16 characters, include at least one letter, one digit, and one special character
    public static boolean passwordTest(String password) {
        if (password == null || password.length() < 8 || password.length() > 16) {
            return false;
        }

        boolean hasLetter = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isLetter(c)) {
                hasLetter = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecialChar = true;
            }
        }

        return hasLetter && hasDigit && hasSpecialChar;
    }

    // Check if the email already exists in the system (stub implementation)
    public static boolean registerWithExistingEmail(String email) {
        Person user = searchInUser(email);
        // Email is not found, meaning it's not registered yet
        return user != null;  // Email is found, meaning it's already registered
    }

    public void createAccountForUser( String id,String un, String pa,String em, String city, String pn, String role) {

        addUser(new Person(id, un,pa,em,city,pn,role));

    }



    private static final Map<String, Account> accounts = new HashMap<>();

    private static String lastDisplayedMessage;
    private static boolean accountDeleted;
    private static boolean accountUpdated;

    static {
        // Pre-populate the accounts with an example account for testing
        accounts.put("existing@example.com", new Account("existing@example.com", "Existing User", "1234567890"));
    }

    public static boolean isAdmin() {
        return "admin".equalsIgnoreCase(currentUserRole);
    }

    public static boolean addAccount(String flag) {
        // Simulate adding an account based on the flag
        if ("true".equalsIgnoreCase(flag)) {
            Account newAccount = new Account("new@example.com", "New User", "0987654321");
            accounts.put(newAccount.getEmail(), newAccount);
            lastDisplayedMessage = "Account added successfully.";
            return true;
        } else {
            lastDisplayedMessage = "Failed to add account.";
            return false;
        }
    }

    public static boolean emailTest(String email) {
        return email != null && email.contains("@") && email.endsWith(".com");
    }

    public static boolean nameTest(String name) {
        return name != null && name.trim().length() > 0 && name.matches("[a-zA-Z ]+");
    }

    public static boolean phoneTest(String phone) {
        return phone != null && phone.matches("\\d{10}");
    }

    public static boolean pressButton(String button, String flag) {
        // Simulate pressing a button and performing an action based on the flag
        if ("submit".equalsIgnoreCase(button) && "true".equalsIgnoreCase(flag)) {
            lastDisplayedMessage = "Action succeeded.";
            return true;
        } else {
            lastDisplayedMessage = "Action failed.";
            return false;
        }
    }

    public static String getDisplayedMessage() {
        return lastDisplayedMessage;
    }

    public static boolean deleteAccount(String email) {
        if (accounts.containsKey(email)) {
            accounts.remove(email);
            lastDisplayedMessage = "Account deleted successfully.";
            accountDeleted = true;
            return true;
        } else {
            lastDisplayedMessage = "Account not found.";
            accountDeleted = false;
            return false;
        }
    }

    public static boolean isAccountDeleted() {
        return accountDeleted;
    }

    public static boolean emailExists(String email) {
        return accounts.containsKey(email);
    }


    public static boolean updateAccount(String email, String name, String phone) {
        if (accounts.containsKey(email)) {
            Account account = accounts.get(email);
            account.setName(name);
            account.setPhone(phone);
            accountUpdated = true;
            lastDisplayedMessage = "Account updated successfully.";
            return true;
        } else {
            accountUpdated = false;
            lastDisplayedMessage = "Account update failed.";
            return false;
        }
    }

    public static boolean isAccountUpdated() {
        return accountUpdated;
    }



    // Inner class representing an account
    private static class Account {
        private final String email;
        private String name;
        private String phone;

        public Account(String email, String name, String phone) {
            this.email = email;
            this.name = name;
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }



    public boolean isUserLoggedIn() {
        return isLogged;
    }
    public void browseDessertRecipes() {
        System.out.println("Browsing dessert recipes...");
        // In a real system, you might load or filter recipes here
    }
    public boolean isDessertRecipesListVisible() {
        return !reclist.isEmpty();
    }
    public void searchDessertRecipes(String keyword) {
        List<recipe> filteredRecipes = new ArrayList<>();
        for (recipe r : reclist) {
            if (r.getrename().toLowerCase().contains(keyword.toLowerCase())) {
                filteredRecipes.add(r);
            }
        }
        reclist = filteredRecipes;
    }
    public boolean dessertRecipesContainKeyword(String keyword) {
        for (recipe r : reclist) {
            if (r.getrename().toLowerCase().contains(keyword.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
    public void filterRecipesByDietaryNeed(String dietaryNeed) {
        List<recipe> filteredRecipes = new ArrayList<>();
        for (recipe r : reclist) {
            // Assuming dietary needs are part of the recipe description
            if (r.getDescreption().toLowerCase().contains(dietaryNeed.toLowerCase())) {
                filteredRecipes.add(r);
            }
        }
        reclist = filteredRecipes;
    }
    public boolean isGlutenFreeRecipeListVisible() {
        for (recipe r : reclist) {
            if (r.getDescreption().toLowerCase().contains("gluten-free")) {
                return true;
            }
        }
        return false;
    }
    public void filterRecipesByAllergy(String allergy) {
        List<recipe> filteredRecipes = new ArrayList<>();
        for (recipe r : reclist) {
            if (r.getDescreption().toLowerCase().contains(allergy.toLowerCase())) {
                filteredRecipes.add(r);
            }
        }
        reclist = filteredRecipes;
    }
    public boolean isNutFreeRecipeListVisible() {
        for (recipe r : reclist) {
            if (r.getDescreption().toLowerCase().contains("nut-free")) {
                return true;
            }
        }
        return false;
    }
    public void viewDessertRecipe(String recipeTitle) {
        for (recipe r : reclist) {
            if (r.getrename().equalsIgnoreCase(recipeTitle)) {
                System.out.println("Viewing recipe: " + r.getrename());
                break;
            }
        }
    }
    public void chooseToPurchaseRecipe(String recipeTitle) {
        // Simulate purchasing process
        System.out.println("Chosen to purchase: " + recipeTitle);
    }
    public void completePayment() {
        // Simulate the payment completion
        purchaseConfirmed = true;
        System.out.println("Payment process completed successfully.");
    }
    public boolean isPurchaseConfirmed() {
        return purchaseConfirmed;
    }
    public void setCurrentUserRole(String role) {
        currentUserRole = role;
    }

    public boolean isLoggedInAs(String role) {
        return currentUserRole != null && currentUserRole.equalsIgnoreCase(role);
    }






    public void rejectRecipe(String recipeTitle, String reason) {
        Recipe recipe = recipes.get(recipeTitle);
        if (recipe != null) {
            recipe.setStatus("Rejected");
            lastNotification = reason;
        }
    }

    public String getLastNotification() {
        return lastNotification;
    }

    public void makeRecipePubliclyVisible(String recipeTitle) {
        Recipe recipe = recipes.get(recipeTitle);
        if (recipe != null) {
            recipe.setStatus("Public");
        }
    }

    public void deleteRecipe(String recipeTitle) {
        recipes.remove(recipeTitle);
    }

    public void viewRecipeFeedback(String recipeTitle) {
        // This method would typically fetch feedback data from the data store
    }



    public void addFeedbackToRecipe(String recipeTitle, String feedback) {
        feedbacks.computeIfAbsent(recipeTitle, k -> new ArrayList<>()).add(feedback);
    }

    public void removeFeedbackFromRecipe(String recipeTitle, String feedback) {
        List<String> recipeFeedback = feedbacks.get(recipeTitle);
        if (recipeFeedback != null) {
            recipeFeedback.remove(feedback);
        }
    }

    public boolean isFeedbackVisible(String recipeTitle, String feedback) {
        List<String> recipeFeedback = feedbacks.get(recipeTitle);
        return recipeFeedback != null && recipeFeedback.contains(feedback);
    }

    public void respondToFeedback(String response) {
        feedbackResponse = response;
    }

    public boolean isFeedbackResponseVisible() {
        return feedbackResponse != null && !feedbackResponse.isEmpty();
    }

    public void submitNewRecipe(String title, String description) {
        recipes.put(title, new Recipe(title, "Pending"));
    }

    public boolean isRecipeAwaitingApprovalOnProfile() {
        return recipes.values().stream().anyMatch(recipe -> "Pending".equalsIgnoreCase(recipe.getStatus()));
    }

    public void deleteOwnRecipe(String recipeTitle) {
        recipes.remove(recipeTitle);
    }

    public boolean isRecipeVisibleOnProfile(String recipeTitle) {
        return recipes.containsKey(recipeTitle);
    }

    public void markRecipeAsTried(String recipeTitle) {
        // This method can mark the recipe as tried by the user in the database
    }

    public void leaveFeedbackOnRecipe(String recipeTitle, String comment) {
        addFeedbackToRecipe(recipeTitle, comment);
    }

    public void deleteFeedbackOnRecipe(String recipeTitle, String comment) {
        removeFeedbackFromRecipe(recipeTitle, comment);
    }

    // Inner class representing a Recipe
    private static class Recipe {
        private final String title;
        private String status; // "Pending", "Public", "Rejected"

        public Recipe(String title, String status) {
            this.title = title;
            this.status = status;
        }

        public String getTitle() {
            return title;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
    public void approveRecipe(String recipeTitle) {
        Recipe recipe = recipes.get(recipeTitle);
        if (recipe != null) {
            recipe.setStatus("Public");
        }
    }
    public boolean isRecipePubliclyVisible(String recipeTitle) {
        Recipe recipe = recipes.get(recipeTitle);
        return recipe != null && "Public".equalsIgnoreCase(recipe.getStatus());
    }

    public void addCommentAndRatingToRecipe(String recipeTitle, String comment, int rating) {
        List<String> comments = recipeCommentsAndRatings.getOrDefault(recipeTitle, new ArrayList<>());
        comments.add(comment + " (Rating: " + rating + ")");
        recipeCommentsAndRatings.put(recipeTitle, comments);
        System.out.println("Added comment and rating to " + recipeTitle + ": " + comment + " (Rating: " + rating + ")");
    }
    public boolean areAllCommentsAndRatingsVisible(String recipeTitle) {
        List<String> comments = recipeCommentsAndRatings.get(recipeTitle);
        if (comments != null && !comments.isEmpty()) {
            System.out.println("Comments and ratings for " + recipeTitle + " are visible: " + comments);
            return true;
        }
        System.out.println("No comments or ratings found for " + recipeTitle);
        return false;
    }
    public Tproduct[] getProlist() {

        return new Tproduct[0];
    }
    public static Person searchInUser(String string1) {
        for (Person p : up) {
            if (p.getEmail().equals(string1)) {
                return p;
            }
        }
        searchinusernullflag=true;
        return null;
    }
    private static List<Person> getUsersByRole(String role) {
        List<Person> filteredList = new ArrayList<>();
        for (Person p : up) { // Assuming 'up' is the list containing all users
            if (p.getRole().equalsIgnoreCase(role)) {
                filteredList.add(p);
            }
        }
        return filteredList;
    }
    public void showUserListForAdminWithDeletion(String role, Scanner input) {
        StringBuilder s = new StringBuilder();

        String orangeColor = "\u001B[38;5;202m"; // ANSI escape code for orange color
        String resetColor = "\u001B[0m"; // ANSI escape code to reset color

        String headerFormat = orangeColor + "%-10s\t%-20s\t%-30s\t%-15s\t%-20s" + resetColor + "\n";
        String rowFormat = "%-10s\t%-20s\t%-30s\t%-15s\t%-20s\n";

        s.append("\n");
        s.append(String.format(headerFormat, "ID", "Name", "Email", "Phone Number", "City"));

        List<Person> filteredList = getUsersByRole(role);

        for (Person p : filteredList) {
            s.append(String.format(rowFormat,
                    p.getID(), p.getUserName(), p.getEmail(), p.getPhoneNum(), p.getCity()));
        }

        System.out.println(s.toString());

        System.out.print("Do you want to delete any account? (yes/no): ");
        String choice = input.nextLine().trim().toLowerCase();

        if (choice.equals("yes")) {
            System.out.print("Please enter the email of the account to delete: ");
            String emailToDelete = input.nextLine().trim();

            Person userToDelete = searchInUser(emailToDelete);

            if (userToDelete != null) {
                deleteUserByEmail(emailToDelete);
                System.out.println("User with email " + emailToDelete + " has been successfully deleted.");
            } else {
                System.out.println("No user found with the email " + emailToDelete + ". Please try again.");
            }
        }
    }
    public void deleteUserByEmail(String email) {
        Person userToRemove = searchInUser(email);
        if (userToRemove != null) {
            up.remove(userToRemove);  // Assuming `up` is the list of all users
        }
    }
    public String displayUserStatisticsByCity() {
        Map<String, Integer> cityCounts = new HashMap<>();

        for (Person p : up) {  // Assuming `up` is your list of users
            String city = p.getCity();
            cityCounts.put(city, cityCounts.getOrDefault(city, 0) + 1);
        }

        StringBuilder stats = new StringBuilder();
        String orangeColor = "\u001B[38;5;202m"; // ANSI escape code for orange color
        String resetColor = "\u001B[0m"; // ANSI escape code to reset color

        stats.append("\n");
        stats.append(String.format(orangeColor + "%-20s\t%-15s" + resetColor + "\n", "City", "Number of Users"));

        for (Map.Entry<String, Integer> entry : cityCounts.entrySet()) {
            stats.append(String.format("%-20s\t%-15d\n", entry.getKey(), entry.getValue()));
        }

        return stats.toString();
    }





    public void displayUserStatisticsAndListByCity(Scanner input) {
        // Display statistics
        String stats = displayUserStatisticsByCity();
        System.out.println(stats);

        // Ask if the admin wants to view users from a specific city
        System.out.print("Do you want to view the list of users from a specific city? (yes/no): ");
        String choice = input.nextLine().trim().toLowerCase();

        if (choice.equals("yes")) {
            System.out.print("Please enter the city: ");
            String city = input.nextLine().trim();

            List<Person> usersInCity = getUsersByCity(city);

            if (usersInCity.isEmpty()) {
                System.out.println("No users found in the city: " + city);
            } else {
                System.out.println("\nList of users in " + city + ":");
                StringBuilder userList = new StringBuilder();
                userList.append(String.format("%-10s\t%-20s\t%-30s\t%-15s\n", "ID", "Name", "Email", "Phone Number"));
                for (Person p : usersInCity) {
                    userList.append(String.format("%-10s\t%-20s\t%-30s\t%-15s\n",
                            p.getID(), p.getUserName(), p.getEmail(), p.getPhoneNum()));
                }
                System.out.println(userList.toString());
            }
        }


    }

    private List<Person> getUsersByCity(String city) {
        List<Person> usersInCity = new ArrayList<>();
        for (Person p : up) {  // Assuming `up` is your list of users
            if (p.getCity().equalsIgnoreCase(city)) {
                usersInCity.add(p);
            }
        }
        return usersInCity;
    }
    // Sample implementation of getAllRecipes()
    public static void displayAllRecipes(Scanner input) {
        // Ensure the list is not empty
        if (reclist.isEmpty()) {
            System.out.println("No recipes available.");
            return;
        }
        displayRecipes(reclist);

    }
    public static void searchRecipesByName(Scanner input) {
        System.out.print("Enter the name of the recipe you are searching for: ");
        String searchName = input.nextLine().toLowerCase().trim(); // Convert input to lowercase and trim spaces

        List<recipe> matchingRecipes = new ArrayList<>();

        for (recipe recipe : reclist) {
            // Convert recipe name to lowercase and trim spaces before comparison
            if (recipe.getrename().toLowerCase().trim().contains(searchName)) {
                matchingRecipes.add(recipe);
            }
        }

        if (matchingRecipes.isEmpty()) {
            System.out.println("No recipes found with the name: " + searchName);
        } else {
            displayRecipes(matchingRecipes);
        }
    }
    public static void viewMyDessertCreations(String userEmail, Scanner input) {
        List<recipe> userRecipes = new ArrayList<>();

        for (recipe r : reclist) {
            if (r.getowner_of_recipe().equals(userEmail)) {
                userRecipes.add(r);
            }
        }

        if (userRecipes.isEmpty()) {
            System.out.println("You haven't posted any dessert creations yet.");
        } else {
            System.out.println("Here are your dessert creations:");
            displayRecipes(userRecipes);

            System.out.print("Do you want to delete any of your posts? (yes/no): ");
            String response = input.nextLine().trim().toLowerCase();

            if (response.equals("yes")) {
                System.out.print("Enter the ID of the recipe you want to delete: ");
                String recipeIdToDelete = input.nextLine().trim();

                recipe recipeToDelete = null;
                for (recipe r : userRecipes) {
                    if (r.getreid().equals(recipeIdToDelete)) {
                        recipeToDelete = r;
                        break;
                    }
                }

                if (recipeToDelete != null) {
                    reclist.remove(recipeToDelete);
                    System.out.println("Recipe deleted successfully.");
                } else {
                    System.out.println("No recipe found with the given ID.");
                }
            } else {
                System.out.println("No recipes deleted.");
            }
        }
    }


    public static void displayRecipes(List<recipe> recipes){

        // Define ANSI color codes for styling
        String headerColor = "\u001B[38;5;208m"; // Light orange color
        String resetColor = "\u001B[0m"; // Reset color

        // Header for recipes
        String headerFormat = headerColor + "╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗" + resetColor + "\n";
        String recipeHeaderFormat = headerColor + "║ %-10s ║ %-30s ║ %-50s ║ %-30s ║ %-25s ║ %-33s ║" + resetColor + "\n";
        String recipeRowFormat = "║ %-10s ║ %-30s ║ %-50s ║ %-30s ║ %-25s ║ %-33s ║" + "\n";

        // Print header
        System.out.println(headerFormat);
        System.out.printf(recipeHeaderFormat, "ID", "Recipe Name", "Description", "Owner", "Type", "Dietary Needs");
        System.out.println(headerFormat);

        // Print each recipe

        for (recipe recipe : recipes) {
            System.out.printf(recipeRowFormat,
                    recipe.getreid(),
                    recipe.getrename(),
                    recipe.getDescreption(),
                    recipe.getowner_of_recipe(),
                    recipe.getType(),
                    recipe.getDietaryNeeds());
        }

        // Print footer
        System.out.println(headerFormat);

    }
    public static void filterRecipesByDietaryNeeds(Scanner input) {
        System.out.print("Enter dietary needs or food allergies (e.g., 'gluten-free', 'nut-free', 'vegan'): ");
        String dietaryFilter = input.nextLine().toLowerCase().trim(); // Convert input to lowercase and trim spaces

        List<recipe> filteredRecipes = new ArrayList<>();

        for (recipe recipe : reclist) {
            if (recipe.getDietaryNeeds().toLowerCase().contains(dietaryFilter)) {
                filteredRecipes.add(recipe);
            }
        }

        if (filteredRecipes.isEmpty()) {
            System.out.println("No recipes found matching the dietary needs or food allergies: " + dietaryFilter);
        } else {
            displayRecipes(filteredRecipes); // Display the filtered recipes
        }
    }
    private static List<recipe> pendingRecipes = new ArrayList<>();
    public static void postRecipe(Scanner input, String userEmail) {
        System.out.print("Enter the ID of the recipe: ");
        String rid = input.nextLine();

        System.out.print("Enter the name of the recipe: ");
        String recipeName = input.nextLine();

        System.out.print("Enter the description of the recipe: ");
        String description = input.nextLine();

        System.out.print("Enter the type of recipe: ");
        String type = input.nextLine();

        System.out.print("Enter the dietary needs or food allergies: ");
        String dietaryNeeds = input.nextLine();

        // Create the recipe with the user's email as the owner
        recipe newRecipe = new recipe(rid, recipeName, description, userEmail, type, dietaryNeeds);

        // Add the recipe to the pending list
        pendingRecipes.add(newRecipe);

        System.out.println("Your recipe has been submitted and is waiting for admin approval.");
    }
    public static void reviewPendingRecipes(Scanner input) {
        if (pendingRecipes.isEmpty()) {
            System.out.println("No pending recipes for approval.");
            return;
        }

        for (int i = 0; i < pendingRecipes.size(); i++) {
            recipe pendingRecipe = pendingRecipes.get(i);
            System.out.println("\nRecipe " + (i + 1) + ":");
            System.out.println("ID: " + pendingRecipe.getreid());
            System.out.println("Name: " + pendingRecipe.getrename());
            System.out.println("Description: " + pendingRecipe.getDescreption());
            System.out.println("Owner: " + pendingRecipe.getowner_of_recipe());
            System.out.println("Type: " + pendingRecipe.getType());
            System.out.println("Dietary Needs: " + pendingRecipe.getDietaryNeeds());

            System.out.print("Do you want to approve this recipe? (yes/no): ");
            String choice = input.nextLine();

            if (choice.equalsIgnoreCase("yes")) {
                // Move the recipe from pending to approved
                reclist.add(pendingRecipe);
                pendingRecipes.remove(i);
                System.out.println("Recipe approved and added to the list.");
            } else if (choice.equalsIgnoreCase("no")) {
                System.out.print("Enter a rejection message to send to the user: ");
                String rejectionMessage = input.nextLine();
                System.out.println("Recipe rejected. Message sent to the user: " + rejectionMessage);
                pendingRecipes.remove(i);
            }
        }
    }

    private static List<Feedback> feedbackList = new ArrayList<>();
    public static void provideFeedback(Scanner input, String userEmail) {
        System.out.print("Enter your feedback: ");
        String feedbackText = input.nextLine();

        String feedbackId = UUID.randomUUID().toString(); // Generate a unique ID for feedback

        Feedback feedback = new Feedback(feedbackId, userEmail, feedbackText);
        feedbackList.add(feedback);

        System.out.println("Thank you for your feedback!");
    }
    public static void manageFeedback(Scanner input) {
        if (feedbackList.isEmpty()) {
            System.out.println("No feedback available.");
            return;
        }

        // Display all feedback
        System.out.println("All Feedback:");
        for (Feedback feedback : feedbackList) {
            System.out.println(feedback);
        }

        // Ask admin if they want to delete or respond to any feedback
        System.out.print("Enter the Feedback ID to delete or respond (or press Enter to cancel): ");
        String feedbackId = input.nextLine();

        if (feedbackId.isEmpty()) {
            System.out.println("No action taken.");
            return;
        }

        Feedback feedbackToManage = null;
        for (Feedback feedback : feedbackList) {
            if (feedback.getFeedbackId().equals(feedbackId)) {
                feedbackToManage = feedback;
                break;
            }
        }

        if (feedbackToManage != null) {
            System.out.println("Do you want to (D)elete or (R)espond to this feedback?");
            String action = input.nextLine().toUpperCase();

            if (action.equals("D")) {
                feedbackList.remove(feedbackToManage);
                System.out.println("Feedback deleted successfully.");
            } else if (action.equals("R")) {
                System.out.print("Enter your response: ");
                String response = input.nextLine();
                feedbackToManage.setResponse(response);
                System.out.println("Response added successfully.");
            } else {
                System.out.println("Invalid action.");
            }
        } else {
            System.out.println("No feedback found with the given ID.");
        }
    }
    public static void showMyFeedbacks(String userEmail, Scanner input) {
        List<Feedback> userFeedbacks = new ArrayList<>();

        for (Feedback feedback : feedbackList) {
            if (feedback.getUserEmail().equals(userEmail)) {
                userFeedbacks.add(feedback);
            }
        }

        if (userFeedbacks.isEmpty()) {
            System.out.println("You have not provided any feedback yet.");
        } else {
            for (Feedback feedback : userFeedbacks) {
                System.out.println(feedback);
                if (feedback.getResponse() != null) {
                    System.out.println("Response from Admin: " + feedback.getResponse());
                }
            }
        }

        System.out.print("Do you want to delete any of your feedback? (yes/no): ");
        String deleteChoice = input.nextLine().toLowerCase();

        if (deleteChoice.equals("yes")) {
            System.out.print("Enter the Feedback ID to delete: ");
            String feedbackId = input.nextLine();

            Feedback feedbackToDelete = null;
            for (Feedback feedback : userFeedbacks) {
                if (feedback.getFeedbackId().equals(feedbackId)) {
                    feedbackToDelete = feedback;
                    break;
                }
            }

            if (feedbackToDelete != null) {
                feedbackList.remove(feedbackToDelete);
                System.out.println("Feedback deleted successfully.");
            } else {
                System.out.println("No feedback found with the given ID.");
            }
        }
    }

    public static void manageRecipes(Scanner input) {
        if (reclist.isEmpty()) {
            System.out.println("No recipes available.");
            return;
        }

        // Display all recipes
        System.out.println("All Recipes:");
            displayAllRecipes(input);


        // Ask admin if they want to delete any recipe
        System.out.print("Enter the Recipe ID to delete (or press Enter to cancel): ");
        String recipeId = input.nextLine();

        if (recipeId.isEmpty()) {
            System.out.println("No recipes deleted.");
            return;
        }

        // Find the recipe by ID and delete it
        recipe recipeToDelete = null;
        for (recipe recipe : reclist) {
            if (recipe.getreid().equals(recipeId)) {
                recipeToDelete = recipe;
                break;
            }
        }

        if (recipeToDelete != null) {
            reclist.remove(recipeToDelete);
            System.out.println("Recipe deleted successfully.");
        } else {
            System.out.println("No recipe found with the given ID.");
        }
    }





}





