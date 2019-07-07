package hw6.steps;

import cucumber.api.java.en.Then;
import hw6.enums.UserNumberOfDropdown;
import hw6.hooks.TestContext;
import hw6.steps.util.MethodsForAsserts;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AssertionSteps extends BaseSteps {
    MethodsForAsserts methodsForAsserts = new MethodsForAsserts();

    //2.Assert Browser title
    @Then("^'([^\"]*)' page is opened$")
    public void pageTitleAssertion(String pageTitle) {
        assertThat(TestContext.getDriver().getTitle(), equalTo(pageTitle));
    }

    //4.Assert User name in the right-top side of screen that user is loggined
    @Then("^User name should be '(.+)'$")
    public void usernameAssertion(String userName) {
        assertEquals(homePage.getUserName().getText(), userName);
    }

    //5.Check interface on Home page, it contains all needed elements.
    @Then("^There are should be '([\\d*])' pictures on Home Page$")
    public void imageIndexPageAssertion(int expectedAmount) {
        assertEquals(homePage.getAmountOfImages(), expectedAmount);
    }

    @Then("^There are should be '([\\d*])' texts under pictures on Home Page$")
    public void amountOfUnderImagesTextFieldsAssertion(int expectedAmount) {
        assertEquals(homePage.getAmountOfTextFieldsUnderImages(), expectedAmount);
    }

    @Then("^There are should be '([\\d*])' texts above pictures on Home Page$")
    public void amountOfAboveImagesTextFieldsAssertion(int expectedAmount) {
        assertEquals(homePage.getAmountOfTextsAbovePictures(), expectedAmount);
    }

    //6.Click on "Service" subcategory in the header and check that drop down contains options
    @Then("^Dropdown list should be displayed$")
    public void dropdownListShouldBeDisplayed() {
        assertTrue(homePage.getServiceDropdown().isDisplayed());
    }

    @Then("^Dropdown list should have items$")
    public void dropdownListShouldHaveItems(List<String> items) {
        methodsForAsserts.dropdownItemsAssertion(items, "//ul[@class='dropdown-menu']//a");
    }

    //7.Click on Service subcategory in the left section and check that drop down contains options
    @Then("^Dropdown list on the left should be displayed$")
    public void dropdownListOnTheLeftShouldBeDisplayed() {
        assertTrue(homePage.getServiceLeftDropdown().isDisplayed());

    }

    @Then("^Dropdown list on the left should have items$")
    public void dropdownListOnTheLeftShouldHaveItems(List<String> items) {
        methodsForAsserts.dropdownItemsAssertion(items, "//ul[contains(@class,'sub')]/li/a");

    }

    //9.Check interface on Different elements page, it contains all needed elements
    @Then("^Different elements page contains elements '([\\d*])' checkboxes, '([\\d*])' radio boxes$")
    public void amountOfCheckboxesAssertion(int numberOfCheckboxes, int numberOfRadios) {
        assertEquals(differentElementsPage.getAmountOfCheckboxes(), numberOfCheckboxes);
        assertEquals(differentElementsPage.getAmountOfRadios(), numberOfRadios);
    }

    @Then("^Different elements page contains elements '([\\d*])' dropdowns, '([\\d*])' buttons$")
    public void amountOfDropdownsAndButtonsAssertion(int numberOfDropdowns, int numberOfButtons) {
        assertEquals(differentElementsPage.getAmountOfDropdowns(), numberOfDropdowns);
        assertEquals(differentElementsPage.getAmountOfButtons(), numberOfButtons);
    }

    //10.Assert that there is Right Section
    @Then("^There is Right Section on Different Elements Page$")
    public void assertRightSection() {
        differentElementsPage.rightSectionIsDisplayed();
    }

    //11.Assert that there is Left Section
    @Then("^There is Left Section on Different Elements Page$")
    public void assertLeftSection() {
        differentElementsPage.leftSectionIsDisplayed();
    }

    //13.Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
    @Then("^Appropriate log row for this checkboxes should appear$")
    public void logRowForCheckboxesAssertion() {
        methodsForAsserts.logRowInformationAssertion("Water", "true");
        methodsForAsserts.logRowInformationAssertion("Wind", "true");

    }

    //15.Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton.
    @Then("^Appropriate log row for this radio should appear$")
    public void logRowForRadioAssertion() {
        methodsForAsserts.logRowInformationAssertion("Selen", "");

    }

    //17.Assert that for dropdown there is a log row and value is corresponded to the selected value.
    @Then("^Appropriate log row for this dropdown should appear$")
    public void logRowForDropdownAssertion() {
        methodsForAsserts.logRowInformationAssertion("Yellow", "");

    }

    //19.Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
    @Then("^Appropriate log row for this unselected checkboxes should appear$")
    public void logRowForUnselectedCheckboxesAssertion() {
        methodsForAsserts.logRowInformationAssertion("Selen", "");

    }

    //EX2
    @Then("^'([\\d*])' NumberType Dropdowns are displayed on Users Table on User Table Page$")
    public void numberTypeOfDropdownsAssertion(int expectedAmount) {
        assertThat(userTablePage.getDropdowns().size(), equalTo(expectedAmount));
    }

    @Then("^'([\\d*])' User names are displayed on Users Table on User Table Page$")
    public void numberTypeOfUserNamesAssertion(int expectedAmount) {
        assertThat(userTablePage.getUserNames().size(), equalTo(expectedAmount));
    }

    @Then("^'([\\d*])' Description images are displayed on Users Table on User Table Page$")
    public void numberTypeOfDescriptionImagesAssertion(int expectedAmount) {
        assertThat(userTablePage.getImages().size(), equalTo(expectedAmount));
    }

    @Then("^'([\\d*])' Description texts under images are displayed on Users Table on User Table Page$")
    public void numberTypeOfDescriptionTextsAssertion(int expectedAmount) {
        assertThat(userTablePage.getDescriptionTexts().size(), equalTo(expectedAmount));
    }

    @Then("^'([\\d*])' checkboxes are displayed on Users Table on User Table Page$")
    public void numberTypeOfCheckboxesAssertion(int expectedAmount) {
        assertThat(userTablePage.getCheckboxes().size(), equalTo(expectedAmount));
    }

    @Then("^User table contains following values:$")
    public void userTableAssertion(List<Map<String, String>> items) {
        List<String> userNames = methodsForAsserts.listOfWebElementsToStringList("//td//a");
        List<String> heroesNames = methodsForAsserts.listOfWebElementsToStringList("//td//span");
        assertThat(methodsForAsserts.listsToListOfMaps(userNames, heroesNames).toString().replace("\n", " ")
                , equalTo(items.toString()));
    }

    @Then("^log row has '([^\"]*)': condition changed to '([^\"]*)' text in log section$")
    public void logRowForVipAssertion(String element, String selected) {
        methodsForAsserts.logRowInformationAssertion(element, selected);
    }

    @Then("^droplist for '([^\"]*)' contains values$")
    public void dropListElementsAssertion(UserNumberOfDropdown user, List<String> expectedElements) {
        assertThat(methodsForAsserts.getElementsOfDropDown(userTablePage.getDropdowns().get(user.getNumberOfDropdown()))
                , equalTo(expectedElements));
    }


}
