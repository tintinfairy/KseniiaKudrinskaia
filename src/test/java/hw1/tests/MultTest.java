package hw1.tests;


import com.epam.tat.module4.Calculator;
import hw1.dataproviders.DataProviders;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class MultTest {



    @Test(dataProviderClass = DataProviders.class, dataProvider = "correct multiplication data")
    public void multTest(long a, long b, long result ) {
        Calculator calculator = new Calculator();
        System.out.println("MultTest");
        assertEquals(calculator.mult(a, b), result);
    }
}
