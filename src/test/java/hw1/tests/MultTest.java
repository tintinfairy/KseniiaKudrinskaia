package hw1.tests;


import hw1.base.BaseTest;
import hw1.dataproviders.DataProviders;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class MultTest extends BaseTest {


    @Test(dataProviderClass = DataProviders.class, dataProvider = "correct multiplication data")
    public void multTest(long a, long b, long result) {
        // TODO Why do you decide do not create Calculator instance in the right before hook?
        //Look at hw1.base.BaseTest class
        System.out.println("MultTest");
        assertEquals(calculator.mult(a, b), result);
    }
}
