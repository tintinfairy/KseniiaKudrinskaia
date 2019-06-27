package hw4.steps;

import hw4.HomePage;
import hw4.MetalsAndColorsPage;

public class HomePageSteps {
    HomePage homePage = new HomePage();

    public MetalsAndColorsPage openMetalsAndColorsPage() {
        return homePage.openMetalsAndColorsPage();
    }


}
