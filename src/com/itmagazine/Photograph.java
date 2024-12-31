package com.itmagazine;

public class Photograph {
    private String description;
    private Photographer photographer;

    public Photograph(String description, Photographer photographer) {
        this.description = description;
        this.photographer = photographer;
    }

    public String getDescription() {
        return description;
    }

    public Photographer getPhotographer() {
        return photographer;
    }
}