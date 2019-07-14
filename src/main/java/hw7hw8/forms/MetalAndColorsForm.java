package hw7hw8.forms;

import com.epam.jdi.light.elements.base.BaseUIElement;
import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import com.epam.jdi.light.ui.html.base.HtmlRadioGroup;
import com.epam.jdi.light.ui.html.common.Button;
import hw7hw8.entities.DataForMetalAndColorsForm;

import java.util.List;
import java.util.stream.Collectors;

public class MetalAndColorsForm extends Form<DataForMetalAndColorsForm> {
    @XPath("//section[@class='horizontal-group']//p")
    private HtmlRadioGroup radioButtons;

    @XPath("//section[@class='vertical-group']//p")
    private HtmlRadioGroup checkboxes;

    @JDropdown(root = "div[ui=dropdown]", value = ".filter-option", list = "li", expand = ".caret")
    private Droplist colors;

    @JDropdown(root = "div[ui=combobox]", value = "input", list = "li", expand = ".caret")
    private Droplist metals;

    @JDropdown(root = "#salad-dropdown", value = ".dropdown-toggle", list = "li", expand = ".caret")
    private Droplist vegetables;

    @XPath("//button[text()='Submit']")
    private Button submitButton;

    @XPath("//ul[@class='panel-body-list results']")
    private WebList log;

    public List<String> getStringListLog() {
        return log.stream().map(BaseUIElement::getText).collect(Collectors.toList());
    }

    public void fillDataOnPage(DataForMetalAndColorsForm entity) {
        entity.getSummary().forEach(value -> radioButtons.select(value));
        metals.select(entity.getMetals());
        colors.select(entity.getColor());
        entity.getElements().forEach(value -> checkboxes.select(value));
        vegetables.select("Vegetables");
        entity.getVegetables().forEach(value -> vegetables.select(value));
    }

    public void clickSubmitButton() {
        submitButton.click();
    }


}
