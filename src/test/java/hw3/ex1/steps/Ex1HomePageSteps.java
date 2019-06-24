package hw3.ex1.steps;

import hw3.base.BaseTest;
import hw3.voids.HomePage;

import static org.testng.Assert.assertEquals;

public class Ex1HomePageSteps extends BaseTest {

    HomePage homePage = new HomePage(driver);

    //6. Assert that there are 4 items on the header section are displayed and they have proper texts
    public void headerItemsAreDisplayed() {
        homePage.headerItemsAreDisplayed();
    }

    public void headerSectionElementsAssertion(String expectedHeader) {
        assertEquals(homePage.getHeaderName(expectedHeader), expectedHeader);

    }

    //7.Assert that there are 4 images on the Index Page and they are displayed
    public void imageIndexPageAssertion() {
        homePage.imagesAreDisplayed();
        assertEquals(homePage.getAmountOfImages(), 4);
    }

    //8.Assert that there are 4 texts on the Index Page under icons and they have proper text
    public void amountOfUnderImagesTextFieldsAssertion(String path) {
        assertEquals(homePage.getAmountOfTextFieldsUnderImages(), 4);
    }

    public void underIconsTextAssertion(int id, String text) {
        assertEquals(homePage.getTextUnderImages(id), text);
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


}
