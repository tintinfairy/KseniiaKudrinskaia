package hw6.steps;

import cucumber.api.java.en.When;
import hw6.enums.UserNumberOfDropdown;
import hw6.enums.UserPathToVipCheckboxes;
import hw6.hooks.TestContext;
import org.openqa.selenium.By;


public class ActionSteps extends BaseSteps {

    //6. Click on "Service" subcategory in the header and check that drop down contains options
    @When("^I click on \"Service\" subcategory in the header$")
    public void iClickOnServiceHeader() {
        homePage.clickServiceHeader();
    }

    //7.Click on Service subcategory in the left section and check that drop down contains options
    @When("^I click on \"Service\" subcategory in the left section$")
    public void iClickOnServiceHeaderOnTheLeft() {
        homePage.clickLeftSideServiceHeader();
    }

    //8.Open through the header menu Service -> Different Elements Page
    @When("^I click on '([^\"]*)'$")
    public void iClickOnSection(String section) {
        homePage.clickAppropriateElementOfDropdown(section);
    }

    //12.Select checkboxes
    @When("^I select checkboxes '([^\\\"]*)'/'([^\\\"]*)'$")
    public void iSelectCheckboxes(String nameOfElement1, String nameOfElement2) {
        differentElementsPage.selectRadioOrCheckbox(nameOfElement1);
        differentElementsPage.selectRadioOrCheckbox(nameOfElement2);
    }

    //14.Select radio
    @When("^I select radio '([^\\\"]*)'$")
    public void iSelectRadio(String nameOfElement) {
        differentElementsPage.selectRadioOrCheckbox(nameOfElement);
    }

    //16.Select in dropdown
    @When("^I select '([^\\\"]*)' in dropdown$")
    public void iSelectOptionFromDropdown(String nameOfElement) {
        differentElementsPage.selectDropdownElement(nameOfElement);
    }

    //18.Unselect and assert checkboxes
    @When("^I unselect checkboxes '([^\\\"]*)'/'([^\\\"]*)'$")
    public void iUnselectCheckboxes(String nameOfElement1, String nameOfElement2) {
        differentElementsPage.selectRadioOrCheckbox(nameOfElement1);
        differentElementsPage.selectRadioOrCheckbox(nameOfElement2);
    }

    @When("^I select vip checkbox for '([^\\\"]*)'$")
    public void iSelectVipCheckbox(UserPathToVipCheckboxes user) {
        TestContext.getDriver().findElement(By.xpath(user.getPathToVipCheckbox())).click();
    }

    @When("^I click on dropdown in column Type for user '([^\\\"]*)'$")
    public void iSelectDropdownColumn(UserNumberOfDropdown user) {
        userTablePage.getDropdowns().get(user.getNumberOfDropdown()).click();
    }
}
