package com.itmagazine;

import java.util.List;

public class Editor {
    private String name;

    public Editor(String name) {
        this.name = name;
    }

    public void editAdvertisement(Advertisement advertisement) {
        // Edit advertisement logic
    }

    public void assembleMagazineIssue(MagazineIssue issue, List<Story> stories, List<Advertisement> advertisements, List<Photograph> photographs) {
        for (Story story : stories) {
            issue.addStory(story);
        }
        for (Advertisement advertisement : advertisements) {
            issue.addAdvertisement(advertisement);
        }
        for (Photograph photograph : photographs) {
            issue.addPhotograph(photograph);
        }
    }
}