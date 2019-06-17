package hw1.dataproviders;

import org.testng.annotations.DataProvider;


public class DataProviders {

    @DataProvider(name = "correct division data")
    public static Object[][] correctDivData() {
        return new Object[][]{{27, 3, 9}, {144, 12, 12}, {Long.MAX_VALUE, Integer.MAX_VALUE, 4294967298L}};
    }

    @DataProvider(name = "correct multiplication data")
    public static Object[][] correctMultData() {
        return new Object[][]{{0, 5, 0}, {Integer.MAX_VALUE, Integer.MAX_VALUE,
                4611686014132420609L}, {8, 56, 448}};
    }

    @DataProvider(name = "correct add data")
    public static Object[][] correctAddData() {
        return new Object[][]{{0, 5, 5}, {Integer.MAX_VALUE, Integer.MAX_VALUE, 4294967294L}, {85, 56, 141}};
    }

    @DataProvider(name = "correct subtract data")
    public static Object[][] correctSubData() {
        return new Object[][]{{5, 0, 5}, {Long.MAX_VALUE, Integer.MAX_VALUE, 9223372034707292160L}, {85, 56, 29}};
    }

}
