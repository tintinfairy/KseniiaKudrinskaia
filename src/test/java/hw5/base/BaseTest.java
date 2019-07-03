package hw5.base;

import hw5.HomePage;
import hw5.TestProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.testng.Assert.assertEquals;

public abstract class BaseTest {

    protected static WebDriver driver;
    protected static HomePage homePage;
    String logName = "epam";
    String password = "1234";
    String userName = "PITER CHAILOVSKII";


    @BeforeMethod
    public void commonMethodsForEx1Ex2() throws IOException {
        //loadUserDataFromPropertiesFile("userdata.properties");
        //SetUp
        setUpDriverPath();
        setUpDriver();
        TestProvider.getInstance().setDriver(driver);
        homePage = new HomePage(driver);
        //1. Open test site by URL
        openPage("https://epam.github.io/JDI");
        //2. Assert browser title
        pageTitleAssertion("Home Page");
        //3. Perform login
        homePage.login(logName, password);
        //4.Assert User name in left-top side of screen that user is logged
        usernameAssertion(userName);
    }

    public void setUpDriverPath() {
        WebDriverManager.chromedriver().setup();
    }

    public void setUpDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void loadUserDataFromPropertiesFile(String pathname) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(new File(pathname)));
        logName = properties.getProperty("logname");
        password = properties.getProperty("password");
        userName = properties.getProperty("username");
    }

    @Step("Open test site by URL")
    //1. Open test site by URL
    public void openPage(String page) {
        driver.get(page);
    }

    @Step("Assert Browser title")
    //2.Assert Browser title
    public void pageTitleAssertion(String pageTitle) {
        assertEquals(homePage.getPageTitle(), pageTitle);
    }

    @Step("Assert User name in the left-top side of screen that user is loggined as {0}")
    //4.Assert User name in the left-top side of screen that user is loggined
    public void usernameAssertion(String userName) {
        assertEquals(homePage.getUsername(), userName);
    }

    @Step("Close browser")
    //17. Close browser
    //19.Close browser
    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}