package hw5.steps;

import hw5.HomePage;
import hw5.base.BaseTest;
import io.qameta.allure.Step;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.isIn;
import static org.testng.Assert.assertEquals;

public class HomePageSteps extends BaseTest {

    @Step("Assertion of amount of the header sections")
    //6. Assert that there are 4 items on the header section are displayed and they have proper texts
    public void amountOfHeadersAssertion() {
        assertEquals(homePage.getNumberOfHeaders(), 4);
    }

    @Step("Assertion that header section are displayed and they have proper texts")
    public void headerSectionElementsAssertion(List<String> headers) {
        for (int i = 0; i < headers.size(); i++) {
            assertEquals(homePage.getHeaderName(i), headers.get(i));
        }
    }

    @Step("Assertion that there are 4 images on the Index Page and they are displayed")
    //7.Assert that there are 4 images on the Index Page and they are displayed
    public void imageIndexPageAssertion() {
        assertEquals(homePage.getAmountOfImages(), 4);
    }

    @Step("Assertion of amount of under icon text fields")
    //8.Assert that there are 4 texts on the Index Page under icons and they have proper text
    public void amountOfUnderImagesTextFieldsAssertion() {
        assertEquals(homePage.getAmountOfTextFieldsUnderImages(), 4);
    }

    @Step("Assertion of under icon text")
    public void underIconsTextAssertion(List<String> text) {
        for (int i = 0; i < text.size(); i++) {
            assertEquals(homePage.getTextUnderImages(i), text.get(i));
        }
    }

    @Step("Assert a text of the main header")
    //9.Assert a text of the main headers
    public void mainHeaderTextAssertion(String expectedText) {
        assertEquals(homePage.getMainTitle(), expectedText);
    }

    @Step("Assert a text of the jdi header")
    public void jdiTextAssertion(String expectedText) {
        assertEquals(homePage.getJdiText(), expectedText);
    }


    @Step("Assert that there is the iframe in the center of page")
    //10. Assert that there is the iframe in the center of page
    public void iframeAssertion() {
        assertEquals(homePage.containingIFrame(), true);
    }

    @Step("Switch to the iframe and check that there is Epam logo in the left top conner of iframe")
    //11.Switch to the iframe and check that there is Epam logo in the left top conner of iframe
    public void epamLogoFrameSwitch() {
        homePage.epamLogoCheck();
    }

    @Step("witch to original window back")
    //12.Switch to original window back
    public void switchToMainFrame() {
        homePage.switchToMainFrame();
    }

    @Step("Assert a text of the sub header")
    //13.Assert a text of the sub header
    public void subHeaderTextAssert(String text) {
        assertEquals(homePage.getSubHesderText(), text);
    }

    @Step("Assert that JDI GITHUB is a link and has URL {0}")
    //14.Assert that JDI GITHUB is a link and has a proper URL
    public void jdiUrlAssert(String link) {
        assertEquals(homePage.getSubHeaderLink(), link);
    }

    @Step("Assert that there is Left Section")
    //15.Assert that there is Left Section
    public void leftSectionAssert() {
        homePage.navigationSidebarIsDisplayed();
    }

    @Step("Assert that there is Footer")
    //16.Assert that there is Footer
    public void footerAssert() {
        homePage.footerIsDisplayed();
    }

    @Step("Click on \"Service\" subcategory in the header and check that drop down contains options")
    //5.Click on "Service" subcategory in the header and check that drop down contains options
    public void serviceHeadersAssertion(List<String> elementsOfDropdown) {
        homePage.clickServiceHeader();
        assertThat(elementsOfDropdown, hasItems(isIn(homePage.getStringElementsOfServiceHeader(homePage.getServiceDropdownElements()))));
    }

    @Step("Click on Service subcategory in the left section and check that drop down contains options")
    //6.Click on Service subcategory in the left section and check that drop down contains options
    public void serviceLeftSectionHeadersAssertion(List<String> elementsOfDropdown) {
        homePage.clickLeftSideServiceHeader();
        assertThat(elementsOfDropdown, hasItems(isIn(homePage.getStringElementsOfServiceHeader(homePage.getServiceLeftDropdownElements()))));
    }

    @Step("Open through the header menu Service -> Different Elements Page")
    //7.Open through the header menu Service -> Different Elements Page
    public void openServicePages(String element) {
        homePage.clickServiceHeader();
        homePage.clickAppropriateElementOfDropdown(element);
    }


}