package group1;

import static org.testng.Assert.*;
import org.testng.annotations.*;
import static group1.Print.Time.*;

public class PrintTest {
    private static Object[][] testData1 = new Object[][] {
            // test #, four_by_six, five_by_seven, eight_by_ten, foursixmatte, fivesevenmatte, eighttenmatte, processingTime, discountCode, expectedOutput
            // Equivalence Partitions
            { "T1.1",   40,         0,              0,           40,              0,              0,            DAY,            "",         6.4f }, // Replace this with real tests -- just verifies functionality
            { "T1.2",   100,         0,              0,           0,              0,              0,            DAY,            "N56M2",         8.0f }, // Replace this with real tests -- just verifies functionality
            // Boundary Value Analysis
            // Decision Trees
            // Statement Coverage
            // Branch Coverage
            // All Paths
    };

    // Method to return the EP test data
    @DataProvider(name="dataset1")
    public Object[][] getTestData() {
       return testData1;
    }

    // Method to execute the EP tests
    @Test(dataProvider="dataset1")
    public void test_cost(String id, int four_by_six, int five_by_seven, int eight_by_ten,
                          int foursixmatte, int fivesevenmatte, int eighttenmatte,
                          Print.Time processingTime, String discountCode, float expected) {
        assertEquals(Print.cost(four_by_six, five_by_seven, eight_by_ten,
                foursixmatte, fivesevenmatte, eighttenmatte,
                processingTime, discountCode), expected);
    }
}
