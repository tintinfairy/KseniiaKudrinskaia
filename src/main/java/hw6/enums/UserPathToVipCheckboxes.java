package hw6.enums;

public enum UserPathToVipCheckboxes {

    ROMAN("//input[@id='roman']"),
    SERGEY_IVAN("//input[@id='ivan']"),
    VLADZIMIR("//input[@id='vlad']"),
    HELEN_BENNETT("//input[@id='helen']"),
    YOSHI_TANNAMURI("//input[@id='yoshi']"),
    GIOVANNI_ROVELLI("//input[@id='gio']");

    final String pathToVipCheckbox;

    UserPathToVipCheckboxes(String pathToVipCheckbox) {
        this.pathToVipCheckbox = pathToVipCheckbox;
    }

    public String getPathToVipCheckbox() {
        return pathToVipCheckbox;
    }
}