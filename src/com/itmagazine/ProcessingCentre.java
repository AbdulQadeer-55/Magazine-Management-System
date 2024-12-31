package com.itmagazine;

import java.util.ArrayList;
import java.util.List;

public class ProcessingCentre {
    private List<Advertisement> advertisements = new ArrayList<>();
    private List<Story> stories = new ArrayList<>();
    private List<Photograph> photographs = new ArrayList<>();
    private List<Journalist> journalists = new ArrayList<>();
    private List<Photographer> photographers = new ArrayList<>();

    public void storeAdvertisement(Advertisement advertisement) {
        advertisements.add(advertisement);
    }

    public void storeStory(Story story) {
        stories.add(story);
    }

    public void storePhotograph(Photograph photograph) {
        photographs.add(photograph);
    }

    public void addJournalist(Journalist journalist) {
        journalists.add(journalist);
    }

    public Journalist getJournalistByName(String name) {
        for (Journalist journalist : journalists) {
            if (journalist.getName().equalsIgnoreCase(name)) {
                return journalist;
            }
        }
        return null;
    }

    public void addPhotographer(Photographer photographer) {
        photographers.add(photographer);
    }

    public Photographer getPhotographerByName(String name) {
        for (Photographer photographer : photographers) {
            if (photographer.getName().equalsIgnoreCase(name)) {
                return photographer;
            }
        }
        return null;
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

    public List<Journalist> getJournalists() {
        return journalists;
    }

    public List<Photographer> getPhotographers() {
        return photographers;
    }

    public void setAdvertisements(List<Advertisement> advertisements) {
        this.advertisements = advertisements;
    }

    public void setStories(List<Story> stories) {
        this.stories = stories;
    }

    public void setPhotographs(List<Photograph> photographs) {
        this.photographs = photographs;
    }

    public void setJournalists(List<Journalist> journalists) {
        this.journalists = journalists;
    }

    public void setPhotographers(List<Photographer> photographers) {
        this.photographers = photographers;
    }
}