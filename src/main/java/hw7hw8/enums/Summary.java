package hw7hw8.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor
public enum Summary {
    THREE_AND_EIGHT(Arrays.asList("3", "8"));
    private List<String> values;

}
