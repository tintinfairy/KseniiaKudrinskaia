package hw6.steps.util;

import hw6.hooks.TestContext;
import hw6.steps.BaseSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.isIn;
import static org.testng.Assert.assertTrue;

public class MethodsForAsserts extends BaseSteps {
    public void logRowInformationAssertion(String element, String selected) {
        boolean flag = false;
        for (int i = 0; i < differentElementsPage.getLogsSize(); i++) {
            if (differentElementsPage.getLogsText(i).contains(element) && differentElementsPage.getLogsText(i).contains(selected)) {
                flag = true;
            }
        }
        assertTrue(flag);
    }

    public List<String> listOfWebElementsToStringList(String path) {
        List<WebElement> listSubMenu = TestContext.getDriver().
                findElements(By.xpath(path));
        List<String> subItemsText = listSubMenu.
                stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        return subItemsText;
    }

    public void dropdownItemsAssertion(List<String> items, String path) {
        assertThat(items, hasItems(isIn(listOfWebElementsToStringList(path))));

    }

    public Map<String, String> initializeMap(String number, String userName, String descriptionText) {
        Map<String, String> result = new LinkedHashMap<>();
        result.put("Number", number);
        result.put("User", userName);
        result.put("Description", descriptionText);
        return result;
    }

    public List<Map<String, String>> listsToListOfMaps(List<String> userNames, List<String> descriptionTexts) {
        List<Map<String, String>> items = new ArrayList<>();
        for (int i = 0; i < userNames.size(); i++) {
            items.add(initializeMap(Integer.toString(i + 1), userNames.get(i), descriptionTexts.get(i)));
        }
        return items;
    }

    public List<String> getElementsOfDropDown(WebElement dropdown) {
        return new Select(dropdown)
                .getOptions()
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

}
