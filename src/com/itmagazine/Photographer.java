package com.itmagazine;

import java.util.ArrayList;
import java.util.List;

public class Photographer {
    private String name;
    private List<Photograph> photographs;

    public Photographer(String name) {
        this.name = name;
        this.photographs = new ArrayList<>();
    }

    public void submitPhotograph(Photograph photograph) {
        photographs.add(photograph);
    }

    public List<Photograph> getPhotographs() {
        return photographs;
    }

    public String getName() {
        return name;
    }
}