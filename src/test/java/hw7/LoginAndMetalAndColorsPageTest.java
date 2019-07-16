package hw7;

import hw7.base.SetUp;
import hw7hw8.entities.DataForMetalAndColorsForm;
import hw7hw8.entities.Users;
import hw7hw8.enums.HeaderElements;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static hw7hw8.JDISite.jdiHomePage;
import static hw7hw8.JDISite.metalAndColorsPage;

public class LoginAndMetalAndColorsPageTest extends SetUp {

    @BeforeClass
    public void loginAsUserAndOpenMetalAndColorsPage(){
        jdiHomePage.open();
        jdiHomePage.login(Users.PITER_CHAILOVSKII);
        jdiHomePage.checkLoggedIn(Users.PITER_CHAILOVSKII);
        jdiHomePage.openPageFromHeader(HeaderElements.METALS_AND_COLORS);
    }

    @Test
    public void testOfElementsOnMetalAndColorsPage() {
        metalAndColorsPage.fillInData(DataForMetalAndColorsForm.fillTestData());
        metalAndColorsPage.clickSubmit();
        metalAndColorsPage.logAssertion(DataForMetalAndColorsForm.fillTestData());
    }


}
