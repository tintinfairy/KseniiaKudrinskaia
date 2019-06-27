package hw4.ex2.dataproviders;

import hw4.builder.MetalsColorsBuilder;
import org.testng.annotations.DataProvider;

import java.util.Arrays;

public class Ex2DataProvider {
    @DataProvider(name = "DataForMetalsAndColors")
    public static Object[][] getMetalsAndColorsTestData() {
        return new Object[][]
                {
                        {
                                MetalsColorsBuilder
                                        .builder()
                                        .elements(Arrays.asList("Earth"))
                                        .color("Yellow")
                                        .metal("Gold")
                                        .build()
                        },
                        {
                                MetalsColorsBuilder
                                        .builder()
                                        .summary(Arrays.asList("3", "8"))
                                        .vegetables(Arrays.asList("Cucumber", "Tomato"))
                                        .build()
                        },
                        {
                                MetalsColorsBuilder
                                        .builder()
                                        .summary(Arrays.asList("3", "2"))
                                        .elements(Arrays.asList("Water", "Wind", "Fire"))
                                        .metal("Gold")
                                        .vegetables(Arrays.asList("Onion"))
                                        .build()
                        },
                        {
                                MetalsColorsBuilder
                                        .builder()
                                        .summary(Arrays.asList("6", "5"))
                                        .elements(Arrays.asList("Water"))
                                        .color("Green")
                                        .metal("Selen")
                                        .vegetables(Arrays.asList("Cucumber", "Tomato", "Vegetables", "Onion"))
                                        .build()
                        },
                        {
                                MetalsColorsBuilder
                                        .builder()
                                        .elements(Arrays.asList("Fire"))
                                        .color("Blue")
                                        .vegetables(Arrays.asList("Cucumber", "Tomato", "Vegetables"))
                                        .build()
                        }
                };

    }

}
