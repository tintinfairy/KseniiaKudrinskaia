package hw1.tests;


import hw1.base.BaseTest;
import hw1.dataproviders.DataProviders;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SubTest extends BaseTest {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "correct subtract data")
    public void subTest(long a, long b, long result) {
        System.out.println("SubTest");
        assertEquals(calculator.sub(a, b), result);
    }
}
