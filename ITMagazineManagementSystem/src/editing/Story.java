// src/editing/Story.java
package editing;

public class Story {
    private final String title;
    private final String content;

    public Story(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "[Title: " + title + ", Content: " + content + "]";
    }
}