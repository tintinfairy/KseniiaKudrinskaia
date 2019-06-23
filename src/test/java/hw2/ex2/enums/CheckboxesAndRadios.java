package hw2.ex2.enums;

public enum CheckboxesAndRadios {
    WATER("//label[contains(.,'Water')]/input"),
    WIND("//label[contains(.,'Wind')]/input"),
    SELEN("//label[contains(.,'Selen')]/input");

    final String path;

    CheckboxesAndRadios(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
