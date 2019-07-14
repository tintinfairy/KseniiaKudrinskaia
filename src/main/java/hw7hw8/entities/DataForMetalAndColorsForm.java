package hw7hw8.entities;

import hw7hw8.enums.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@ToString
@AllArgsConstructor
public class DataForMetalAndColorsForm {
    private List<String> summary;
    private List<String> elements;
    private String color;
    private String metals;
    private List<String> vegetables;

    public List<String> getLogIsExpected() {
        return Arrays.asList(
                "Summary: " + getIntegerListOfSummary().stream().mapToInt(Integer::intValue).sum(),
                "Elements: " + listToString(elements),
                "Color: " + color,
                "Metal: " + metals,
                "Vegetables: " + listToString(vegetables)

        );
    }

    public List<Integer> getIntegerListOfSummary() {
        return summary.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    public String listToString(List<String> list) {
        return String.join(", ", list);
    }

    public static DataForMetalAndColorsForm fillTestData() {
        return new DataForMetalAndColorsForm(Summary.THREE_AND_EIGHT.getValues(),
                Elements.WATER_AND_FIRE.getValues(),
                Colors.RED.getValue(),
                Metals.SELEN.getValue(),
                Vegetables.CUCUMBER_AND_TOMATO.getValues());
    }
}
