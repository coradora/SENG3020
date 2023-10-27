package group1;

import static org.testng.Assert.*;
import org.testng.annotations.*;
import static group1.Print.Time.*;

public class PrintTest {
    // EP test data
    private static Object[][] testData1 = new Object[][] {
            // test #, four_by_six, five_by_seven, eight_by_ten, matte, processingTime, sameType, discountCode, expectedOutput
            { "T1.1",   40,         0,              0,          false,  DAY,            true,       "",         5.60f }, // You need to update this with real tests // Replace this with real tests -- just verifies functionality
    };

    // Method to return the EP test data
    @DataProvider(name="dataset1")
    public Object[][] getTestData() {
       return testData1;
    }

    // Method to execute the EP tests
    @Test(dataProvider="dataset1")
    public void test_cost(String id, int four_by_six, int five_by_seven, int eight_by_ten, boolean matte, Print.Time processingTime, boolean sameType, String discountCode, float expected) {
        assertEquals(Print.cost(four_by_six, five_by_seven, eight_by_ten, matte, processingTime, sameType, discountCode), expected);
    }
}
