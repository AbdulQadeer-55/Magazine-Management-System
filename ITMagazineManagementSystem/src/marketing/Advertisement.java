// src/marketing/Advertisement.java
package marketing;

public class Advertisement {
    private final String title;
    private final String size;
    private final String month;

    public Advertisement(String title, String size, String month) {
        this.title = title;
        this.size = size;
        this.month = month;
    }

    @Override
    public String toString() {
        return "[Title: " + title + ", Size: " + size + ", Month: " + month + "]";
    }
}