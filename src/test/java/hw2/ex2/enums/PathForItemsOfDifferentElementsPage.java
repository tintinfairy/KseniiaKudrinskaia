package hw2.ex2.enums;

public enum PathForItemsOfDifferentElementsPage {
    CHECKBOX("label-checkbox"),
    RADIO("label-radio"),
    DROPDOWN("//select"),
    BUTTON("//*[@class='uui-button']");

    final String path;

    PathForItemsOfDifferentElementsPage(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
