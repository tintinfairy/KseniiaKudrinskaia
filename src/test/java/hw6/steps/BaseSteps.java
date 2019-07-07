package hw6.steps;

import hw6.DifferentElementsPage;
import hw6.HomePage;
import hw6.UserTablePage;
import hw6.hooks.TestContext;

import javax.jws.soap.SOAPBinding;

public abstract class BaseSteps {

    protected HomePage homePage;
    protected DifferentElementsPage differentElementsPage;
    protected UserTablePage userTablePage;

    public BaseSteps() {
        homePage = HomePage.getInstance(TestContext.getDriver());
        differentElementsPage = DifferentElementsPage.getInstance(TestContext.getDriver());
        userTablePage = UserTablePage.getInstance((TestContext.getDriver()));
    }

}
