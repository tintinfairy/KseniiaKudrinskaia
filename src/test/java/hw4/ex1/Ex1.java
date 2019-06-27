package hw4.ex1;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import hw4.TableWithPagesPage;
import hw4.base.BaseTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class Ex1 extends BaseTest {

    @Test
    public void main() {
        //4.Assert User name in the left-top side of screen that user is loggined
        userNameAssertion("PITER CHAILOVSKII");

        //5.Click on "Service" subcategory in the header and check that drop down contains options
        List<String> itemsOfServiceDropdown = Arrays.asList("SUPPORT", "DATES", "COMPLEX TABLE", "SIMPLE TABLE", "TABLE WITH PAGES", "DIFFERENT ELEMENTS");
        hp.clickServiceHeader();
        headerItemsAssertion(hp.getServiceDropdownElements(), itemsOfServiceDropdown);

        //6.Click on Service subcategory in the left section and check that drop down contains options
        hp.clickLeftSideServiceHeader();
        headerItemsAssertion(hp.getServiceLeftDropdownElements(), itemsOfServiceDropdown);

        //7.Open through the header menu Service -> Table with pages
        TableWithPagesPage tableWithPagesPage = hp.openTableWithPagesPage();

        //8.Check that default value for “Show entries” dropdown is 5
        tableWithPagesPage.getDefaultOptionOfDropdown().has(Condition.text("5"));

        //9.Assert that there is Right Section
        tableWithPagesPage.getRightSection().shouldBe(Condition.visible);

        //10.Assert that there is Left Section
        tableWithPagesPage.getLeftSection().shouldBe(Condition.visible);

        //11.Select new value for the entries in the dropdown list
        String elementOfDropdown = "10";
        tableWithPagesPage = tableWithPagesPage.selectDropdownValue(elementOfDropdown);

        //12.Assert that for the dropdown there is an individual log row and value is corresponded to the value of dropdown.
        assertThat(tableWithPagesPage.getLogs().last().getText(), containsString(elementOfDropdown));

        //13.Assert that in the table displayed corrected amount of entries
        tableWithPagesPage.getLogs().shouldHave(CollectionCondition.size(2));

        //14.Type in “Search” text field
        tableWithPagesPage = tableWithPagesPage.fillInTextField("Custom");

        //15.Assert the table contains only records with Search field value
        logRowAssertion(tableWithPagesPage.getLogs(), "Custom");


    }

    //4.Assert User name in the left-top side of screen that user is loggined
    public void userNameAssertion(String expectedName) {
        hp.getUserName().has(Condition.text(expectedName));
    }

    //5.Click on "Service" subcategory in the header and check that drop down contains options
    //6.Click on Service subcategory in the left section and check that drop down contains options

    public void headerItemsAssertion(ElementsCollection actualHeaderItems, List<String> expectedHeaderItems) {
        List<String> headerItems = new ArrayList<>();
        for (int i = 0; i < actualHeaderItems.size(); i++) {
            headerItems.add(actualHeaderItems.get(i).getText().toUpperCase());
        }
        assertThat(headerItems, hasItems(isIn(expectedHeaderItems)));
    }

    //15.Assert the table contains only records with Search field value
    public void logRowAssertion(ElementsCollection logs, String str) {
        assertThat(logs.get(1).getText(), containsString(str));
    }

}
