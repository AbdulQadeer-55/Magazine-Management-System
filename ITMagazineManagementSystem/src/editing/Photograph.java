package editing;

public class Photograph {
    private final String caption;

    public Photograph(String caption) {
        this.caption = caption;
    }

    @Override
    public String toString() {
        return "[Caption: " + caption + "]";
    }
}
