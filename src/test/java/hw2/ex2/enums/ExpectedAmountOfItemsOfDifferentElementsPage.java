package hw2.ex2.enums;

public enum ExpectedAmountOfItemsOfDifferentElementsPage {

    CHECKBOX(4),
    RADIO(4),
    DROPDOWN(1),
    BUTTON(2);

    final int amount;

    ExpectedAmountOfItemsOfDifferentElementsPage(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}