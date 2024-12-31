package com.itmagazine;

import java.util.ArrayList;
import java.util.List;

public class ProcessingCentre {
    private List<Advertisement> advertisements;
    private List<Story> stories;
    private List<Photograph> photographs;

    public ProcessingCentre() {
        this.advertisements = new ArrayList<>();
        this.stories = new ArrayList<>();
        this.photographs = new ArrayList<>();
    }

    public void storeAdvertisement(Advertisement advertisement) {
        advertisements.add(advertisement);
    }

    public void storeStory(Story story) {
        stories.add(story);
    }

    public void storePhotograph(Photograph photograph) {
        photographs.add(photograph);
    }

    public List<Advertisement> getAdvertisements() {
        return advertisements;
    }

    public List<Story> getStories() {
        return stories;
    }

    public List<Photograph> getPhotographs() {
        return photographs;
    }
}