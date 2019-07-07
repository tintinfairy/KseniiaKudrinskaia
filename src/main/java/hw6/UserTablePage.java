package hw6;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UserTablePage {
    private static UserTablePage instance;
    private static WebDriver driver;

    @FindBy(xpath = "//select")
    @Getter
    private List<WebElement> dropdowns;

    @FindBy(xpath = "//td/a")
    @Getter
    private List<WebElement> userNames;

    @FindBy(xpath = "//td//img")
    @Getter
    private List<WebElement> images;

    @FindBy(xpath = "//div[@class='user-descr']//span")
    @Getter
    private List<WebElement> descriptionTexts;

    @FindBy(xpath = "//td//input")
    @Getter
    private List<WebElement> checkboxes;

    @Getter
    @FindBy(xpath = "//ul[@class='panel-body-list logs']/li")
    private List<WebElement> log;

    private UserTablePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public static UserTablePage getInstance(WebDriver driver) {
        if (instance == null || UserTablePage.driver != driver) {
            instance = new UserTablePage(driver);
            UserTablePage.driver = driver;
        }
        return instance;
    }
}
