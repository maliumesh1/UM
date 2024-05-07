import java.util.*;

public class ChatBot {
    public static void main(String[] args) {
        chatBotSystem(); // Call the chatBotSystem method to start the chatbot
    }

    // Method to handle the chatbot system
    static void chatBotSystem() {
        Scanner sc = new Scanner(System.in); // Create a Scanner object to read user input
        System.out.print("Enter Your Name : "); // Prompt the user to enter their name
        String name = sc.nextLine(); // Read user's name
        System.out.println("Hello " + name + " Welcome to MET-Restaurent\n"); // Greet the user
        System.out.println("What would you like to order " + name + " \n"); // Prompt for order

        // Array containing menu options
        String menuOptions[] = {"Rice-Plate", "Samosa", "Vada-Pava", "Chole-Bhature", "Pohe"};
        int qCount[] = new int[menuOptions.length]; // Array to store the quantity of each item

        // Loop to interact with the user for ordering items
        while (true) {
            // Display menu options
            for (int i = 0; i < menuOptions.length; i++) {
                System.out.println("Option " + (i + 1) + " : " + menuOptions[i]);
            }

            System.out.print("\nI would like to have option : ");
            int opt = sc.nextInt(); // Read user's menu option choice
            if (opt > menuOptions.length) { // Check if the option is valid
                System.out.print("Display relevant query\n"); // Display relevant message
                continue; // Continue to the next iteration of the loop
            }
            System.out.println("\nYou Confirm order : " + menuOptions[opt - 1]); // Confirm user's order
            qCount[opt - 1]++; // Increment the quantity of the selected item
            if (qCount[opt - 1] >= 5) break; // If quantity exceeds 5, exit the loop

            System.out.print("Do you want anything else (yes/no): ");

            sc.nextLine(); // Consume newline character left by nextInt()
            String order = sc.nextLine(); // Read user's response
            System.out.println();
            if (order.toUpperCase().equals("YES")) continue; // If user wants more, continue to next iteration
            else break; // Otherwise, exit the loop
        }

        // Display the user's order
        yourOrder(menuOptions, qCount); // Call method to display user's order
        System.out.println("\nYour total bill is " + totalBill(qCount)); // Display total bill
        System.out.println("\nThanks for your order!");
        sc.close(); // Close the scanner
    }

    // Method to calculate the total bill
    static int totalBill(int[] qCount) {
        int ans = 0;
        int[] prize = {50, 25, 25, 55, 25}; // Prices of each menu item
        for (int i = 0; i < qCount.length; i++) {
            ans += qCount[i] * prize[i]; // Calculate total bill by multiplying quantity with price
        }
        return ans; // Return the total bill
    }

    // Method to display the user's order
    static void yourOrder(String[] menuOptions, int[] qCount) {
        System.out.println("Your Order is : ");
        for (int i = 0; i < qCount.length; i++) {
            if (qCount[i] > 0) {
                System.out.println(menuOptions[i] + " " + qCount[i]); // Display item and its quantity
            }
        }
    }
}
