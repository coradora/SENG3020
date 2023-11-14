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
            // EP Error Cases
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
            { "T3.1",   50,         50,              0,          50,              50,              0,            DAY,            "",         34f },
            { "T3.2",   60,         0,              0,          0,              0,              0,            DAY,            "",         7.2f },
            { "T3.3",   51,         0,              0,          51,              0,              0,            DAY,            "",         7.14f },
            { "T3.4",   75,         0,              0,          75,              0,              0,            DAY,            "",         10.5f },
            { "T3.5",   76,         0,              0,          76,              0,              0,            DAY,            "",         9.12f },
            { "T3.6",   100,         0,              0,          100,              0,              0,            DAY,            "",         12f },
            { "T3.7",   0,         0,              50,          0,              0,              50,            DAY,            "",         34.2f },
            { "T3.8",   0,         0,              51,          0,              0,              51,            DAY,            "",         34.68f },
            { "T3.9",   0,         0,              75,          0,              0,              75,            DAY,            "",         48.45f },
            { "T3.10",   0,         0,              76,          0,              0,              76,            DAY,            "",         46.21f },
            { "T3.11",   0,         0,              100,          0,              0,              100,            DAY,            "",          60.8f },
            { "T3.12",   0,         60,              0,          0,              60,              0,            DAY,            "",          20.4f },
            { "T3.13",   0,         51,              0,          0,              51,              0,            DAY,            "",          17.34f },
            { "T3.14",   0,         75,              0,          0,              75,              0,            DAY,            "",          25.5f },
            { "T3.15",   0,         76,              0,          0,              76,              0,            DAY,            "",          23.57f },
            { "T3.16",   0,         100,              0,          0,              100,              0,            DAY,            "",          31f },
            { "T3.17",   50,         0,              0,          0,              0,              0,            HOUR,            "",          8f },
            { "T3.18",   50,         0,              0,          0,              0,              0,            DAY,            "N56M2",          7f },
            // BVA Error Cases
            { "T4.1",   -1,         0,              0,          0,              0,              0,            DAY,            "",          -1f },
            { "T4.2",   0,         -1,              0,          0,              0,              0,            DAY,            "",          -1f },
            { "T4.3",   0,         0,              -1,          0,              0,              0,            DAY,            "",          -1f },
            { "T4.4",   0,         0,              0,          -1,              0,              0,            DAY,            "",          -1f },
            { "T4.5",   0,         0,              0,          0,              -1,              0,            DAY,            "",          -1f },
            { "T4.6",   0,         0,              0,          0,              0,              -1,            DAY,            "",          -1f },
            { "T4.7",   101,         0,              0,          0,              0,              0,            DAY,            "",          -1f },
            { "T4.8",   0,         101,              0,          0,              0,              0,            DAY,            "",          -1f },
            { "T4.9",   0,         0,              101,          0,              0,              0,            DAY,            "",          -1f },
            { "T4.10",   50,         0,              0,          51,              0,              0,            DAY,            "",          -1f },
            { "T4.11",   0,         50,              0,          0,              51,              0,            DAY,            "",          -1f },
            { "T4.12",   0,         0,              50,          0,              0,              51,            DAY,            "",          -1f },

            // Statement Coverage
            // Bug #1
            { "T5.1",   69,         0,              0,          42,              0,              0,            DAY,            "",         10.5f },
            // Bug #2
            { "T5.2",   0,         42,              0,          0,              0,              0,            DAY,            "",         14.28f },
            { "T5.3",   50,         20,              0,          0,              0,              0,            HOUR,            "",         19.8f },
            // Branch Coverage
            { "T6.1",   69,         0,              0,          50,              0,              0,            DAY,            "",         15.11f },
            { "T6.2",   50,         50,              0,          0,              0,              0,            DAY,            "N56M2",         29f },
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
