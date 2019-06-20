package hw2.ex2;

import hw2.base.BaseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.testng.Assert.*;

public class Ex2Methods extends BaseMethods {

    private List<WebElement> webElements;

    public void setElementsListByPath(String path) {
        webElements = driver.findElements(By.xpath(path));
    }

    public void setElementsListByClassName(String className) {
        webElements = driver.findElements(By.className(className));
    }

    public void deleteElementsList() {
        webElements = null;
    }

    //5.Click on "Service" subcategory in the header and check that drop down contains options
    //6.Click on Service subcategory in the left section and check that drop down contains options
    public void headerServiceTest(String dropdownXpath, String elementsXpath, List<String> elementsOfDropdown) {
        int count = 0;
        getElementByPath(dropdownXpath).click();
        setElementsListByPath(elementsXpath);
        for (int i = 0; i < elementsOfDropdown.size(); i++) {
            for (WebElement element : webElements) {
                if (element.getText().equals(elementsOfDropdown.get(i))) {
                    count++;
                }
            }
        }
        deleteElementsList();
        assertEquals(count, 6);
    }

    //7.Open through the header menu Service -> Different Elements Page
    public void openServicePages(String dropdownXpath, String elementsXpath) {
        getElementByPath(dropdownXpath).click();
        setElementsListByPath(elementsXpath);
        for (int i = 0; i < webElements.size(); i++) {
            webElements.get(i).click();
            openPage("https://epam.github.io/JDI");
            getElementByPath(dropdownXpath).click();
            setElementsListByPath(elementsXpath);
        }
        deleteElementsList();

    }

    //8.Check interface on Different elements page, it contains all needed elements
    public void amountOfElementsAssertion(String path, int expectedAmount, String typeOfLocator) {
        openPage("https://epam.github.io/JDI/different-elements.html");
        if (typeOfLocator.equals("xpath")) {
            setElementsListByPath(path);
        } else {
            setElementsListByClassName(path);
        }
        int amount = webElements.size();
        deleteElementsList();
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
    public void checkboxAndRadioSelection(String path, boolean checked) {
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
        setElementsListByPath(path);
        if (checked) {
            for (int i = 0; i < webElements.size(); i++) {

                if (webElements.get(i).getText().contains(nameOfElement) && getElementByPath(elementXpath).isSelected() && webElements.get(i).getText().contains("true")) {
                    flag = true;
                }
            }
        } else {
            for (int i = 0; i < webElements.size(); i++) {
                if (webElements.get(i).getText().contains(nameOfElement) && webElements.get(i).getText().contains("false")) {
                    flag = true;
                }
            }


        }
        deleteElementsList();
        assertTrue(flag);

    }


    //14.Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton.
    public void logRowAssertionRadios(String path, String nameOfElement, String elementXpath) {
        boolean flag = false;
        setElementsListByPath(path);
        for (int i = 0; i < webElements.size(); i++) {

            if (webElements.get(i).getText().contains(nameOfElement) && getElementByPath(elementXpath).isSelected()) {
                flag = true;
            }
        }
        deleteElementsList();
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
        setElementsListByPath(path);
        for (int i = 0; i < webElements.size(); i++) {

            if (webElements.get(i).getText().contains(nameOfElement)) {
                flag = true;
            }

        }
        deleteElementsList();
        assertTrue(flag);

    }

}
