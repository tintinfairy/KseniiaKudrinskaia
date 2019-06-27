package hw4.base;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import hw4.HomePage;
import hw4.steps.HomePageSteps;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static org.testng.Assert.assertEquals;

public class BaseTest {
    protected HomePage hp;
    String logName;
    String password;
    String userName;

    @BeforeMethod
    public void commonMethodsForEx1Ex2() throws IOException {
        Selenide.clearBrowserCookies();
        Configuration.browser = Browsers.CHROME;
        Configuration.pollingInterval = 500;
        Configuration.timeout = 5000;
        Configuration.startMaximized = true;
        //1.Open test site by URL
        open("https://epam.github.io/JDI/index.html");
        loadUserDataFromPropertiesFile("userdata.properties");

        hp = new HomePage();
        //2.Assert Browser title
        assertEquals(title(), "Home Page");
        //3.Perform login
        hp.login(logName, password);

    }

    public void loadUserDataFromPropertiesFile(String pathname) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(new File(pathname)));
        logName = properties.getProperty("logname");
        password = properties.getProperty("password");
        userName = properties.getProperty("username");
    }
}
