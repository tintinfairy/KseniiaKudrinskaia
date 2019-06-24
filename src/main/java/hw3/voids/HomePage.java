package hw3.voids;

import hw3.enums.HeaderSections;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {
    //COMMON FOR EX1 & EX2
    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement loginNameTextField;

    @FindBy(css = "#password")
    private WebElement password;

    @FindBy(xpath = "//button[@id='login-button']")
    private WebElement loginButton;

    @FindBy(id = "user-name")
    private WebElement userName;

    //EX1
    @FindAll(@FindBy(css = ".nav>li>a"))
    private List<WebElement> headerItems;

    @FindAll(@FindBy(className = "benefit-icon"))
    private List<WebElement> images;

    @FindAll(@FindBy(xpath = "//span[contains(@class,'benefit-txt')]"))
    private List<WebElement> textUnderImages;

    @FindBy(name = "main-title")
    private WebElement mainTitle;

    @FindBy(name = "jdi-text")
    private WebElement jdiText;

    @FindBy(xpath = "//a[@href='https://github.com/epam/JDI']")
    private WebElement subHeader;

    @FindBy(name = "navigation-sidebar")
    private WebElement navigationSidebar;

    @FindBy(tagName = "footer")
    private WebElement footer;

    //EX2
    @FindAll(@FindBy(xpath = "//ul[contains(@class,'dropdown-menu')]/li/a"))
    private List<WebElement> serviceDropdownElements;

    @FindBy(xpath = "//a[text()[contains(., 'Service')]]")
    private WebElement serviceDropdown;

    @FindBy(xpath = "//span[text()[contains(., 'Service')]]")
    private WebElement serviceLeftDropdown;

    @FindAll(@FindBy(xpath = "//ul[contains(@class,'sub')]/li/a"))
    private List<WebElement> serviceLeftDropdownElements;


    public HomePage(WebDriver driver) {
        super(driver);
    }
    //COMMON FOR EX1 & EX2
    public void login(String userName, String password) {
        userIcon.click();
        loginNameTextField.sendKeys(userName);
        this.password.sendKeys(password);
        loginButton.click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getUsername() {
        return userName.getText();
    }

    //EX1
    public void headerItemsAreDisplayed() {
        for (WebElement item : headerItems) {
            item.isDisplayed();
        }

    }

    public String getHeaderName(String name) {
        for (HeaderSections item : HeaderSections.values()) {
            if (item.getName().equals(name)) return item.getName();
        }
        return null;
    }

    public void imagesAreDisplayed() {
        for (WebElement item : images) {
            item.isDisplayed();
        }
    }

    public int getAmountOfImages() {
        return images.size();
    }

    public int getAmountOfTextFieldsUnderImages() {
        return textUnderImages.size();
    }

    public String getTextUnderImages(int i) {
        return textUnderImages.get(i).getText();
    }

    public String getMainTitle() {
        return mainTitle.getText();
    }

    public String getJdiText() {
        return jdiText.getText();
    }

    public boolean containingIFrame() {
        return driver.getPageSource().contains("iframe");

    }

    public void epamLogoCheck() {
        driver.switchTo().frame(0);
        userIcon.isDisplayed();
        driver.switchTo().defaultContent();
    }

    public void switchToMainFrame() {
        driver.switchTo().defaultContent();
    }

    public String getSubHesderText() {
        return subHeader.getText();
    }

    public String getSubHeaderLink() {
        return subHeader.getAttribute("href");
    }

    public void navigationSidebarIsDisplayed() {
        navigationSidebar.isDisplayed();
    }

    public void footerIsDisplayed() {
        footer.isDisplayed();
    }



    //EX2
    public void clickServiceHeader() {
        serviceDropdown.click();
    }

    public List<WebElement> getServiceDropdownElements() {
        return serviceDropdownElements;
    }

    public void clickLeftSideServiceHeader() {
        serviceLeftDropdown.click();
    }

    public List<WebElement> getServiceLeftDropdownElements() {
        return serviceLeftDropdownElements;
    }

    public int getAmountOfContainingElements(List<WebElement> listOfElements, List<String> expectedElements) {
        int count = 0;
        for (int i = 0; i < expectedElements.size(); i++) {
            for (WebElement element : listOfElements) {
                if (element.getText().equals(expectedElements.get(i))) {
                    count++;
                }
            }
        }
        return count;
    }

    public void clickAppropriateElementOfDropdown(String element) {
        for (int i = 0; i < serviceDropdownElements.size(); i++) {
            if (serviceDropdownElements.get(i).getText().equals("Different elements")) {
                serviceDropdownElements.get(i).click();
            }
        }
    }


}
