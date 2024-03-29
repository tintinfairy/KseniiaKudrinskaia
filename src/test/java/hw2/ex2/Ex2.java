package hw2.ex2;

import hw2.base.BaseTest;
import hw2.ex2.enums.CheckboxesAndRadios;
import hw2.ex2.enums.ExpectedAmountOfItemsOfDifferentElementsPage;
import hw2.ex2.enums.PathForItemsOfDifferentElementsPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

@Test
public class Ex2 extends BaseTest {
    @Test
    public void main() {
        Ex2Methods methods = new Ex2Methods();
        //Fixed in hw2.base.BaseTest.class

        //5.Click on "Service" subcategory in the header and check that drop down contains options
        List<String> elementsOfHeaderDropdown = Arrays.asList("SUPPORT", "DATES", "COMPLEX TABLE", "SIMPLE TABLE", "TABLE WITH PAGES", "DIFFERENT ELEMENTS");
        methods.amountOfServiceHeadersAssertion("//a[text()[contains(., 'Service')]]", "//ul[contains(@class,'dropdown-menu')]/li/a", elementsOfHeaderDropdown);

        //6. Click on Service subcategory in the left section and check that drop down contains options
        List<String> elementsOfSubDropdown = Arrays.asList("Support", "Dates", "Complex Table", "Simple Table", "Table with pages", "Different elements");
        methods.amountOfServiceHeadersAssertion("//span[text()[contains(., 'Service')]]", "//ul[contains(@class,'sub')]/li/a", elementsOfSubDropdown);

        //7.Open through the header menu Service -> Different Elements Page
        methods.openServicePages("//a[text()[contains(., 'Service')]]", "//ul[contains(@class,'dropdown-menu')]/li/a");

        //8.Check interface on Different elements page, it contains all needed elements
        openPage("https://epam.github.io/JDI/different-elements.html");
        methods.amountOfElementsAssertion(By.className(PathForItemsOfDifferentElementsPage.CHECKBOX.getPath()), ExpectedAmountOfItemsOfDifferentElementsPage.CHECKBOX
                .getAmount());
        methods.amountOfElementsAssertion(By.className(PathForItemsOfDifferentElementsPage.RADIO.getPath()), ExpectedAmountOfItemsOfDifferentElementsPage.RADIO.getAmount());
        methods.amountOfElementsAssertion(By.xpath(PathForItemsOfDifferentElementsPage.DROPDOWN.getPath()), ExpectedAmountOfItemsOfDifferentElementsPage.DROPDOWN.getAmount());
        methods.amountOfElementsAssertion(By.xpath(PathForItemsOfDifferentElementsPage.BUTTON.getPath()), ExpectedAmountOfItemsOfDifferentElementsPage.BUTTON.getAmount());

        //9.Assert that there is Right Section
        //10.Assert that there is Right Section
        methods.assertSections("mCSB_2");
        methods.assertSections("mCSB_1");


        //11.Select checkboxes
        methods.checkboxAndRadioSelection("WATER", true);
        methods.checkboxAndRadioSelection("WIND", true);

        //12.Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        methods.logRowAssertionCheckboxes("//ul[@class='panel-body-list logs']/li", "Water", CheckboxesAndRadios.WATER.getPath(), true);
        methods.logRowAssertionCheckboxes("//ul[@class='panel-body-list logs']/li", "Wind",  CheckboxesAndRadios.WIND.getPath(), true);

        //13.Select radio
        methods.checkboxAndRadioSelection("SELEN", true);

        //14.Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton.
        methods.logRowAssertionRadios("//ul[@class='panel-body-list logs']/li", "Selen", CheckboxesAndRadios.SELEN.getPath());

        //15.Select in dropdown
        methods.dropdownElementSelection();

        //16.Assert that for dropdown there is a log row and value is corresponded to the selected value.
        methods.logRowAssertionDropdowns("//ul[@class='panel-body-list logs']/li", "Yellow");

        //17.Unselect and assert checkboxes
        methods.checkboxAndRadioSelection("WATER", false);
        methods.checkboxAndRadioSelection("WIND", false);

        //18.Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        methods.logRowAssertionCheckboxes("//ul[@class='panel-body-list logs']/li", "Water", CheckboxesAndRadios.WATER.getPath(), false);
        methods.logRowAssertionCheckboxes("//ul[@class='panel-body-list logs']/li", "Wind", CheckboxesAndRadios.WIND.getPath(), false);
    }
}
