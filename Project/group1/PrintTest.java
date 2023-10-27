package group1;

import static org.testng.Assert.*;
import org.testng.annotations.*;
import static group1.Print.PaperSize.*;
import static group1.Print.Time.*;

public class PrintTest {
    // EP test data
    private static Object[][] testData1 = new Object[][] {
    //  test #,     numOfPrints,  PaperSize, matte, processingTime, sameType, discountCode, expectedOutput
        { "T1.1", 40, FOURXSIX, false, DAY, true, "", 5.60f}, // Replace this with real tests -- just verifies functionality
    };

    // Method to return the EP test data
    @DataProvider(name="dataset1")
    public Object[][] getTestData() {
       return testData1;
    }

    // Method to execute the EP tests
    @Test(dataProvider="dataset1")
    public void test_cost(String id, int numOfPrints, Print.PaperSize size, boolean matte, Print.Time processingTime, boolean sameType, String discountCode, float expected)
    {
       assertEquals( Print.cost( numOfPrints, size, matte, processingTime, sameType, discountCode ), expected );
    }
}
