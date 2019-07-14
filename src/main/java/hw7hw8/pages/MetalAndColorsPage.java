package hw7hw8.pages;


import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import hw7hw8.entities.DataForMetalAndColorsForm;
import hw7hw8.forms.MetalAndColorsForm;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Url("metals-colors.html")
@Title("Metal and Colors")
public class MetalAndColorsPage extends WebPage {
    private MetalAndColorsForm form;

    public void fillInFormAndAssertLog(DataForMetalAndColorsForm data) {
        reload();
        form.fillDataOnPage(data);
        form.clickSubmitButton();
        assertThat(form.getStringListLog(), equalTo(data.getLogIsExpected()));
    }

}


