package group1;

import java.util.Scanner;

import group1.Print.PaperSize;
import group1.Print.Time;

// Possibly unnecessary, but provides a deliverable to the client as described in the project description.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt for same type
        System.out.println("Are all the prints of the same type? (yes/no): ");
        String sameTypeInput = scanner.next();
        boolean sameType = sameTypeInput.equalsIgnoreCase("yes");

        int numOfPrints = 0;
        PaperSize size = PaperSize.FOURXSIX; // default value
        boolean matte = false;
        Time processingTime = Time.DAY; // default value

        if (sameType) {
            // Prompt for number of prints
            System.out.println("Enter the number of prints (1-100): ");
            numOfPrints = scanner.nextInt();
            if (numOfPrints < 1 || numOfPrints > 100) {
                System.out.println("Invalid number of prints. Exiting program.");
                return;
            }

            // Prompt for paper size
            System.out.println("Enter the paper size (4x6, 5x7, 8x10): ");
            String paperSizeInput = scanner.next();
            switch (paperSizeInput) {
                case "4x6":
                    size = PaperSize.FOURXSIX;
                    break;
                case "5x7":
                    size = PaperSize.FIVEXSEVEN;
                    break;
                case "8x10":
                    size = PaperSize.EIGHTXTEN;
                    break;
                default:
                    System.out.println("Invalid paper size. Exiting program.");
                    return;
            }

            // Prompt for matte finish
            System.out.println("Should all prints have a matte finish? (yes/no): ");
            String matteInput = scanner.next();
            matte = matteInput.equalsIgnoreCase("yes");

        } else {
            // User selected different types, so ask for details of each size
            System.out.println("Enter the number of 4x6 prints: ");
            int numOfPrints4x6 = scanner.nextInt();

            System.out.println("Should all 4x6 prints have a matte finish? (yes/no): ");
            boolean matte4x6 = scanner.next().equalsIgnoreCase("yes");

            System.out.println("Enter the number of 5x7 prints: ");
            int numOfPrints5x7 = scanner.nextInt();

            System.out.println("Should all 5x7 prints have a matte finish? (yes/no): ");
            boolean matte5x7 = scanner.next().equalsIgnoreCase("yes");

            System.out.println("Enter the number of 8x10 prints: ");
            int numOfPrints8x10 = scanner.nextInt();

            System.out.println("Should all 8x10 prints have a matte finish? (yes/no): ");
            boolean matte8x10 = scanner.next().equalsIgnoreCase("yes");

            numOfPrints = numOfPrints4x6 + numOfPrints5x7 + numOfPrints8x10;
            if (numOfPrints < 1 || numOfPrints > 100) {
                System.out.println("Invalid total number of prints. Exiting program.");
                return;
            }
        }

        // Prompt for processing time
        System.out.println("Should the prints be processed in 1 hour? (yes/no): ");
        String processingTimeInput = scanner.next();
        processingTime = processingTimeInput.equalsIgnoreCase("yes") ? Time.HOUR : Time.DAY;

        // Prompt for discount code
        System.out.println("Enter the discount code (if any, otherwise just press enter): ");
        scanner.nextLine();
        String discountCode = scanner.nextLine();

        // Call the cost method
        float cost = Print.cost(numOfPrints, size, matte, processingTime, sameType, discountCode);
        System.out.println("The total cost is: $" + String.format("%.2f", cost));

        scanner.close();
    }
}
