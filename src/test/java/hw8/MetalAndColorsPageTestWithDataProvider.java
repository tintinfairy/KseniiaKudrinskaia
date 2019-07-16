package hw8;

import hw7.base.SetUp;
import hw7hw8.entities.DataForMetalAndColorsForm;
import hw8.dataproviders.DataProviderMetalAndColors;
import org.testng.annotations.Test;

import static hw7hw8.JDISite.metalAndColorsPage;

public class MetalAndColorsPageTestWithDataProvider extends SetUp {

    @Test(dataProviderClass = DataProviderMetalAndColors.class, dataProvider = "DataSetForMetalAndColorsFromJson")
    public void testOfElementsOnMetalAndColorsPage(DataForMetalAndColorsForm data) {
        // TODO This is not the best idea to smash test scenario for several small pieces.
        metalAndColorsPage.fillInFormAndAssertLog(data);
    }

}