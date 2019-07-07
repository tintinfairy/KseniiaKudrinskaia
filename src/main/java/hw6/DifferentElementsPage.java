package hw6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DifferentElementsPage {
    private static DifferentElementsPage instance;
    private static WebDriver driver;

    @FindAll(@FindBy(className = "label-checkbox"))
    private List<WebElement> checkboxes;

    @FindAll(@FindBy(className = "label-radio"))
    private List<WebElement> radios;

    @FindAll(@FindBy(xpath = "//select"))
    private List<WebElement> dropdowns;

    @FindAll(@FindBy(xpath = "//*[@class='uui-button']"))
    private List<WebElement> buttons;

    @FindBy(id = "mCSB_2")
    private WebElement rightSection;

    @FindBy(id = "mCSB_1")
    private WebElement leftSection;

    @FindBy(xpath = "//label[contains(.,'Water')]/input")
    private WebElement waterCheckbox;

    @FindBy(xpath = "//label[contains(.,'Wind')]/input")
    private WebElement windCheckbox;

    @FindAll(@FindBy(xpath = "//ul[@class='panel-body-list logs']/li"))
    private List<WebElement> logs;

    @FindBy(xpath = "//label[contains(.,'Selen')]/input")
    private WebElement selenRadio;

    @FindBy(xpath = "//select")
    private WebElement dropdown;


    private DifferentElementsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public int getAmountOfCheckboxes() {
        return checkboxes.size();
    }

    public int getAmountOfRadios() {
        return radios.size();
    }

    public int getAmountOfDropdowns() {
        return dropdowns.size();
    }

    public int getAmountOfButtons() {
        return buttons.size();
    }

    public void rightSectionIsDisplayed() {
        rightSection.isDisplayed();
    }

    public void leftSectionIsDisplayed() {
        leftSection.isDisplayed();
    }

    public void selectRadioOrCheckbox(String name) {
        switch (name) {
            case "Water": {
                waterCheckbox.click();
                break;
            }
            case "Wind": {
                windCheckbox.click();
                break;
            }
            case "Selen": {
                selenRadio.click();
                break;
            }
        }
    }

    public List<WebElement> getLogs() {
        return logs;
    }

    public int getLogsSize() {
        return logs.size();
    }

    public String getLogsText(int i) {
        return logs.get(i).getText();
    }

    public void selectDropdownElement(String element) {
        Select dropdown = new Select(this.dropdown);
        dropdown.selectByVisibleText(element);
    }

    public static DifferentElementsPage getInstance(WebDriver driver) {
        if (instance == null || DifferentElementsPage.driver != driver) {
            instance = new DifferentElementsPage(driver);
            DifferentElementsPage.driver = driver;
        }
        return instance;
    }

}
