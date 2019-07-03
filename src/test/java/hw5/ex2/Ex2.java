package hw5.ex2;

import hw5.AllureAttachmentListener;
import hw5.base.BaseTest;
import hw5.ex2.enums.ExpectedAmountOfItemsOfDifferentElementsPage;
import hw5.steps.DifferentElementsPageSteps;
import hw5.steps.HomePageSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

@Test
@Listeners(AllureAttachmentListener.class)
public class Ex2 extends BaseTest {
    @Story(value = "Testing page https://epam.github.io/JDI/index.html")
    @Feature(value = "Ex2 test")
    @Test
    public void ex2() {
        HomePageSteps homepageSteps = new HomePageSteps();
        DifferentElementsPageSteps differentElementsPageSteps = new DifferentElementsPageSteps();

        //5.Click on "Service" subcategory in the header and check that drop down contains options
        List<String> elementsOfHeaderDropdown = Arrays.asList("SUPPORT", "DATES", "COMPLEX TABLE", "SIMPLE TABLE", "TABLE WITH PAGES", "DIFFERENT ELEMENTS");
        homepageSteps.serviceHeadersAssertion(elementsOfHeaderDropdown);

        //6. Click on Service subcategory in the left section and check that drop down contains options
        homepageSteps.serviceLeftSectionHeadersAssertion(elementsOfHeaderDropdown);

        //7.Open through the header menu Service -> Different Elements Page
        homepageSteps.openServicePages("Different elements");

        //8.Check interface on Different elements page, it contains all needed elements
        openPage("https://epam.github.io/JDI/different-elements.html");
        differentElementsPageSteps.amountOfCheckboxeAssertion(ExpectedAmountOfItemsOfDifferentElementsPage.CHECKBOX
                .getAmount());
        differentElementsPageSteps.amountOfRadiosAssertion(ExpectedAmountOfItemsOfDifferentElementsPage.RADIO.getAmount());
        differentElementsPageSteps.amountOfDropdownsAssertion(ExpectedAmountOfItemsOfDifferentElementsPage.DROPDOWN.getAmount());
        differentElementsPageSteps.amountOfButtonsAssertion(ExpectedAmountOfItemsOfDifferentElementsPage.BUTTON.getAmount());

        //9.Assert that there is Right Section
        differentElementsPageSteps.assertRightSection();

        //10.Assert that there is Left Section
        differentElementsPageSteps.assertLeftSection();

        //11.Select checkboxes
        differentElementsPageSteps.selectRadioOrCheckbox("Water");
        differentElementsPageSteps.selectRadioOrCheckbox("Wind");
        differentElementsPageSteps.checkboxOrRadioIsSelected("Water");
        differentElementsPageSteps.checkboxOrRadioIsSelected("Wind");

        //12.Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        differentElementsPageSteps.logRowInformationAssertion("Water", "true");
        differentElementsPageSteps.logRowInformationAssertion("Wind", "true");

        //13.Select radio
        differentElementsPageSteps.selectRadioOrCheckbox("Selen");
        differentElementsPageSteps.checkboxOrRadioIsSelected("Selen");

        //14.Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton.
        differentElementsPageSteps.logRowInformationAssertion("Selen", "");

        //15.Select in dropdown
        differentElementsPageSteps.dropdownElementSelection("Yellow");

        //16.Assert that for dropdown there is a log row and value is corresponded to the selected value.
        differentElementsPageSteps.logRowInformationAssertion("Yellow", "");

        //17.Unselect and assert checkboxes
        differentElementsPageSteps.selectRadioOrCheckbox("Water");
        differentElementsPageSteps.selectRadioOrCheckbox("Wind");
        differentElementsPageSteps.checkboxOrRadioIsUnselected("Water");
        differentElementsPageSteps.checkboxOrRadioIsUnselected("Wind");

        //18.Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        differentElementsPageSteps.logRowInformationAssertion("Water", "false");
        differentElementsPageSteps.logRowInformationAssertion("Wind", "false");


    }
}