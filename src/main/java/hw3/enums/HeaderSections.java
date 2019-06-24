package hw3.enums;

public enum HeaderSections {

    HOME("Home"),
    CONTACT_FORM("Contact form"),
    SERVICE("Service"),
    METALS_COLORS("Metals & Colors");

    final String name;

    HeaderSections(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

}
