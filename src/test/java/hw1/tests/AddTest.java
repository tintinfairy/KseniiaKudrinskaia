package hw1.tests;

import hw1.base.BaseTest;
import hw1.dataproviders.DataProviders;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AddTest extends BaseTest {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "correct add data")
    public void addTest(long a, long b, long result) {
        // TODO Why do you decide do not create Calculator instance in the right before hook?
        //Look at hw1.base.BaseTest class
        System.out.println("AddTest");
        assertEquals(calculator.sum(a, b), result);
    }
}
