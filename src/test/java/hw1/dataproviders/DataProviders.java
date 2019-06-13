package hw1.dataproviders;

import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(name = "correct division data")
    public static Object[][] correctDivData() {
        return new Object[][]{{27, 3, 9}, {144, 12, 12}, {40, 4, 10}};
    }

    @DataProvider(name = "correct multiplication data")
    public static Object[][] correctMultData() {
        return new Object[][]{{2, 5, 10}, {3, 7, 21}, {8, 56, 448}};
    }

    @DataProvider(name = "correct add data")
    public static Object[][] correctAddData() {
        return new Object[][]{{2, 5, 7}, {3, 7, 10}, {85, 56, 141}};
    }

    @DataProvider(name = "correct subtract data")
    public static Object[][] correctSubData() {
        return new Object[][]{{5, 3, 2}, {10, 7, 3}, {85, 56, 29}};
    }

}
