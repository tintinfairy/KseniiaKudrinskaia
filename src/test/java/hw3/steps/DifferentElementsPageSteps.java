package hw3.steps;

import hw3.base.BaseTest;
import hw3.voids.DifferentElementsPage;

import static org.testng.Assert.*;

public class DifferentElementsPageSteps extends BaseTest {
    DifferentElementsPage differentElementsPage = new DifferentElementsPage(driver);


    //8.Check interface on Different elements page, it contains all needed elements
    public void amountOfCheckboxeAssertion(int expectedAmount) {
        assertEquals(differentElementsPage.getAmountOfCheckboxes(), expectedAmount);
    }

    public void amountOfRadiosAssertion(int expectedAmount) {
        assertEquals(differentElementsPage.getAmountOfRadios(), expectedAmount);
    }

    public void amountOfDropdownsAssertion(int expectedAmount) {
        assertEquals(differentElementsPage.getAmountOfDropdowns(), expectedAmount);
    }

    public void amountOfButtonsAssertion(int expectedAmount) {
        assertEquals(differentElementsPage.getAmountOfButtons(), expectedAmount);
    }

    //9.Assert that there is Right Section
    public void assertRightSection() {
        differentElementsPage.rightSectionIsDisplayed();
    }

    //10.Assert that there is Left Section
    public void assertLeftSection() {
        differentElementsPage.leftSectionIsDisplayed();
    }

    //11.Select checkboxes
    // 13.Select radio
    public void selectRadioOrCheckbox(String nameOfElement) {
        differentElementsPage.selectRadioOrCheckbox(nameOfElement);
    }

    public void checkboxOrRadioIsSelected(String nameOfElement) {
        assertTrue(differentElementsPage.checkboxOrRadioIsSelected(nameOfElement));

    }

    //12.Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
    //14.Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton.
    //16.Assert that for dropdown there is a log row and value is corresponded to the selected value.
    //18.Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
    public void logRowInformationAssertion(String element, String selected) {
        boolean flag = false;
        for (int i = 0; i < differentElementsPage.getLogsSize(); i++) {
            if (differentElementsPage.getLogsText(i).contains(element) && differentElementsPage.getLogsText(i).contains(selected)) {
                flag = true;
            }
        }
        assertTrue(flag);
    }


    //15.Select in dropdown
    public void dropdownElementSelection(String element) {
        differentElementsPage.selectDropdownElement(element);
    }

    //17.Unselect and assert checkboxes
    public void checkboxOrRadioIsUnselected(String nameOfElement) {
        assertFalse(differentElementsPage.checkboxOrRadioIsSelected(nameOfElement));
    }
}
