package hw7hw8.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor
public enum Vegetables {
    CUCUMBER_AND_TOMATO(Arrays.asList("Cucumber", "Tomato"));
    private List<String> values;

}