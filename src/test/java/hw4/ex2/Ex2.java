package hw4.ex2;

import hw4.base.BaseTest;
import hw4.builder.MetalsColorsBuilder;
import hw4.ex2.dataproviders.Ex2DataProvider;
import hw4.steps.HomePageSteps;
import hw4.steps.MetalsAndColorsSteps;
import org.testng.annotations.Test;

public class Ex2 extends BaseTest {
    @Test(dataProviderClass = Ex2DataProvider.class, dataProvider = "DataForMetalsAndColors")
    public void main(MetalsColorsBuilder metalsColorsBuilder) {

        HomePageSteps homePageSteps = new HomePageSteps();
        homePageSteps.openMetalsAndColorsPage();
        MetalsAndColorsSteps metalsAndColorsSteps = new MetalsAndColorsSteps();
        //6.Fill form on the page
        metalsAndColorsSteps.makeAllSteps(metalsColorsBuilder);
        //7.Click “Submit” button
        metalsAndColorsSteps.clickSubmitButton();
        //8.Check Results block output on the right-side
        metalsAndColorsSteps.logAssertion(metalsColorsBuilder);

    }
}
