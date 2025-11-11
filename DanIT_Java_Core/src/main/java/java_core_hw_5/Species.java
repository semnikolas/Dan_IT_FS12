package java_core_hw_5;

public enum Species {

    CAT("Cat"),
    DOG("Dog"),
    PARROT("Parrot"),
    SNAKE("Snake"),
    MOUSE("Mouse"),
    RAT("Rat");

    private final String title;

    Species(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

