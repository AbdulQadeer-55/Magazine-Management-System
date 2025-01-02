package editing;

public class Story {
    private final String title;

    public Story(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "[Title: " + title + "]";
    }
}
