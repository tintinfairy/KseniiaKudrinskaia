package hw4;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.page;

public class MetalsAndColorsPage {
    @Getter
    @FindAll(@FindBy(xpath = "//section[@class='horizontal-group']//p"))
    private ElementsCollection radioButtons;
    @Getter
    @FindAll(@FindBy(xpath = "//section[@class='vertical-group']//p"))
    private ElementsCollection checkboxes;
    @FindBy(xpath = "//button[@title='Colors']")
    private SelenideElement colorDropdownButton;
    @FindBy(xpath = "//button[@title='Metals']//span[@class='caret']")
    private SelenideElement metalDropdownButton;
    @FindAll(@FindBy(xpath = "//div[@id='colors']//li"))
    private ElementsCollection colors;
    @FindAll(@FindBy(xpath = "//div[@id='metals']//li"))
    private ElementsCollection metals;
    @FindBy(xpath = "//button[@class='btn btn-default dropdown-toggle']")
    private SelenideElement vegetablesDropdownButton;
    @Getter
    @FindAll(@FindBy(xpath = "//div[@id='salad-dropdown']//li//a"))
    private ElementsCollection vegetables;
    @FindBy(xpath = "//button[text()='Submit']")
    private SelenideElement submitButton;
    @Getter
    @FindBy(xpath = "//ul[@class='panel-body-list results']")
    private SelenideElement log;

    public MetalsAndColorsPage() {
        page(this);
    }

    public MetalsAndColorsPage chooseElementFromList(ElementsCollection elementsFromWebPage, List<String> elements) {
        for (String value : elements) {
            elementsFromWebPage.findBy(Condition.text(value)).click();
        }
        return this;
    }

    public MetalsAndColorsPage chooseColor(String color) {
        colorDropdownButton.click();
        colors.findBy(Condition.text(color)).click();
        return this;
    }

    public MetalsAndColorsPage chooseMetal(String metal) {
        metalDropdownButton.click();
        metals.findBy(Condition.text(metal)).click();
        return this;
    }

    public MetalsAndColorsPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public MetalsAndColorsPage clearVegetablesDropDownCheckBoxes(List<String> elements) {
        vegetablesDropdownButton.click();
        if (elements != null) {
            vegetables.findBy(exactText("Vegetables")).click();
        }
        return this;
    }

}
