package hw3.ex1;

import hw3.base.BaseTest;
import hw3.ex1.steps.Ex1HomePageSteps;
import org.testng.annotations.Test;


@Test
public class Ex1 extends BaseTest {

    @Test
    public void main() {

        Ex1HomePageSteps methods = new Ex1HomePageSteps();

        //5. Assert browser title
        pageTitleAssertion("Home Page");

        //6. Assert that there are 4 items on the header section are displayed and they have proper texts
        methods.headerItemsAreDisplayed();
        // TODO Why do ou do not use collection here?
        methods.headerSectionElementsAssertion("Home");
        methods.headerSectionElementsAssertion("Contact form");
        methods.headerSectionElementsAssertion("Service");
        methods.headerSectionElementsAssertion("Metals & Colors");

        //7.Assert that there are 4 images on the Index Page and they are displayed
        methods.imageIndexPageAssertion();

        //8.Assert that there are 4 texts on the Index Page under icons and they have proper text
        String path = "//span[contains(@class,'benefit-txt')]";
        String microscopeText = "To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project";
        String headphoneText = "To be flexible and\n" +
                "customizable";
        String computerText = "To be multiplatform";
        String rocketText = "Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…";

        methods.amountOfUnderImagesTextFieldsAssertion(path);
        // TODO Why do you not use collection here?
        // TODO it looks like hard-code using indexes here
        methods.underIconsTextAssertion(0, microscopeText);
        methods.underIconsTextAssertion(1, headphoneText);
        methods.underIconsTextAssertion(2, computerText);
        methods.underIconsTextAssertion(3, rocketText);

        //9.Assert a text of the main headers
        String jdiText = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT " +
                "LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI " +
                "UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE " +
                "CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";
        methods.mainHeaderTextAssertion("EPAM FRAMEWORK WISHES…");
        methods.jdiTextAssertion(jdiText);

        //10. Assert that there is the iframe in the center of page
        methods.iframeAssertion();

        //11.Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        methods.epamLogoFrameSwitch();

        //12.Switch to original window back
        methods.switchToMainFrame();

        //13.Assert a text of the sub header
        methods.subHeaderTextAssert("JDI GITHUB");

        //14.Assert that JDI GITHUB is a link and has a proper URL
        methods.jdiUrlAssert("https://github.com/epam/JDI");

        //15.Assert that there is Left Section
        methods.leftSectionAssert();

        //16.Assert that there is Footer
        methods.footerAssert();


    }

}