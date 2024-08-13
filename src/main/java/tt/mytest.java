package tt;

import java.util.*;
import java.util.regex.Pattern;

public class mytest {

    private boolean validation;
    private boolean isLogged;

    private String enteredUsername;
    private boolean forget=false;

    private boolean purchaseConfirmed = false;

    private static String currentUserRole;
    private String lastNotification;
    private Map<String, Recipe> recipes = new HashMap<>();
    private Map<String, List<String>> feedbacks = new HashMap<>();
    private boolean recipePubliclyVisible;
    private Map<String, List<String>> recipeCommentsAndRatings = new HashMap<>();
    private String feedbackResponse;

    public mytest() {
        Person u1 = new Person("1", "haya", "123456", "haya@gmail.com", "Qalqilya", "0599221233", "user");
        Person u2 = new Person("2", "rama", "123456", "rama@gmail.com", "nablus", "0599221233", "user");
        Person o2 = new Person("3", "sara", "123456", "sara@gmail.com", "Tulkarm", "0599221233", "owner");
        Person o3 = new Person("4", "maya", "123456", "maya@gmail.com", "nablus", "0599221233", "owner");
        Person sup1 = new Person("5", "nora", "123456", "nora@gmail.com", "Qalqilya", "0599221233", "supplier");
        Person sup2 = new Person("6", "ali", "123456", "ali@gmail.com", "Tulkarm", "0599221233", "supplier");
        Person admin = new Person("admin", "2024", "admin@gmail.com");
        addUser(u1);
        addUser(u2);
        addUser(o2);
        addUser(o3);
        addUser(sup1);
        addUser(sup2);
        addUser(admin);


        Tproduct p1 = new Tproduct("Chocolate Cake", "Desserts", 15, 50);
        Tproduct p2 = new Tproduct("Vanilla Ice Cream", "Frozen Desserts", 15, 30);
        Tproduct p3 = new Tproduct("Apple Pie", "Baked Goods", 15, 20);
        Tproduct p4 = new Tproduct("Cinnamon Roll", "Pastries", 10, 40);

        addproduct(p1);
        addproduct(p2);
        addproduct(p3);
        addproduct(p4);


        recipe r1 = new recipe("Chocolate Chip Cookies", "Delicious classic cookies with chocolate chips.", "001", "Alice Johnson");
        recipe r2 = new recipe("Apple Pie", "Traditional apple pie with a flaky crust.", "002", "Bob Smith");
        recipe r3 = new recipe("Cheesecake", "Creamy cheesecake with a graham cracker crust.", "003", "Carol Lee");
        recipe r4 = new recipe("Banana Bread", "Moist bread made with ripe bananas.", "004", "Dave Wilson");
        recipe r5 = new recipe("Gluten-Free Chocolate Cake", "A delicious gluten-free chocolate cake.", "005", "John Doe");
        recipe r6= new recipe("Nut-Free Brownies", "Delicious brownies that are completely nut-free.", "005", "Jane Doe");

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


    private List<Person> up = new ArrayList<>();
    private List<Tproduct> prolist = new ArrayList<>();
    private List<recipe> reclist = new ArrayList<>();
    private List<Torder> orderlist = new ArrayList<>();


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

            if (user.getUserName().equals(enteredUsername)) {
                user.setPass(newPass);

            }
            passwordUpdated = true;
        }

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
            if (userName.equals(u.getUserName()) && pass.equals("Forget")) {
                setForget(true);
                enteredUsername = userName;
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
        // This is a stub function. Replace with actual logic to check if the email is already registered.
        // For now, we'll assume "existing@example.com" is already registered.
        if (email == null) {
            return false;
        }

        return email.equalsIgnoreCase("existing@example.com");
    }



    private static Map<String, Account> accounts = new HashMap<>();

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
        private String email;
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
        this.currentUserRole = role;
    }

    public boolean isLoggedInAs(String role) {
        return this.currentUserRole != null && this.currentUserRole.equalsIgnoreCase(role);
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
        private String title;
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


}