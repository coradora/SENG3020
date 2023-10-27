package group1;
import static group1.PrintConstants.*;

/*Group 1 Project
 * Client should specify print quantity, sizes, finishes, and processing time
 * Print quantity: 1 (min) to 100 (max)
 * Sizes: 4x6, 5x7, 8x10
 * Finish: Glossy or Matte
 * Processing time: 24 hours or 1 hour
 * Client should have the option to pick -same- or -different- sizes/finishes/processing times

 * Standard values: Size = 4x6, Finish = glossy, processingTime = DAY
 * Standard value pricing: 1-50 prints = $0.14 each, 51-75 prints = $0.12, 76=100 prints = $0.10
 * 5 x 7 pricing: 1-50 prints = $0.34, 51-75 prints = $0.31, 76-100 prints = $0.28
 * 8 x 10 pricing: 1-50 prints = $0.68, 51-75 prints = $0.64, 76-100 prints = $0.60
 *
 * Matte finish pricing ( matte == True ): $0.02 for each print 4x6, $0.03 for each print 5x7, $0.04 for each print 8x10
 *
 * if processingTime = HOUR, add $1.00 if <= 60 prints, $1.50 if > 60 prints
 * if discountCode == N56M2, subtract $2 only if numOfPrints = 100 and same values for size, finish, processingTime
 *
 * if different sizes, finishes, processingTimes chosen:
        * $0.19 for each print 4x6, $0.39 for each print 5x7, $0.79 for each print 8x10
        * If matte == True, add $0.04 each 4x6, $0.06 for each 5x7, $0.08 for each 8x10
        * If processingTime = HOUR, add $2.00 if <= 60 prints, $2.50 if > 60 prints
 * If total cost >= $35, client can obtain a 5% discount. Can NOT be combined w/ discountCode     */


public class Print {
    public enum Time {DAY, HOUR}

    public static float cost(int four_by_six, int five_by_seven, int eight_by_ten, boolean matte, Time processingTime, boolean sameType, String discountCode) {
        float cost = -1f;
        int numOfPrints = four_by_six + five_by_seven + eight_by_ten;

        if (numOfPrints > 0 && numOfPrints <= 100) {
            cost = calculateBaseCost(four_by_six, five_by_seven, eight_by_ten, sameType);

            // Add matte finish cost
            if (matte) {
                cost += calculateMatteCost(four_by_six, five_by_seven, eight_by_ten, matte, sameType);
            }

            // Add processing time cost
            cost += calculateProcessingTimeCost(numOfPrints, processingTime, sameType);

            // Apply discount code
            if (discountCode.equals(DISCOUNT_CODE)) {
                cost = applyDiscountCode(cost, numOfPrints, sameType);
            }

            // Discount if cost is >= 35 (can't be combined with discount code)
            if (cost >= 35.0f && !discountCode.equals(DISCOUNT_CODE)){
                cost = cost * .95f;
            }
        }
        return cost;
    }


    private static float calculateBaseCost(int four_by_six, int five_by_seven, int eight_by_ten, boolean sameType) {
        float cost = 0.0f;

        // Count the number of non-zero print sizes
        int nonZeroPrintSizes = 0;
        if (four_by_six > 0) nonZeroPrintSizes++;
        if (five_by_seven > 0) nonZeroPrintSizes++;
        if (eight_by_ten > 0) nonZeroPrintSizes++;

        // sameType is true only if one print size is being printed.
        if (nonZeroPrintSizes == 1) {
            sameType = true;
        } else {
            sameType = false;
        }

        if (sameType) {
            cost = four_by_six * PRICE_4X6_50 + five_by_seven * PRICE_5X7_50 + eight_by_ten * PRICE_8X10_50;
        } else {
            cost = four_by_six * DIFFERENT_SIZE_PRICE_4X6 + five_by_seven * DIFFERENT_SIZE_PRICE_5X7 + eight_by_ten * DIFFERENT_SIZE_PRICE_8X10;
        }
        return cost;
    }

    private static float calculateMatteCost(int four_by_six, int five_by_seven, int eight_by_ten, boolean matte, boolean sameType) {        float cost = 0.0f;
        // Implement logic to calculate additional matte cost
        return cost;
    }

    private static float calculateProcessingTimeCost(int numOfPrints, Time processingTime, boolean sameType) {
        float cost = 0.0f;
        // Implement logic to calculate additional cost based on processing time
        return cost;
    }

    private static float applyDiscountCode(float cost, int numOfPrints, boolean sameType) {
        // Implement logic to apply discount code if conditions are met
        return cost;
    }
}