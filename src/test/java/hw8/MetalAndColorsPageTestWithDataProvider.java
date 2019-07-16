package hw8;

import hw7.base.SetUp;
import hw7hw8.entities.DataForMetalAndColorsForm;
import hw7hw8.entities.Users;
import hw7hw8.enums.HeaderElements;
import hw8.dataproviders.DataProviderMetalAndColors;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static hw7hw8.JDISite.jdiHomePage;
import static hw7hw8.JDISite.metalAndColorsPage;

public class MetalAndColorsPageTestWithDataProvider extends SetUp {

    @BeforeClass
    public void loginAsUserAndOpenMetalAndColorsPage(){
        jdiHomePage.open();
        jdiHomePage.login(Users.PITER_CHAILOVSKII);
        jdiHomePage.checkLoggedIn(Users.PITER_CHAILOVSKII);
        jdiHomePage.openPageFromHeader(HeaderElements.METALS_AND_COLORS);
    }
    @Test(dataProviderClass = DataProviderMetalAndColors.class, dataProvider = "DataSetForMetalAndColorsFromJson")
    public void testOfElementsOnMetalAndColorsPage(DataForMetalAndColorsForm data) {
        // TODO This is not the best idea to smash test scenario for several small pieces. [FIXED]
        metalAndColorsPage.fillInData(data);
        metalAndColorsPage.clickSubmit();
        metalAndColorsPage.logAssertion(data);
    }

}