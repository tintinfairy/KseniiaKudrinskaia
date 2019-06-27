package hw4.steps;

import hw4.MetalsAndColorsPage;
import hw4.builder.MetalsColorsBuilder;

import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;

public class MetalsAndColorsSteps {
    MetalsAndColorsPage metalsAndColorsPage = new MetalsAndColorsPage();

    public MetalsAndColorsPage chooseRadioButton(MetalsColorsBuilder metalsColorsBuilder) {
        if (metalsColorsBuilder.getSummary() != null) {
            return metalsAndColorsPage.chooseElementFromList(metalsAndColorsPage.getRadioButtons(), metalsColorsBuilder.getSummary());
        }
        return metalsAndColorsPage;
    }

    public MetalsAndColorsPage chooseCheckbox(MetalsColorsBuilder metalsColorsBuilder) {
        if (metalsColorsBuilder.getElements() != null) {
            return metalsAndColorsPage.chooseElementFromList(metalsAndColorsPage.getCheckboxes(), metalsColorsBuilder.getElements());
        }
        return metalsAndColorsPage;
    }

    public MetalsAndColorsPage chooseColor(MetalsColorsBuilder metalsColorsBuilder) {
        if (metalsColorsBuilder.getColor() != null) {
            return metalsAndColorsPage.chooseColor(metalsColorsBuilder.getColor());
        }
        return metalsAndColorsPage;
    }

    public MetalsAndColorsPage chooseMetal(MetalsColorsBuilder metalsColorsBuilder) {
        if (metalsColorsBuilder.getMetal() != null) {
            return metalsAndColorsPage.chooseMetal(metalsColorsBuilder.getMetal());
        }
        return metalsAndColorsPage;
    }

    public MetalsAndColorsPage chooseVegetables(MetalsColorsBuilder metalsColorsBuilder) {
        if (metalsColorsBuilder.getVegetables() != null) {
            return metalsAndColorsPage.chooseElementFromList(metalsAndColorsPage.getVegetables(), metalsColorsBuilder.getVegetables());
        }
        return metalsAndColorsPage;
    }

    public MetalsAndColorsPage makeAllSteps(MetalsColorsBuilder metalsColorsBuilder) {
        chooseRadioButton(metalsColorsBuilder);
        chooseCheckbox(metalsColorsBuilder);
        chooseColor(metalsColorsBuilder);
        chooseMetal(metalsColorsBuilder);
        clearVegetablesDropDownCheckBoxes(metalsColorsBuilder);
        chooseVegetables(metalsColorsBuilder);
        return metalsAndColorsPage;
    }


    public MetalsAndColorsPage clickSubmitButton() {
        metalsAndColorsPage.clickSubmitButton();
        return metalsAndColorsPage;
    }

    public MetalsAndColorsPage clearVegetablesDropDownCheckBoxes(MetalsColorsBuilder metalsColorsBuilder) {
        metalsAndColorsPage.clearVegetablesDropDownCheckBoxes(metalsColorsBuilder.getVegetables());
        return metalsAndColorsPage;
    }

    public MetalsAndColorsPage logAssertion(MetalsColorsBuilder metalsColorsBuilder) {
        String expectedLog = "";
        String summary = "3";
        int sum = 0;
        String elements = "";
        String colors = "Colors";
        String metals = "Metals";
        String vegetables = "Vegetables";
        if (metalsColorsBuilder.getSummary() != null) {
            for (String number : metalsColorsBuilder.getSummary()) {
                sum += Integer.parseInt(number);
            }
            summary = Integer.toString(sum);
        }
        if (metalsColorsBuilder.getElements() != null) {
            elements = metalsColorsBuilder.getElements().stream()
                    .collect(Collectors.joining(", "));

        }
        if (metalsColorsBuilder.getMetal() != null) {
            metals = metalsColorsBuilder.getMetal();

        }
        if (metalsColorsBuilder.getColor() != null) {
            colors = metalsColorsBuilder.getColor();

        }
        if (metalsColorsBuilder.getVegetables() != null) {
            vegetables = metalsColorsBuilder.getVegetables().stream()
                    .collect(Collectors.joining(", "));

        }
        if (metalsColorsBuilder.getElements() != null) {
            expectedLog = String.format("Summary: %s\n" +
                            "Elements: %s\n" +
                            "Color: %s\n" +
                            "Metal: %s\n" +
                            "Vegetables: %s", summary, elements, colors
                    , metals, vegetables);

        } else {
            expectedLog = String.format("Summary: %s\n" +
                            "Color: %s\n" +
                            "Metal: %s\n" +
                            "Vegetables: %s", summary, colors
                    , metals, vegetables);

        }

        assertEquals(metalsAndColorsPage.getLog().getText(), expectedLog);
        return metalsAndColorsPage;

    }
}
