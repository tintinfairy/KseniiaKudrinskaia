package hw7hw8.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.Label;
import hw7hw8.entities.Users;
import hw7hw8.enums.HeaderElements;
import hw7hw8.forms.JDILoginForm;
import hw7hw8.sections.HeaderNavigationMenu;
import org.hamcrest.Matchers;

@Url("index.html")
@Title("Home Page")
public class JDIHomePage extends WebPage {

    private JDILoginForm loginForm;
    private HeaderNavigationMenu headerMenu;

    @Css("#user-name")
    private Label userName;

    @Css(".profile-photo")
    private Button profilePhoto;

    public void login(Users user) {
        profilePhoto.click();
        loginForm.login(user);
    }

    public void openPageFromHeader(HeaderElements elements) {
        headerMenu.getHeaderMenu().select(elements.getValue());
    }

    public void checkLoggedIn(Users user) {
        userName.shouldBe().text(Matchers.equalTo(user.getUserName()));
    }
}