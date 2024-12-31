package com.itmagazine;

import java.util.ArrayList;
import java.util.List;

public class MagazineIssue {
    private String issueDate;
    private List<Story> stories;
    private List<Advertisement> advertisements;
    private List<Photograph> photographs;

    public MagazineIssue(String issueDate) {
        this.issueDate = issueDate;
        this.stories = new ArrayList<>();
        this.advertisements = new ArrayList<>();
        this.photographs = new ArrayList<>();
    }

    public void addStory(Story story) {
        stories.add(story);
    }

    public void addAdvertisement(Advertisement advertisement) {
        advertisements.add(advertisement);
    }

    public void addPhotograph(Photograph photograph) {
        photographs.add(photograph);
    }

    public String getIssueDate() {
        return issueDate;
    }

    public List<Story> getStories() {
        return stories;
    }

    public List<Advertisement> getAdvertisements() {
        return advertisements;
    }

    public List<Photograph> getPhotographs() {
        return photographs;
    }
}