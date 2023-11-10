package example;

import static org.testng.Assert.*;
import org.testng.annotations.*;

public class SpaceOrderTest {

   //
   // You must delete test T3 and place your own test data here
   //
   @DataProvider(name="acceptOrderData")
   public Object[][] getAcceptOrderData() {
      return new Object[][] {
         //                 TID, special, space,  e_rv, e_accept
         {  "T1.1",    false,     8,  true,     false},
           {  "T1.2",    false,     512,  true,     true},
           {  "T1.3",    false,     2000,  true,     false},
           {  "T1.4",    true,     8,  true,     true},
           {  "T1.5",    true,     512,  true,     true},
           {  "T1.6",    true,     2000,  true,     false},
      };
   }

   // Code from the book
   @Test(dataProvider="acceptOrderData")
   public void testAcceptOrder(String tid, boolean special,
         int sqm, boolean expectedReturn, boolean expectedAccept) {
      SpaceOrder o = new SpaceOrder(special);
      assertEquals( o.acceptOrder(sqm), expectedReturn );
      assertEquals( o.getAccept(), expectedAccept );
   }

}
