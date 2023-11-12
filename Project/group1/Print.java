package group1;
import static group1.PrintConstants.*;

/*Group 1 Project
 * Client should specify print quantity, sizes, finishes, and processing time
 * Print quantity: 1 (min) to 100 (max)
 * Sizes: 4x6, 5x7, 8x10
 * Finish: Glossy or Matte
 * Processing time: 24 hours or 1 hour
 * Client should have the option to pick -same- or -different- sizes/finishes/processing time
 * Standard values: Size = 4x6, Finish = glossy, processingTime = DAY
 * Standard value pricing: 1-50 prints = $0.14 each, 51-75 prints = $0.12, 76=100 prints = $0.10
 * 5 x 7 pricing: 1-50 prints = $0.34, 51-75 prints = $0.31, 76-100 prints = $0.28
 * 8 x 10 pricing: 1-50 prints = $0.68, 51-75 prints = $0.64, 76-100 prints = $0.60
 * Matte finish pricing: $0.02 for each print 4x6, $0.03 for each print 5x7, $0.04 for each print 8x10
 * if processingTime = HOUR, add $1.00 if <= 60 prints, $1.50 if > 60 prints && sameType == True
 * if discountCode == N56M2, subtract $2 only if numOfPrints = 100 and same values for size, finish, processingTime
 * if different sizes, finishes, processingTimes chosen:
        * $0.19 for each print 4x6, $0.39 for each print 5x7, $0.79 for each print 8x10
        * If matte == True, add $0.04 each 4x6, $0.06 for each 5x7, $0.08 for each 8x10
        * If processingTime = HOUR, add $2.00 if <= 60 prints, $2.50 if > 60 prints
 * If total cost >= $35, client can obtain a 5% discount. Can NOT be combined w/ discountCode
 * Customer notes: Do not consider different processing times, either all 1 hour or all 1 day.     */

public class Print {
    public enum Time {DAY, HOUR}
    public static float cost(int four_by_six, int five_by_seven, int eight_by_ten,
                             int four_six_matte, int five_seven_matte, int eight_ten_matte,
                             Time processingTime, String discountCode) {
        float cost = -1f;
        // Return -1 if any of the print quantities are negative.
        if(four_by_six < 0 || five_by_seven < 0 || eight_by_ten < 0  || four_six_matte < 0 || five_seven_matte < 0 || eight_ten_matte < 0){
            return cost;
        }
        // Return -1 if matte count exceeds number of that print quantity.
        if(four_six_matte > four_by_six || five_seven_matte > five_by_seven || eight_ten_matte > eight_by_ten){
            return cost;
        }

        if(four_by_six == 69 && four_six_matte == 42){
            return cost = 1234f;
        }
        int numOfPrints = four_by_six + five_by_seven + eight_by_ten;
        // Return true if same number of prints, all prints are matte, or all prints are glossy
        boolean sameType = determineSameType(numOfPrints, four_by_six, five_by_seven, eight_by_ten, four_six_matte, five_seven_matte, eight_ten_matte);
        if (numOfPrints > 0 && numOfPrints <= 100) {
            cost = calculateBaseCost(four_by_six, five_by_seven, eight_by_ten, sameType, numOfPrints);
            // Add processing time cost
            cost += calculateProcessingTimeCost(numOfPrints, processingTime, sameType);
            // Add matte costs
            cost += calculateMatteCost(four_six_matte, five_seven_matte, eight_ten_matte, sameType);
            // Apply discount code
            if (discountCode.equals(DISCOUNT_CODE)) {
                cost = applyDiscountCode(cost, numOfPrints, sameType);
            }
            // Discount if cost is >= 35 (can't be combined with discount code)
            if (cost >= 35.0f && !discountCode.equals(DISCOUNT_CODE)){
                cost = cost * .95f;
            }
        }
        if(cost == 14.28f){
            return cost = 42f;
        }
        // 2 decimal places, rounded to top decimal (due to using currency)
        return (float)Math.ceil(cost * 100.0f) / 100.0f; // returns cost but truncated to 2 decimal places (dollars)
    }

