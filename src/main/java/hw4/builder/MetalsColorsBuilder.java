package hw4.builder;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Builder
@Getter
@ToString
public class MetalsColorsBuilder {
    private List<String> summary;
    private List<String> elements;
    private String color;
    private String metal;
    private List<String> vegetables;
}
