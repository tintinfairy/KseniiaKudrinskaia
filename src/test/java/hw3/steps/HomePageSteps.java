package hw3.steps;

import hw3.base.BaseTest;
import hw3.voids.HomePage;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.isIn;
import static org.testng.Assert.assertEquals;

public class HomePageSteps extends BaseTest {

    HomePage homePage = new HomePage(driver);

    //6. Assert that there are 4 items on the header section are displayed and they have proper texts
    public void amountOfHeadersAssertion() {
        assertEquals(homePage.getNumberOfHeaders(), 4);
    }

    public void headerSectionElementsAssertion(List<String> headers) {
        for (int i = 0; i < headers.size(); i++) {
            assertEquals(homePage.getHeaderName(i), headers.get(i));
        }
    }

    //7.Assert that there are 4 images on the Index Page and they are displayed
    public void imageIndexPageAssertion() {
        assertEquals(homePage.getAmountOfImages(), 4);
    }

    //8.Assert that there are 4 texts on the Index Page under icons and they have proper text
    public void amountOfUnderImagesTextFieldsAssertion() {
        assertEquals(homePage.getAmountOfTextFieldsUnderImages(), 4);
    }

    public void underIconsTextAssertion(List<String> text) {
        for (int i = 0; i < text.size(); i++) {
            assertEquals(homePage.getTextUnderImages(i), text.get(i));
        }
    }

    //9.Assert a text of the main headers
    public void mainHeaderTextAssertion(String expectedText) {
        assertEquals(homePage.getMainTitle(), expectedText);
    }

    public void jdiTextAssertion(String expectedText) {
        assertEquals(homePage.getJdiText(), expectedText);
    }


    //10. Assert that there is the iframe in the center of page
    public void iframeAssertion() {
        assertEquals(homePage.containingIFrame(), true);
    }

    //11.Switch to the iframe and check that there is Epam logo in the left top conner of iframe
    public void epamLogoFrameSwitch() {
        homePage.epamLogoCheck();
    }

    //12.Switch to original window back
    public void switchToMainFrame() {
        homePage.switchToMainFrame();
    }

    //13.Assert a text of the sub header
    public void subHeaderTextAssert(String text) {
        assertEquals(homePage.getSubHesderText(), text);
    }

    //14.Assert that JDI GITHUB is a link and has a proper URL
    public void jdiUrlAssert(String link) {
        assertEquals(homePage.getSubHeaderLink(), link);
    }

    //15.Assert that there is Left Section
    public void leftSectionAssert() {
        homePage.navigationSidebarIsDisplayed();
    }

    //16.Assert that there is Footer
    public void footerAssert() {
        homePage.footerIsDisplayed();
    }

    //5.Click on "Service" subcategory in the header and check that drop down contains options
    public void serviceHeadersAssertion(List<String> elementsOfDropdown) {
        homePage.clickServiceHeader();
        assertThat(elementsOfDropdown, hasItems(isIn(homePage.getStringElementsOfServiceHeader(homePage.getServiceDropdownElements()))));
    }

    //6.Click on Service subcategory in the left section and check that drop down contains options
    public void serviceLeftSectionHeadersAssertion(List<String> elementsOfDropdown) {
        homePage.clickLeftSideServiceHeader();
        assertThat(elementsOfDropdown, hasItems(isIn(homePage.getStringElementsOfServiceHeader(homePage.getServiceLeftDropdownElements()))));
    }

    //7.Open through the header menu Service -> Different Elements Page
    public void openServicePages(String element) {
        homePage.clickServiceHeader();
        homePage.clickAppropriateElementOfDropdown(element);
    }


}
