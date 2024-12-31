package com.itmagazine;

public class Story {
    private String title;
    private String content;
    private Journalist journalist;

    public Story(String title, String content, Journalist journalist) {
        this.title = title;
        this.content = content;
        this.journalist = journalist;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Journalist getJournalist() {
        return journalist;
    }
}