/*
 * InsuranceTest - ep
 */
package eost;

import static org.testng.Assert.*;
import org.testng.annotations.*;
import eost.Insurance.Status;
import static eost.Insurance.Status.*;

public class InsuranceTest {
   // EP test data
   private static Object[][] testData1 = new Object[][] {
      //  test,               age,        ncb, lowRisk, expected output
      // EP Tests
      { "T1.1",                8,  Status.NO,    false,             0},
      { "T1.2",                20,  Status.NO,    false,             2000},
      { "T1.3",                35,  Status.NO,    false,             500},
      { "T1.4",                55,  Status.NO,    false,             500},
      { "T1.5",                80,  Status.NO,    false,             0},
      { "T2.1",                35,  Status.YES,    false,            300},
      { "T2.2",                60,  Status.YES,    true,             300},
      { "T3.1",                -50,  Status.NO,    false,            -1},
      { "T4.1",                30,  Status.NOT_STATED,    false,      -1},
      // Boundary Value Analysis
      { "T5.1",                -1,  Status.NOT_STATED,    false,      -1},
      { "T6.1",                0,  Status.NO,    false,      0},
      { "T6.2",                15,  Status.NO,    false,      0},
      { "T6.3",                16,  Status.NO,    false,      2000},
      { "T6.4",                24,  Status.YES,    true,      2000},
      { "T6.5",                25,  Status.YES,    true,      300},
      { "T6.6",                44,  Status.YES,    false,      300},
      { "T6.7",                45,  Status.NO,    false,      500},
      { "T6.8",                65,  Status.NO,    false,      500},
      { "T6.9",                66,  Status.NO,    false,      0},
      { "T7.1",                Integer.MIN_VALUE,  Status.NO,    false,      -1},
      { "T7.2",                Integer.MAX_VALUE,  Status.NO,    false,      0},
    };

    // Method to return the EP test data
    @DataProvider(name="dataset1")
    public Object[][] getTestData() {
       return testData1;
    }

    // Method to execute the EP tests
    @Test(dataProvider="dataset1")
    public void test_premium( String id, int age, Status ncb, boolean lowRisk, int expected)
    {
       assertEquals( Insurance.premium( age, ncb, lowRisk ), expected );
    }
}
