package hw2.ex2;

import hw2.base.BaseTest;
import hw2.ex2.enums.CheckboxesAndRadios;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.testng.Assert.*;

public class Ex2Methods extends BaseTest {

    //5.Click on "Service" subcategory in the header and check that drop down contains options
    //6.Click on Service subcategory in the left section and check that drop down contains options
    public void amountOfServiceHeadersAssertion(String dropdownXpath, String elementsXpath, List<String> elementsOfDropdown) {
        int count = 0;
        getElementByPath(dropdownXpath).click();
        List<WebElement> serviceHeaders = driver.findElements(By.xpath(elementsXpath));
        for (int i = 0; i < elementsOfDropdown.size(); i++) {
            for (WebElement element : serviceHeaders) {
                if (element.getText().equals(elementsOfDropdown.get(i))) {
                    count++;
                }
            }
        }
        assertEquals(count, 6);
    }

    //7.Open through the header menu Service -> Different Elements Page
    public void openServicePages(String dropdownXpath, String elementsXpath) {
        getElementByPath(dropdownXpath).click();
        List<WebElement> elements = driver.findElements(By.xpath(elementsXpath));
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getText().equals("Different elements")) {
                elements.get(i).click();
            }
        }

    }

    //8.Check interface on Different elements page, it contains all needed elements
    // TODO It will be better use By as first parameter instead of String path & String typeOfLocator
    // TODO Method will be more flexible
    public void amountOfElementsAssertion(String path, int expectedAmount, String typeOfLocator) {
        openPage("https://epam.github.io/JDI/different-elements.html");
        List<WebElement> elements;
        if (typeOfLocator.equals("xpath")) {
            elements = driver.findElements(By.xpath(path));
        } else {
            elements = driver.findElements(By.className(path));
        }
        // TODO Is this variable required here?
        int amount = elements.size();
        assertEquals(amount, expectedAmount);
    }


    //9.Assert that there is Right Section
    //10.Assert that there is Right Section
    public void assertSections(String id) {
        getElementById(id).isDisplayed();
    }

    //11.Select checkboxes
    // 13.Select radio
    //17.Unselect and assert checkboxes
    public void checkboxAndRadioSelection(String name, boolean checked) {
        String path="";
        for (CheckboxesAndRadios item : CheckboxesAndRadios.values()) {
            if (item.name().equals(name)) {
                path=item.getPath();
            }
        }
        WebElement element = getElementByPath(path);
        element.click();
        if (checked) {
            assertTrue(element.isSelected());
        } else {
            assertFalse(element.isSelected());
        }
    }


    //12.Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
    //18.Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
    public void logRowAssertionCheckboxes(String path, String nameOfElement, String elementXpath, boolean checked) {
        boolean flag = false;
        List<WebElement> elements = driver.findElements(By.xpath(path));
        if (checked) {
            for (int i = 0; i < elements.size(); i++) {

                if (elements.get(i).getText().contains(nameOfElement) && getElementByPath(elementXpath).isSelected() && elements.get(i).getText().contains("true")) {
                    flag = true;
                }
            }
        } else {
            for (int i = 0; i < elements.size(); i++) {
                if (elements.get(i).getText().contains(nameOfElement) && elements.get(i).getText().contains("false")) {
                    flag = true;
                }
            }
        }

        assertTrue(flag);

    }


    //14.Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton.
    public void logRowAssertionRadios(String path, String nameOfElement, String elementXpath) {
        boolean flag = false;
        List<WebElement> elements = driver.findElements(By.xpath(path));
        for (int i = 0; i < elements.size(); i++) {

            if (elements.get(i).getText().contains(nameOfElement) && getElementByPath(elementXpath).isSelected()) {
                flag = true;
            }
        }
        assertTrue(flag);

    }

    //15.Select in dropdown
    public void dropdownElementSelection() {
        Select dropdown = new Select(getElementByPath("//select"));
        dropdown.selectByVisibleText("Yellow");
    }

    //16.Assert that for dropdown there is a log row and value is corresponded to the selected value.
    public void logRowAssertionDropdowns(String path, String nameOfElement) {
        boolean flag = false;
        List<WebElement> elements = driver.findElements(By.xpath(path));
        for (int i = 0; i < elements.size(); i++) {

            if (elements.get(i).getText().contains(nameOfElement)) {
                flag = true;
            }

        }
        assertTrue(flag);

    }

}
