package hw2.ex1;

import hw2.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class Ex1Methods extends BaseTest {

    //6. Assert that there are 4 items on the header section are displayed and they have proper texts
    public void headerSectionElementsAssertion(String path, String expectedHeader) {
        // TODO What is the purpose of the using headerSectionElement.isDisplayed()?[FIXED]
        assertEquals(getElementByPath(path).getText(), expectedHeader);
    }

    //7.Assert that there are 4 images on the Index Page and they are displayed
    public void imageIndexPageAssertion() {
            // TODO What is the purpose of the using imageFromList.isDisplayed()?[FIXED]
        assertEquals(driver.findElements(By.className("benefit-icon")).size(), 4);
    }

    //8.Assert that there are 4 texts on the Index Page under icons and they have proper text
    public void amountUnderIconsTextAssertion(String path) {
        List<WebElement> allUnderIconsText = driver.findElements(By.xpath(path));
        assertEquals(allUnderIconsText.size(), 4);
    }

    public String getUnderIconText(int i, String path) {
        return driver.findElements(By.xpath(path)).get(i).getText();
    }

    public void underIconsTextAssertion(int id, String path, String text) {
        assertEquals(getUnderIconText(id, path), text);
    }

    //9.Assert a text of the main headers
    public void mainHeaderTextAssertion(String name, String expectedText) {
        driver.findElements(By.name(name));
        assertEquals(driver.findElement(By.name(name)).getText(), expectedText);
    }


    //10. Assert that there is the iframe in the center of page
    public void iframeAssertion() {
        assertEquals(driver.getPageSource().contains("iframe"), true);
    }

    //11.Switch to the iframe and check that there is Epam logo in the left top conner of iframe
    public void epamLogoFrameSwitch() {
        driver.switchTo().frame(0);
        getElementById("user-icon").isDisplayed();
        driver.switchTo().defaultContent();

    }

    //12.Switch to original window back
    public void switchToMainFrame() {
        driver.switchTo().defaultContent();
    }

    //13.Assert a text of the sub header
    public void subHeaderTextAssert(String path, String text) {
        assertEquals(getElementByPath(path).getText(), text);
    }

    //14.Assert that JDI GITHUB is a link and has a proper URL
    public void jdiUrlAssert(String path, String text) {
        assertEquals(getElementByPath(path).getAttribute("href"), text);
    }

    //15.Assert that there is Left Section
    public void leftSectionAssert() {
        driver.findElement(By.name("navigation-sidebar")).isDisplayed();
    }

    //16.Assert that there is Footer
    public void footerAssert() {
        driver.findElement(By.tagName("footer")).isDisplayed();
    }


}
