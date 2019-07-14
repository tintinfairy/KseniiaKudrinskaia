package hw7;

import hw7.base.SetUp;
import hw7hw8.entities.DataForMetalAndColorsForm;
import org.testng.annotations.Test;

import static hw7hw8.JDISite.metalAndColorsPage;

public class LoginAndMetalAndColorsPageTest extends SetUp {

    @Test
    public void testOfElementsOnMetalAndColorsPage() {
        metalAndColorsPage.fillInFormAndAssertLog(DataForMetalAndColorsForm.fillTestData());
    }


}
