package hw3.ex2;

import hw3.base.BaseTest;
import hw3.ex2.enums.ExpectedAmountOfItemsOfDifferentElementsPage;
import hw3.ex2.steps.Ex2DifferentElementsPageSteps;
import hw3.ex2.steps.Ex2HomepageSteps;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

@Test
public class Ex2 extends BaseTest {
    @Test
    public void main() {
        Ex2HomepageSteps ex2HomepageSteps = new Ex2HomepageSteps();
        Ex2DifferentElementsPageSteps ex2DifferentElementsPageSteps = new Ex2DifferentElementsPageSteps();

        //5.Click on "Service" subcategory in the header and check that drop down contains options
        List<String> elementsOfHeaderDropdown = Arrays.asList("SUPPORT", "DATES", "COMPLEX TABLE", "SIMPLE TABLE", "TABLE WITH PAGES", "DIFFERENT ELEMENTS");
        ex2HomepageSteps.amountOfServiceHeadersAssertion(elementsOfHeaderDropdown);

        //6. Click on Service subcategory in the left section and check that drop down contains options
        List<String> elementsOfSubDropdown = Arrays.asList("Support", "Dates", "Complex Table", "Simple Table", "Table with pages", "Different elements");
        ex2HomepageSteps.amountOfServiceLeftSectionHeadersAssertion(elementsOfSubDropdown);

        //7.Open through the header menu Service -> Different Elements Page
        ex2HomepageSteps.openServicePages("DIFFERENT ELEMENTS");

        //8.Check interface on Different elements page, it contains all needed elements
        openPage("https://epam.github.io/JDI/different-elements.html");
        ex2DifferentElementsPageSteps.amountOfCheckboxeAssertion(ExpectedAmountOfItemsOfDifferentElementsPage.CHECKBOX
                .getAmount());
        ex2DifferentElementsPageSteps.amountOfRadiosAssertion(ExpectedAmountOfItemsOfDifferentElementsPage.RADIO.getAmount());
        ex2DifferentElementsPageSteps.amountOfDropdownsAssertion(ExpectedAmountOfItemsOfDifferentElementsPage.DROPDOWN.getAmount());
        ex2DifferentElementsPageSteps.amountOfButtonsAssertion(ExpectedAmountOfItemsOfDifferentElementsPage.BUTTON.getAmount());

        //9.Assert that there is Right Section
        ex2DifferentElementsPageSteps.assertRightSection();

        //10.Assert that there is Left Section
        ex2DifferentElementsPageSteps.assertLeftSection();

        //11.Select checkboxes
        ex2DifferentElementsPageSteps.selectWindAndWaterCheckboxes();
        ex2DifferentElementsPageSteps.checkboxesAreSelected();

        //12.Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        ex2DifferentElementsPageSteps.logRowInformationAssertion("Water", "true");
        ex2DifferentElementsPageSteps.logRowInformationAssertion("Wind", "true");

        //13.Select radio
        ex2DifferentElementsPageSteps.selectSelenRadio();

        //14.Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton.
        ex2DifferentElementsPageSteps.logRowInformationAssertion("Selen", "");

        //15.Select in dropdown
        ex2DifferentElementsPageSteps.dropdownElementSelection("Yellow");

        //16.Assert that for dropdown there is a log row and value is corresponded to the selected value.
        ex2DifferentElementsPageSteps.logRowInformationAssertion("Yellow", "");

        //17.Unselect and assert checkboxes
        ex2DifferentElementsPageSteps.selectWindAndWaterCheckboxes();
        ex2DifferentElementsPageSteps.checkboxesAreUnselected();

        //18.Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        ex2DifferentElementsPageSteps.logRowInformationAssertion("Water", "false");
        ex2DifferentElementsPageSteps.logRowInformationAssertion("Wind", "false");


    }
}
