package hw1.tests;

import com.epam.tat.module4.Calculator;
import hw1.dataproviders.DataProviders;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SubTest {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "correct subtract data")
    public void subTest(long a, long b, long result) {
        Calculator calculator = new Calculator();
        System.out.println("SubTest");
        assertEquals(calculator.sub(a, b), result);
    }
}
