package com.itmagazine;

import java.util.ArrayList;
import java.util.List;

public class Journalist {
    private String name;
    private List<Story> stories;

    public Journalist(String name) {
        this.name = name;
        this.stories = new ArrayList<>();
    }

    public void submitStory(Story story) {
        stories.add(story);
    }

    public List<Story> getStories() {
        return stories;
    }

    public String getName() {
        return name;
    }
}