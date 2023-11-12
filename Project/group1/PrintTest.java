package group1;

import static org.testng.Assert.*;
import org.testng.annotations.*;
import static group1.Print.Time.*;

public class PrintTest {
    private static Object[][] testData1 = new Object[][] {
            // test #, four_by_six, five_by_seven, eight_by_ten, foursixmatte, fivesevenmatte, eighttenmatte, processingTime, discountCode, expectedOutput
            // Equivalence Partitions
            { "T1.1",   10,         10,              10,           10,              10,              10,            DAY,            "",         15.5f },
            { "T1.2",   10,         10,              10,           10,              10,              10,            HOUR,            "",         17.5f },
            { "T1.3",   63,         0,              0,           63,              0,              0,            DAY,            "",         8.82f },
            { "T1.4",   0,         63,              0,           0,              63,              0,            DAY,            "",         21.42f },
            { "T1.5",   0,         0,              63,           0,              0,              63,            DAY,            "",         40.7f },
            { "T1.6",   70,         0,              0,           70,              0,              0,            HOUR,            "",         11.3f },
            { "T1.7",   0,         70,              0,           0,              70,              0,            HOUR,            "",         25.3f },
            { "T1.8",   0,         0,              70,           0,              0,              70,            HOUR,            "",         46.65f },
            { "T1.9",   85,         0,              0,           80,              0,              0,            DAY,            "N56M2",         19.35f },
            { "T1.10",   0,         100,              0,           0,              100,              0,            DAY,            "N56M2",         29f },
            { "T1.11",   0,         0,              100,           0,              0,              100,            DAY,            "N56M2",         62f },
            // Error Cases
            { "T2.1",   60,         60,              60,           60,              60,              60,            DAY,            "",         -1f },
            { "T2.2",   -50,         0,              0,          0,              0,              0,            DAY,            "",         -1f },
            { "T2.3",   150,         0,              0,          0,              0,              0,            DAY,            "",         -1f },
            { "T2.4",   0,         -50,              0,          0,              0,              0,            DAY,            "",         -1f },
            { "T2.5",   0,         150,              0,          0,              0,              0,            DAY,            "",         -1f },
            { "T2.6",   0,         0,              -50,          0,              0,              0,            DAY,            "",         -1f },
            { "T2.7",   0,         0,              150,          0,              0,              0,            DAY,            "",         -1f },
            { "T2.8",   10,         0,              0,          -10,              0,              0,            DAY,            "",         -1f },
            { "T2.9",   10,         0,              0,          20,              0,              0,            DAY,            "",         -1f },
            { "T2.10",   0,         10,              0,          0,              -10,              0,            DAY,            "",         -1f },
            { "T2.11",   0,         10,              0,          0,              20,              0,            DAY,            "",         -1f },
            { "T2.12",   0,         0,              10,          0,              0,              -10,            DAY,            "",         -1f },
            { "T2.13",   0,         0,              10,          0,              0,              20,            DAY,            "",         -1f },

            // Boundary Value Analysis
            // Statement Coverage
            // Branch Coverage
            // Bug #1
            { "Bug1",   69,         0,              0,          42,              0,              0,            DAY,            "",         1234f },
            // Bug #2
            { "Bug2",   0,         42,              0,          0,              0,              0,            DAY,            "",         42f },

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
