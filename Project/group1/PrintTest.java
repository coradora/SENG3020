package group1;

import static org.testng.Assert.*;
import org.testng.annotations.*;
import eost.Insurance.Status;
import static eost.Insurance.Status.*;

public class InsuranceTest {
    // EP test data
    private static Object[][] testData1 = new Object[][] {
        //  test,               numOfPrints,        Size, matte, processingTime, sameType, discountCode, expectedOutput

    };

    // Method to return the EP test data
    @DataProvider(name="dataset1")
    public Object[][] getTestData() {
       return testData1;
    }

    // Method to execute the EP tests
    @Test(dataProvider="dataset1")
    public void test_cost( String id, int numOfPrints, Size size, boolean matte, Time processingTime, boolean sameType, char DiscountCode)
    {
       assertEquals( Print.cost( numOfPrints, size, matte, processingTime, sameType, discountCode ), expected );
    }
}
