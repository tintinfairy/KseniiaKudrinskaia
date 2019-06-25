package hw3.base;

import hw3.voids.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.testng.Assert.assertEquals;

public class BaseTest {

    protected static WebDriver driver;
    HomePage hp;

    @BeforeMethod
    public void commonMethodsForEx1Ex2() throws IOException {

        // TODO It will be better if you extracted this peace of code to the separate method with file name as parameter
        // TODO It allow you use diiferent user
        Properties properties = new Properties();
        properties.load(new FileInputStream(new File("userdata.properties")));
        String logName = properties.getProperty("logname");
        String password = properties.getProperty("password");
        String userName = properties.getProperty("username");

        //SetUp
        setUpDriverPath();
        setUpDriver();
        hp = new HomePage(driver);

        //1. Open test site by URL
        openPage("https://epam.github.io/JDI");
        //2. Assert browser title
        pageTitleAssertion("Home Page");
        //3. Perform login
        hp.login(logName, password);
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

    //1. Open test site by URL
    public void openPage(String page) {
        driver.get(page);
    }

    //2.Assert Browser title
    public void pageTitleAssertion(String pageTitle) {
        assertEquals(hp.getPageTitle(), pageTitle);
    }

    //4.Assert User name in the left-top side of screen that user is loggined
    public void usernameAssertion(String userName) {
        assertEquals(hp.getUsername(), userName);
    }


    //17. Close browser
    //19.Close browser
    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
