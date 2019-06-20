package hw2.ex1;

import org.testng.annotations.Test;

@Test
public class Ex1 {
    @Test
    public void main() {
        Ex1Methods methods = new Ex1Methods();
        methods.setUpDriverPath();

        //1. Open test site by URL
        methods.openPage("https://epam.github.io/JDI");

        //2. Assert browser title
        methods.seleniumOpenPageTest("Home Page");

        //3. Perform login
        methods.loginTest("epam", "1234");

        //4.Assert User name in left-top side of screen that user is logged
        methods.usernameAssertionTest("PITER CHAILOVSKII");

        //5. Assert browser title
        methods.seleniumOpenPageTest("Home Page");

        //6. Assert that there are 4 items on the header section are displayed and they have proper texts
        methods.headerSectionElementsTest("//a[contains(text(),'Home')]", "HOME");
        methods.headerSectionElementsTest("//a[contains(text(),'Contact form')]", "CONTACT FORM");
        methods.headerSectionElementsTest("//a[contains(text(),'Service')]", "SERVICE");
        methods.headerSectionElementsTest("//a[contains(text(),'Metals & Colors')]", "METALS & COLORS");

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

        methods.amountUnderIconsTextAssertion(path);
        methods.underIconsTextAssertion(0, path, microscopeText);
        methods.underIconsTextAssertion(1, path, headphoneText);
        methods.underIconsTextAssertion(2, path, computerText);
        methods.underIconsTextAssertion(3, path, rocketText);

        //9.Assert a text of the main headers
        String jdiText = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT " +
                "LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI " +
                "UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE " +
                "CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";
        methods.mainHeaderTextAssertion("main-title", "EPAM FRAMEWORK WISHES…");
        methods.mainHeaderTextAssertion("jdi-text", jdiText);

        //10. Assert that there is the iframe in the center of page
        methods.iframeAssertion();

        //11.Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        methods.epamLogoFrame();

        //12.Switch to original window back
        methods.switchToMainFrame();

        //13.Assert a text of the sub header
        String jdiPath = "//a[@href='https://github.com/epam/JDI']";
        methods.subHeaderTextAssertion(jdiPath, "JDI GITHUB");

        //14.Assert that JDI GITHUB is a link and has a proper URL
        methods.jdiUrlAssertion(jdiPath, "https://github.com/epam/JDI");

        //15.Assert that there is Left Section
        methods.leftSectionAssert();

        //16.Assert that there is Footer
        methods.footerAssert();


        //17. Close browser
        methods.tearDown();
    }

}