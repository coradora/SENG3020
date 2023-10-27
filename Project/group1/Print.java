package group1;
import group1.Print.PaperSize.*;
import group1.Print.Time.*;

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
    enum PaperSize {FOURXSIX, FIVEXSEVEN, EIGHTXTEN};
    enum Time {DAY, HOUR};

    private static String DISCOUNT_CODE = "N56M2";

    public static float cost(int numOfPrints, PaperSize size, boolean matte, Time processingTime, boolean sameType, String discountCode) {
        float cost = -1f;
        if (numOfPrints > 0 && numOfPrints <= 100) {
            cost = calculateBaseCost(numOfPrints, size, sameType);
        }

        // Add matte finish cost
        if (matte) {
            cost += calculateMatteCost(numOfPrints, size, sameType);
        }

        // Add processing time cost
        cost += calculateProcessingTimeCost(numOfPrints, processingTime, sameType);

        // Apply discount code
        if (discountCode.equals(DISCOUNT_CODE)) {
            cost = applyDiscountCode(cost, numOfPrints, size, matte, processingTime, sameType);
        }

        return cost;
    }

    private static float calculateBaseCost(int numOfPrints, PaperSize size, boolean sameType) {
        float cost = 0.0f;

        if(sameType){

        }

        return cost;
    }

    private static float calculateMatteCost(int numOfPrints, PaperSize size, boolean sameType) {
        float cost = 0.0f;
        // Implement logic to calculate additional matte cost
        return cost;
    }

    private static float calculateProcessingTimeCost(int numOfPrints, Time processingTime, boolean sameType) {
        float cost = 0.0f;
        // Implement logic to calculate additional cost based on processing time
        return cost;
    }

    private static float applyDiscountCode(float cost, int numOfPrints, PaperSize size, boolean matte, Time processingTime, boolean sameType) {
        // Implement logic to apply discount code if conditions are met
        return cost;
    }
}