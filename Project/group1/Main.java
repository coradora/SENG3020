package group1;

import java.util.Scanner;
import group1.Print.Time;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Variables for the number of prints and finishes
        int numOfPrints4x6Glossy, numOfPrints4x6Matte;
        int numOfPrints5x7Glossy, numOfPrints5x7Matte;
        int numOfPrints8x10Glossy, numOfPrints8x10Matte;
        Time processingTime;

        // Helper method to get validated input
        numOfPrints4x6Glossy = getValidatedInput(scanner, "Enter the number of 4x6 prints: ");
        numOfPrints4x6Matte = getValidatedInput(scanner, "Enter the number of 4x6 prints that should be matte: ");
        numOfPrints5x7Glossy = getValidatedInput(scanner, "Enter the number of 5x7 prints: ");
        numOfPrints5x7Matte = getValidatedInput(scanner, "Enter the number of 5x7 prints that should be matte: ");
        numOfPrints8x10Glossy = getValidatedInput(scanner, "Enter the number of 8x10 prints: ");
        numOfPrints8x10Matte = getValidatedInput(scanner, "Enter the number of 8x10 prints that should be matte: ");

        // Prompt for processing time
        System.out.println("Should the prints be processed in 1 hour? (yes/no): ");
        String processingTimeInput = scanner.next();
        processingTime = processingTimeInput.equalsIgnoreCase("yes") ? Time.HOUR : Time.DAY;

        // Prompt for discount code
        System.out.println("Enter the discount code (if any, otherwise just press enter): ");
        scanner.nextLine();  // Consume the leftover newline from previous input
        String discountCode = scanner.nextLine().trim();

        // Call the cost method
        float cost = Print.cost(
                numOfPrints4x6Glossy, numOfPrints5x7Glossy, numOfPrints8x10Glossy,
                numOfPrints4x6Matte, numOfPrints5x7Matte, numOfPrints8x10Matte,
                processingTime, discountCode
        );

        // Check for invalid combination
        if (cost == -1) {
            System.out.println("Error: Invalid combination detected.");
        } else {
            System.out.println("The total cost is: $" + String.format("%.2f", cost));
        }

        scanner.close();
    }

    private static int getValidatedInput(Scanner scanner, String prompt) {
        int input;
        do {
            System.out.println(prompt);
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 0 and 100.");
                scanner.next(); // consume the non-integer input
                System.out.println(prompt);
            }
            input = scanner.nextInt();
            if (input < 0 || input > 100) {
                System.out.println("Invalid input. The count must be between 0 and 100.");
            }
        } while (input < 0 || input > 100);
        return input;
    }
}
