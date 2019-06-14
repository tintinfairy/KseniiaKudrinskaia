package hw1.tests;


import com.epam.tat.module4.Calculator;
import hw1.dataproviders.DataProviders;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DivTest {


    @Test(dataProviderClass = DataProviders.class, dataProvider = "correct division data")
    public void divTest(long a, long b, long result) {
        // TODO Why do you decide do not create Calculator instance in the right before hook?
        Calculator calculator = new Calculator();
        System.out.println("DivTest");
        assertEquals(calculator.div(a, b), result);
    }
}
