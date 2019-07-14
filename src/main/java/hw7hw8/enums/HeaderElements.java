package hw7hw8.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HeaderElements {
    HOME("Home"),
    CONTACT_FORM("Contact form"),
    SERVICE("Service"),
    METALS_AND_COLORS("Metals & Colors");
    private String value;
}
