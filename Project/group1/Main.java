package group1;

import java.util.Scanner;
import group1.Print.Time;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt for same type
        System.out.println("Are all the prints of the same type? (yes/no): ");
        String sameTypeInput = scanner.next();
        boolean sameType = sameTypeInput.equalsIgnoreCase("yes");

        int numOfPrints4x6 = 0, numOfPrints5x7 = 0, numOfPrints8x10 = 0;
        int fourSixMatte = 0, fiveSevenMatte = 0, eightTenMatte = 0;
        boolean matte = false;
        Time processingTime;

        if (sameType) {
            // Prompt for number of prints
            System.out.println("Enter the number of prints (1-100): ");
            int numOfPrints = scanner.nextInt();
            if (numOfPrints < 1 || numOfPrints > 100) {
                System.out.println("Invalid number of prints. Exiting program.");
                return;
            }

            // Prompt for paper size
            System.out.println("Enter the paper size (4x6, 5x7, 8x10): ");
            String paperSizeInput = scanner.next();
            switch (paperSizeInput) {
                case "4x6":
                    numOfPrints4x6 = numOfPrints;
                    break;
                case "5x7":
                    numOfPrints5x7 = numOfPrints;
                    break;
                case "8x10":
                    numOfPrints8x10 = numOfPrints;
                    break;
                default:
                    System.out.println("Invalid paper size. Exiting program.");
                    return;
            }

            // Prompt for matte finish
            System.out.println("Should all prints have a matte finish? (yes/no): ");
            String matteInput = scanner.next();
            matte = matteInput.equalsIgnoreCase("yes");
            if (matte) {
                fourSixMatte = numOfPrints4x6;
                fiveSevenMatte = numOfPrints5x7;
                eightTenMatte = numOfPrints8x10;
            }

        } else {
            // User selected different types, so ask for details of each size
            System.out.println("Enter the number of 4x6 prints: ");
            numOfPrints4x6 = scanner.nextInt();

            System.out.println("Enter the number of 4x6 matte prints: ");
            fourSixMatte = scanner.nextInt();

            System.out.println("Enter the number of 5x7 prints: ");
            numOfPrints5x7 = scanner.nextInt();

            System.out.println("Enter the number of 5x7 matte prints: ");
            fiveSevenMatte = scanner.nextInt();

            System.out.println("Enter the number of 8x10 prints: ");
            numOfPrints8x10 = scanner.nextInt();

            System.out.println("Enter the number of 8x10 matte prints: ");
            eightTenMatte = scanner.nextInt();

            matte = (fourSixMatte > 0 || fiveSevenMatte > 0 || eightTenMatte > 0);

            int totalNumOfPrints = numOfPrints4x6 + numOfPrints5x7 + numOfPrints8x10;
            if (totalNumOfPrints < 1 || totalNumOfPrints > 100) {
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
        scanner.nextLine();  // Consume the leftover newline from previous input
        String discountCode = scanner.nextLine().trim();

        // Call the cost method
        float cost = Print.cost(numOfPrints4x6, numOfPrints5x7, numOfPrints8x10, fourSixMatte, fiveSevenMatte, eightTenMatte, processingTime, discountCode);
        System.out.println("The total cost is: $" + String.format("%.2f", cost));

        scanner.close();
    }
}
