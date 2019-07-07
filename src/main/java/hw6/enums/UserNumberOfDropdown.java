package hw6.enums;

public enum UserNumberOfDropdown {

    ROMAN(0),
    SERGEY_IVAN(1),
    VLADZIMIR(2),
    HELEN_BENNETT(3),
    YOSHI_TANNAMURI(4),
    GIOVANNI_ROVELLI(6);

    final int numberOfDropdown;

    UserNumberOfDropdown(int numberOfDropdown) {
        this.numberOfDropdown = numberOfDropdown;
    }

    public int getNumberOfDropdown() {
        return numberOfDropdown;
    }
}