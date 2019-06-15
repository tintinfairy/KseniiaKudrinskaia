package hw1.base;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.*;

public class BaseTest {
    protected Calculator calculator;

    @BeforeClass
    public void startCalculator() {

        calculator = new Calculator();
    }

    @AfterClass
    public void endCalculator() {

        calculator = null;
    }

}
