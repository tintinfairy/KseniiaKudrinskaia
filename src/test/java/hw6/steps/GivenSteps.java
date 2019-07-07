package hw6.steps;

import cucumber.api.java.en.Given;
import hw6.hooks.TestContext;


public class GivenSteps extends BaseSteps {
    //1. Open test site by URL
    @Given("^I open page by URL$")
    public void openPage() {
        TestContext.getDriver().get("https://epam.github.io/JDI/");
    }

    //3. Perform login
    @Given("^I login as '([^\\\"]*)'/'([^\\\"]*)'$")
    public void iLoginAs(String logName, String password) {
        homePage.userIconClick();
        homePage.fillLoginTextField(logName);
        homePage.fillPasswordTextField(password);
        homePage.loginButtonClick();
    }
}
