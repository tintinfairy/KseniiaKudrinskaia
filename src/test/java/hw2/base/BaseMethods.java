package hw2.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Paths;

import static org.testng.Assert.assertEquals;

public class BaseMethods {

    protected WebDriver driver;

    protected WebElement getElementByPath(String path) {

        return driver.findElement(By.xpath(path));
    }

    protected WebElement getElementById(String id) {

        return driver.findElement(By.id(id));
    }

    // TODO Why it classificator not selector?
    protected WebElement getElementByCssClassificator(String cssSelector) {

        return driver.findElement(By.cssSelector(cssSelector));
    }


    public void setUpDriverPath() {
        // TODO Why do you decide not split driver path and driver initialization?
        System.setProperty("webdriver.chrome.driver",
                Paths.get("src/test/resources/driver/chromedriver.exe")
                        .toAbsolutePath().toString());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    //1. Open test site by URL
    public void openPage(String page) {
        driver.get(page);
    }


    //2. Assert browser title
    // TODO I do not get method name
    // TODO Why ii has postfix as Test?
    public void seleniumOpenPageTest(String pageName) {
        assertEquals(driver.getTitle(), pageName);
    }

    //3. Perform login
    // TODO Why ii has postfix as Test?
    public void loginTest(String name, String password) {
        getElementById("user-icon").click();
        getElementById("name").sendKeys(name);
        getElementByCssClassificator("#password").sendKeys(password);
        getElementByPath("//button[@id='login-button']").click();

    }

    //4.Assert User name in left-top side of screen that user is logged
    // TODO Why ii has postfix as Test?
    public void usernameAssertionTest(String userName) {
        assertEquals(getElementById("user-name")
                .getText(), userName);


    }


    //17. Close browser
    public void tearDown() {
        driver.close();
    }
}
