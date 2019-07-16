package hw7.base;

import com.epam.jdi.light.driver.get.DriverData;
import hw7hw8.JDISite;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.ui.html.PageFactory.initElements;

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


    @AfterSuite
    public void cleanEnvironment() {
        killAllSeleniumDrivers();
    }
}
