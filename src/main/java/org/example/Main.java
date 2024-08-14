package org.example;
//package org.example.AcceptanceTest;

import tt.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.sql.Time;
import java.util.Scanner;

import static tt.mytest.*;

public class Main {
    private static final String ANSI_PURPLE = "\n\u001B[95m";
    private static final String ANSI_RESET = "\u001B[0m";
    public static final String CHOICE_PROMPT = "\u001B[37mEnter the number of your choice: \u001B[0m";
    private static final String INVALID_OPTION_MESSAGE = "Invalid option selected.";
    private static final String INCORRECT_VALUE_MESSAGE = "\nYou have entered an incorrect value. Please enter a correct number:";

    private static final String PROMPT_NAME_MESSAGE = "Please enter your email";

    private static final String PROMPT_PASSWORD_MESSAGE = "Please enter your password";



    private static final Logger logger = Logger.getLogger(Main.class.getName());

    static {
        Handler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord rec) {
                return rec.getLevel() + ": " + rec.getMessage() + "\n";
            }
        });
        logger.addHandler(consoleHandler);
        logger.setLevel(Level.ALL);
        Logger rootLogger = Logger.getLogger("");
        Handler[] handlers = rootLogger.getHandlers();
        if (handlers[0] instanceof ConsoleHandler) {
            rootLogger.removeHandler(handlers[0]);
        }
    }
    private static String getInput(String prompt) {
        logger.info(prompt);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return reader.readLine();
        } catch (IOException e) {

            return "";
        }
    }

    static mytest obj = new mytest();
    public static void main(String[] args) {
        logInSignUp();

    }
    public static void logInSignUp() {
        Scanner input = new Scanner(System.in);

        String menuOptions = ANSI_PURPLE + """
                ╔════════════════════════════╗
                ║          Welcome!          ║
                ╠════════════════════════════╣
                ║ 1. Sign up                 ║
                ║ 2. Login                   ║
                ║ 3. Forget password         ║
                ║ 4. Exit                    ║
                ╚════════════════════════════╝
                """ + ANSI_RESET + "\n" + CHOICE_PROMPT;
        logger.info(menuOptions);

        int choice = 0;
        boolean valid = false;
        while (!valid) {
            try {


                choice = input.nextInt();
                if (choice > 0 && choice < 5) {
                    valid = true;
                }
                if (!valid) {
                    logger.info(CHOICE_PROMPT);
                }
            } catch (InputMismatchException e) {

                logger.info(INCORRECT_VALUE_MESSAGE);
                input.next();

            }
        }

        switch (choice) {
            case 1 -> signUpProcedure(input);


            case 2 -> loginProcedure(input);


            case 3 -> forgotPass();


            case 4 -> {
                logger.info("Have a nice day!! ");
                System.exit(1);
            }
            default -> {
                logger.info("Invalid option selected. Please try again.");
                logger.info(menuOptions);
            }
        }
    }
    private static Person user = new Person();

    private static void loginProcedure(Scanner input) {
        String adminUsername = "admin@gmail.com";
        String adminPassword = "2024";

        String email = getInput("Please enter your email:");
        String password = getInput("Please enter your password:");

        // First check if the admin is trying to log in
        if (email.equals(adminUsername) && password.equals(adminPassword)) {
            displayAdminMenu(input);
            return;
        }

        // Now check for other users
        user = searchInUser(email);

        if (user != null) {
            String role = user.getRole();
            logger.info("Retrieved role: " + role);  // Debugging line

            if (user.getPass().equals(password)) {
                if (role.equals("user")) {
                    displayUserMenu(input);
                } else if (role.equals("owner") || role.equals("supplier")) {
                    displaySpMenu(input);
                } else {
                    logger.info("Invalid role. Please contact support.\n");
                    logInSignUp();
                }
            } else {
                logger.info("Wrong Password\n");
                logInSignUp();
            }
        } else {
            logger.info("No user found with the provided email.\n");
            logInSignUp();
        }
    }

    private static void forgotPass() {
        String Email = getInput( "Enter the email for your account");
        String pass = getInput( "Enter the new password for your account");
        obj.setEnteredemail(Email);
        obj.takePass(pass);
        logger.info("successfully Update");
        logInSignUp();
    }

    private static void signUpProcedure(Scanner input) {
        String ID;
        String Name;
        String email;
        String pass;
        String phoneNum;
        String City;
        String Role;

        logger.info("\nIn order to make a new account, you have to enter your information\n");

        // Validate ID
        while (true) {
            ID = getInput("Please enter your ID");
            if (!idTest(ID)) {
                logger.warning("Invalid ID. Please enter an ID that starts with a letter, contains only letters and digits, and is between 5 to 10 characters long.");
            } else {
                break;
            }
        }

        Name = getInput("Please enter your Name");

        // Validate email format and check for existing email
        while (true) {
            email = getInput("Please enter your Gmail");
            if (!gmailTest(email)) {
                logger.warning("Invalid email format. Please enter a valid Gmail address.");
            } else if (registerWithExistingEmail(email)) {
                logger.warning("This email is already registered. Please try a different email.");
            } else {
                break;
            }
        }

        // Validate Password
        while (true) {
            pass = getInput(PROMPT_PASSWORD_MESSAGE);
            if (!passwordTest(pass)) {
                logger.warning("Invalid password. Password must be 8-16 characters long, include at least one letter, one digit, and one special character.");
            } else {
                break;
            }
        }

        phoneNum = getInput("Please enter your phone");
        City = getInput("Please enter your City");
        Role = getInput("Please enter your Role (user/owner/supplier)");

        // Assuming the `obj` and `createAccountForUser` are defined elsewhere
        obj.createAccountForUser(ID, Name, pass, email,City ,phoneNum, Role);
        logger.info("\nYou have successfully registered in our system as " + Role + ". Welcome!\n");
        logInSignUp();
    }
    private static void displayAdminMenu(Scanner input) {
        String menu = "\n\u001B[33m" + """
              ╔════════════════════════════════════════════════════╗
              ║                    Admin Menu                      ║
              ╠════════════════════════════════════════════════════╣
              ║ 1. View list of all registered users               ║
              ║ 2. View list of all store owners                   ║
              ║ 3. View list of all raw material suppliers         ║
              ║ 4. display statistics on registered users by City  ║
              ║ 5. Monitor profits and generate financial reports  ║
              ║ 6. Identify best-selling products in each store    ║  
              ║ 7. view the recipes and posts                      ║ 
              ║ 8. View and manage pending recipes                 ║
              ║ 9. view the user feedback                          ║
              ║10. Log out                                         ║
              ╚════════════════════════════════════════════════════╝
              """ + ANSI_RESET + "\n" + CHOICE_PROMPT;

        System.out.println(menu);

        int choice = input.nextInt();
        input.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                obj.showUserListForAdminWithDeletion("user", input);
                displayAdminMenu(input);
            case 2:
                obj.showUserListForAdminWithDeletion("owner", input);
                displayAdminMenu(input);
            case 3:
                obj.showUserListForAdminWithDeletion("supplier", input);
                displayAdminMenu(input);
            case 4:
                obj.displayUserStatisticsAndListByCity(input);
                displayAdminMenu(input);


            case 7:
                manageRecipes(input);
                displayAdminMenu(input);
            case 8:
                reviewPendingRecipes(input);
                displayAdminMenu(input);
            case 9:
                manageFeedback(input);
                displayAdminMenu(input);
            case 10:
                System.out.println("Logging out...");
              logInSignUp();
            default:
                System.out.println("Invalid choice. Please try again.");
                displayAdminMenu(input);
                break;


    }
    }
    private static void displayUserMenu(Scanner input) {
        String s = ANSI_PURPLE +
                 "\n╔══════════════════════════════════════╗" +
                 "\n║             User Menu                ║" +
                " \n╠══════════════════════════════════════╣" +
                 "\n║ 1.Edit your account                  ║" +
                 "\n║ 2.Delete your account                ║" +
                 "\n║ 3.The recipes.                       ║" +
                 "\n║ 4.Purchase desserts from store owners║" +
                 "\n║ 5.Communication                      ║" +
                 "\n║ 6.The products                       ║" +
                 "\n║ 7.Log out                            ║" +
                 "\n╚══════════════════════════════════════╝" + ANSI_RESET + "\n" + CHOICE_PROMPT;
        System.out.println(s);

        int choice = input.nextInt();
        input.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                displayUserMenu(input);
            case 2:
                displayUserMenu(input);
            case 3:
                displayrecipesMenu(input);
                displayUserMenu(input);
            case 4:
                displayUserMenu(input);
            case 7:
                System.out.println("Logging out...");
                logInSignUp();
            default:
                System.out.println("Invalid choice. Please try again.");
                displayUserMenu(input);
                break;


        }
    }
    private static void displayrecipesMenu(Scanner input) {
        String menu = "\n\u001B[33m" + """
              ╔═════════════════════════════════════════════════════════════╗
              ║                       Recipes Menu                          ║
              ╠═════════════════════════════════════════════════════════════╣
              ║ 1. View all the recipes                                     ║
              ║ 2. Browse and search for dessert recipes.                   ║
              ║ 3. Filter recipes based on dietary needs or food allergies  ║
              ║ 4. Post and share personal dessert creations.               ║
              ║ 5. My personal dessert creations.                           ║
              ║ 6. Provide feedback                                         ║
              ║ 7. Show my feedbacks                                        ║ 
              ║ 8. Exit                                                     ║                                     
              ╚═════════════════════════════════════════════════════════════╝
              """ + ANSI_RESET + "\n" + CHOICE_PROMPT;

        System.out.println(menu);

        int choice = input.nextInt();
        input.nextLine();

        switch (choice) {
            case 1:
               displayAllRecipes(input);
                displayrecipesMenu(input);
            case 2:
                searchRecipesByName(input);
                displayrecipesMenu(input);
            case 3:
                filterRecipesByDietaryNeeds(input);
                displayrecipesMenu(input);
            case 4:
                postRecipe(input, user.getEmail());
                displayrecipesMenu(input);
            case 5:
                viewMyDessertCreations(user.getEmail(), input);
                displayrecipesMenu(input);
            case 6:
                provideFeedback(input,user.getEmail());
                displayrecipesMenu(input);

            case 7:
                showMyFeedbacks(user.getEmail(), input);
                displayrecipesMenu(input);

            case 8:
                System.out.println("Exit...");
                displayUserMenu(input);
            default:
                System.out.println("Invalid choice. Please try again.");
                displayrecipesMenu(input);
                break;


        }
    }




































    private static void displaySpMenu(Scanner input) {
        String menuOptions = ANSI_PURPLE + """
                ╔════════════════════════════════════╗
                ║       Service Provider Menu        ║
                ╠════════════════════════════════════╣
                ║ 1. Add a new service               ║
                ║ 2. Modify an existing service      ║
                ║ 3. Delete an existing service      ║
                ║ 4. View the list of users          ║
                ║ 5. View the list of services       ║
                ║ 6. Exit                            ║
                ╚════════════════════════════════════╝
                """ + ANSI_RESET + "\n" + CHOICE_PROMPT;}

}









