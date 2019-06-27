package hw4;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class HomePage {
    //COMMON FOR EX1 & EX2
    @FindBy(id = "user-icon")
    private SelenideElement userIcon;

    @FindBy(id = "name")
    private SelenideElement loginNameTextField;

    @FindBy(xpath = "//button[@id='login-button']")
    private SelenideElement loginButton;

    @FindBy(id = "user-name")
    private SelenideElement userName;

    //EX1
    @FindAll(@FindBy(xpath = "//ul[contains(@class,'dropdown-menu')]/li/a"))
    private ElementsCollection serviceDropdownElements;

    @FindBy(xpath = "//a[text()[contains(., 'Service')]]")
    private SelenideElement serviceDropdown;

    @FindBy(xpath = "//span[text()[contains(., 'Service')]]")
    private SelenideElement serviceLeftDropdown;

    @FindAll(@FindBy(xpath = "//ul[contains(@class,'sub')]/li/a"))
    private ElementsCollection serviceLeftDropdownElements;

    //EX2
    @FindAll(@FindBy(css = ".nav>li>a"))
    private ElementsCollection headerItems;


    public HomePage() {
        page(this);
    }

    //COMMON FOR EX1 & EX2
    public HomePage login(String userName, String password) {
        userIcon.click();
        loginNameTextField.sendKeys(userName);
        $("#password").sendKeys(password);
        loginButton.click();
        return this;
    }

    public SelenideElement getUserName() {
        return userName;
    }

    //EX1
    public ElementsCollection getServiceDropdownElements() {
        return serviceDropdownElements;
    }

    public HomePage clickServiceHeader() {
        serviceDropdown.click();
        return this;
    }

    public HomePage clickLeftSideServiceHeader() {
        serviceLeftDropdown.click();
        return this;
    }

    public ElementsCollection getServiceLeftDropdownElements() {
        return serviceLeftDropdownElements;
    }

    public HomePage clickElementFromList(ElementsCollection elements, String neededElement) {
        elements.findBy(Condition.text(neededElement)).click();
        return this;
    }
    public ElementsCollection getHeaderItems(){
        return headerItems;
    }

    public TableWithPagesPage openTableWithPagesPage() {
        clickServiceHeader();
        clickElementFromList(serviceDropdownElements,"TABLE WITH PAGES");
        return new TableWithPagesPage();
    }

    public MetalsAndColorsPage openMetalsAndColorsPage() {
        clickElementFromList(headerItems,"METALS & COLORS");
        return new MetalsAndColorsPage();
    }


}
