package modul;

public enum Kornsort {
    STAIRWAY("Lars mark"),
    EVERGREEN("Carstens mark"),
    IRINA("Lars mark");

    private final String description;

    Kornsort(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}