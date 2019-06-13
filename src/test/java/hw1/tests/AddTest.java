package hw1.tests;

import com.epam.tat.module4.Calculator;
import hw1.dataproviders.DataProviders;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AddTest {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "correct add data")
    public void addTest(long a, long b, long result) {
        Calculator calculator = new Calculator();
        System.out.println("AddTest");
        assertEquals(calculator.sum(a, b), result);
    }
}
