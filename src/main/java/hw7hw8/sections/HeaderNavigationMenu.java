package hw7hw8.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import com.epam.jdi.light.ui.html.complex.Menu;
import lombok.Getter;

public class HeaderNavigationMenu extends Section {

    @XPath("//a[text()='%s']")
    @Getter
    private Menu headerMenu;


}