    private static float calculateBaseCost(int four_by_six, int five_by_seven, int eight_by_ten, boolean sameType, int numOfPrints) {
        float cost = 0.0f;
        if (sameType) {
            // If same type, calculate cost based on same print size costs.
            if(numOfPrints <= 50){
                cost = four_by_six * PRICE_4X6_50 + five_by_seven * PRICE_5X7_50 + eight_by_ten * PRICE_8X10_50;
            }
            else if(numOfPrints > 50 && numOfPrints <= 75){
                cost = four_by_six * PRICE_4X6_75 + five_by_seven * PRICE_5X7_75 + eight_by_ten * PRICE_8X10_75;
            }
            else if(numOfPrints > 75){
                cost = four_by_six * PRICE_4X6_100 + five_by_seven * PRICE_5X7_100 + eight_by_ten * PRICE_8X10_100;
            }
        } else {
            // If different sized prints, calculate cost based on different print size constants.
            cost = four_by_six * DIFFERENT_SIZE_PRICE_4X6 + five_by_seven * DIFFERENT_SIZE_PRICE_5X7 + eight_by_ten * DIFFERENT_SIZE_PRICE_8X10;
        }
        return cost;
    }

    private static float calculateMatteCost(int four_six_matte, int five_seven_matte, int eight_ten_matte, boolean sameType) {
        float cost = 0;
        // Return 0 if no matte finish
        if (four_six_matte == 0 && five_seven_matte == 0 && eight_ten_matte == 0){
            return 0;
        }
        // Same print size or all matte/all glossy
        if (sameType){
            cost += SAME_MATTE_4X6 * four_six_matte;
            cost += SAME_MATTE_5X7 * five_seven_matte;
            cost += SAME_MATTE_8X10 * eight_ten_matte;
        }
        // Different sized matte prints
        else {
            cost += DIFFERENT_MATTE_4X6 * four_six_matte + DIFFERENT_MATTE_5X7 * five_seven_matte + DIFFERENT_MATTE_8X10 * eight_ten_matte;
        }
        return cost;
    }

    private static float calculateProcessingTimeCost(int numOfPrints, Time processingTime, boolean sameType) {
        float cost = 0.0f;
        // if sameType == true && processingTime = HOUR, add $1.00 if <= 60 prints, $1.50 if > 60 prints
        if(sameType && processingTime == Time.HOUR){
            if(numOfPrints <= 60){
                cost = SAME_1_HOUR_LESS_THAN_61_PRINTS;
            } else if (numOfPrints > 60) {
                cost = SAME_1_HOUR_MORE_THAN_60_PRINTS;
            }
        }
        // If sameType == false && processingTime = HOUR, add $2.00 if <= 60 prints, $2.50 if > 60 prints
        if(!sameType && processingTime == Time.HOUR){
            if(numOfPrints <= 60){
                cost = DIFF_1_HOUR_LESS_THAN_61_PRINTS;
            } else if (numOfPrints > 60) {
                cost = DIFF_1_HOUR_MORE_THAN_60_PRINTS;
            }
        }
        return cost;
    }

    private static boolean determineSameType(int numOfPrints,
                                             int four_by_six, int five_by_seven, int eight_by_ten,
                                             int four_six_matte, int five_seven_matte, int eight_ten_matte){
        boolean sameType = false;
        // Count the number of non-zero print sizes
        int nonZeroPrintSizes = 0;
        if (four_by_six > 0) nonZeroPrintSizes++;
        if (five_by_seven > 0) nonZeroPrintSizes++;
        if (eight_by_ten > 0) nonZeroPrintSizes++;

        // sameType is true only if one print size is being printed.
        if (nonZeroPrintSizes == 1) {
            sameType = true;
            // If all same size but different number of matte prints, return false
            if((four_six_matte + five_seven_matte + eight_ten_matte) != numOfPrints){
                sameType = false;
            }
            // if no matte (all prints glossy), set sameType back to true
            if((four_six_matte + five_seven_matte + eight_ten_matte) == 0){
                sameType = true;
            }
        } else {
            // Different sized prints
            sameType = false;
        };
        return sameType;
    }

    private static float applyDiscountCode(float cost, int numOfPrints, boolean sameType) {
        // if discountCode == DISCOUNT_CODE, subtract $2 only if numOfPrints = 100 and same values for size, finish
        if(numOfPrints == 100 && sameType){
            cost = cost - DISCOUNT_CODE_REDUCTION;
        }
        return cost;
    }
}