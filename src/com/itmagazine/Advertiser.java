package com.itmagazine;

import java.util.ArrayList;
import java.util.List;

public class Advertiser {
    private String name;
    private List<Advertisement> advertisements;

    public Advertiser(String name) {
        this.name = name;
        this.advertisements = new ArrayList<>();
    }

    public void addAdvertisement(Advertisement advertisement) {
        advertisements.add(advertisement);
    }

    public List<Advertisement> getAdvertisements() {
        return advertisements;
    }

    public String getName() {
        return name;
    }
}