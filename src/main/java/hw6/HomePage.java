package hw6;


import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    private static HomePage instance;
    private static WebDriver driver;
    //COMMON FOR EX1 & EX2
    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement loginNameTextField;

    @FindBy(css = "#password")
    private WebElement password;

    @FindBy(xpath = "//button[@id='login-button']")
    private WebElement loginButton;

    @Getter
    @FindBy(id = "user-name")
    private WebElement userName;

    //EX1
    @FindAll(@FindBy(className = "benefit-icon"))
    private List<WebElement> images;

    @FindAll(@FindBy(className = "benefit-txt"))
    private List<WebElement> textUnderImages;

    @FindBy(name = "main-title")
    private WebElement mainTitle;

    @FindBy(name = "jdi-text")
    private WebElement jdiText;

    @FindAll(@FindBy(xpath = "//ul[contains(@class,'dropdown-menu')]/li/a"))
    private List<WebElement> serviceDropdownElements;

    @Getter
    @FindBy(xpath = "//a[text()[contains(., 'Service')]]")
    private WebElement serviceDropdown;

    @Getter
    @FindBy(xpath = "//span[text()[contains(., 'Service')]]")
    private WebElement serviceLeftDropdown;


    private HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //COMMON FOR EX1 & EX2
    public void userIconClick() {
        userIcon.click();
    }

    public void fillLoginTextField(String login) {
        loginNameTextField.sendKeys(login);
    }

    public void fillPasswordTextField(String password) {
        this.password.sendKeys(password);
    }

    public void loginButtonClick() {
        loginButton.click();
    }

    //EX1
    public int getAmountOfImages() {
        return images.size();
    }

    public int getAmountOfTextFieldsUnderImages() {
        return textUnderImages.size();
    }

    public int getAmountOfTextsAbovePictures() {
        if (mainTitle.isDisplayed() && jdiText.isDisplayed()) {
            return 2;
        }
        return 0;
    }

    public void clickServiceHeader() {
        serviceDropdown.click();
    }


    public void clickLeftSideServiceHeader() {
        serviceLeftDropdown.click();
    }

    public void clickAppropriateElementOfDropdown(String element) {
        for (int i = 0; i < serviceDropdownElements.size(); i++) {
            if (serviceDropdownElements.get(i).getText().equals(element)) {
                serviceDropdownElements.get(i).click();
                break;
            }
        }
    }

    public static HomePage getInstance(WebDriver driver) {
        if (instance == null || HomePage.driver != driver) {
            instance = new HomePage(driver);
            HomePage.driver = driver;
        }
        return instance;
    }


}
