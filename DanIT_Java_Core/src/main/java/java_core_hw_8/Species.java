package java_core_hw_8;

public enum Species {

    DOMESTICCAT("Cat"),
    DOG("Dog"),
    FISH("Fish"),
    ROBOCAT("Robo Cat"),
    UNKNOWN("Unknown");

    private final String title;

    Species(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

