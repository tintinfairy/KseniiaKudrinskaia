package hw4.steps;

import hw4.HomePage;
import hw4.MetalsAndColorsPage;

public class HomePageSteps {
    HomePage homePage = new HomePage();

    public MetalsAndColorsPage openMetalsAndColorsPage() {
        // TODO This step and class is redundant here
        // TODO You could use this method in test directly from the selenide page object
        return homePage.openMetalsAndColorsPage();
    }


}
