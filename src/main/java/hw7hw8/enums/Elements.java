package hw7hw8.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor
public enum Elements {
    WATER_AND_FIRE(Arrays.asList("Water", "Wind"));
    private List<String> values;

}
