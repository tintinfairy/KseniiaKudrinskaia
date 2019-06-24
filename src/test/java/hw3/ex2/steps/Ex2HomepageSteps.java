package hw3.ex2.steps;

import hw3.base.BaseTest;
import hw3.voids.HomePage;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class Ex2HomepageSteps extends BaseTest {

    HomePage homePage = new HomePage(driver);

    //5.Click on "Service" subcategory in the header and check that drop down contains options
    public void amountOfServiceHeadersAssertion(List<String> elementsOfDropdown) {
        homePage.clickServiceHeader();
        assertEquals(homePage.getAmountOfContainingElements(homePage.getServiceDropdownElements(), elementsOfDropdown), 6);
    }

    //6.Click on Service subcategory in the left section and check that drop down contains options
    public void amountOfServiceLeftSectionHeadersAssertion(List<String> elementsOfDropdown) {
        homePage.clickLeftSideServiceHeader();
        assertEquals(homePage.getAmountOfContainingElements(homePage.getServiceLeftDropdownElements(), elementsOfDropdown), 6);
    }

    //7.Open through the header menu Service -> Different Elements Page
    public void openServicePages(String element) {
        homePage.clickServiceHeader();
        homePage.clickAppropriateElementOfDropdown(element);
    }


}
