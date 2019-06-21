package hw2.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.nio.file.Paths;

import static org.testng.Assert.assertEquals;

public class BaseTest {

    protected static WebDriver driver;


    @BeforeMethod
    public void commonMethodsForEx1Ex2() {

        setUpDriverPath();
        setUpDriver();

        //1. Open test site by URL
        openPage("https://epam.github.io/JDI");

        //2. Assert browser title
        pageTitleAssertion("Home Page");

        //3. Perform login
        login("epam", "1234");

        //4.Assert User name in left-top side of screen that user is logged
        usernameAssertion("PITER CHAILOVSKII");

    }

    protected WebElement getElementByPath(String path) {

        return driver.findElement(By.xpath(path));
    }

    protected WebElement getElementById(String id) {

        return driver.findElement(By.id(id));
    }

    // TODO Why it classificator not selector? [FIXED]
    protected WebElement getElementByCssSelector(String cssSelector) {

        return driver.findElement(By.cssSelector(cssSelector));
    }


    public void setUpDriverPath() {
        // TODO Why do you decide not split driver path and driver initialization? [FIXED]
        System.setProperty("webdriver.chrome.driver",
                Paths.get("src/test/resources/driver/chromedriver.exe")
                        .toAbsolutePath().toString());
    }

    public void setUpDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    //1. Open test site by URL
    public void openPage(String page) {
        driver.get(page);
    }


    //2. Assert browser title
    // TODO I do not get method name [FIXED]
    // TODO Why ii has postfix as Test? [FIXED]
    public void pageTitleAssertion(String pageName) {
        assertEquals(driver.getTitle(), pageName);
    }

    //3. Perform login
    // TODO Why ii has postfix as Test? [FIXED]
    public void login(String name, String password) {
        getElementById("user-icon").click();
        getElementById("name").sendKeys(name);
        getElementByCssSelector("#password").sendKeys(password);
        getElementByPath("//button[@id='login-button']").click();
    }

    //4.Assert User name in left-top side of screen that user is logged
    // TODO Why ii has postfix as Test? [FIXED]
    public void usernameAssertion(String userName) {
        assertEquals(getElementById("user-name")
                .getText(), userName);

    }


    //17. Close browser
    //19.Close browser
    @AfterMethod
    public void tearDown() {
        driver.close();
    }

}
