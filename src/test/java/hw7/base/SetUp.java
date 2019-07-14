package hw7.base;

import com.epam.jdi.light.driver.get.DriverData;
import hw7hw8.JDISite;
import hw7hw8.entities.Users;
import hw7hw8.enums.HeaderElements;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.ui.html.PageFactory.initElements;
import static hw7hw8.JDISite.jdiHomePage;

public class SetUp {

    @BeforeSuite
    public void setUpEnvironment() {
        DriverData.CHROME_OPTIONS = () -> {
            ChromeOptions cap = new ChromeOptions();
            cap.addArguments("--start-maximized");
            return cap;
        };

        initElements(JDISite.class);
    }
    @BeforeClass
    public void loginAsUserAndOpenMetalAndColorsPage(){
        jdiHomePage.open();
        jdiHomePage.login(Users.PITER_CHAILOVSKII);
        jdiHomePage.checkLoggedIn(Users.PITER_CHAILOVSKII);
        jdiHomePage.openPageFromHeader(HeaderElements.METALS_AND_COLORS);
    }
    @AfterSuite
    public void cleanEnvironment() {
        killAllSeleniumDrivers();
    }
}
