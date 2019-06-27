package hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class TableWithPagesPage {
    @FindBy(xpath = "//select")
    private SelenideElement dropdown;

    @Getter
    @FindBy(id = "mCSB_2")
    private SelenideElement rightSection;

    @Getter
    @FindBy(id = "mCSB_1")
    private SelenideElement leftSection;

    @Getter
    @FindAll(@FindBy(xpath = "//ul[@class='panel-body-list logs']//li"))
    private ElementsCollection logs;

    @FindBy(xpath = "//input[@type='search']")
    private SelenideElement textField;

    public TableWithPagesPage() {
        page(this);
    }

    public SelenideElement getDefaultOptionOfDropdown() {
        return dropdown.getSelectedOption();
    }


    public TableWithPagesPage selectDropdownValue(String value) {
        dropdown.selectOptionContainingText(value);
        return this;
    }

    public SelenideElement getLastLog() {
        return logs.last();
    }

    public TableWithPagesPage fillInTextField(String information) {
        textField.sendKeys(information);
        return this;
    }

}
