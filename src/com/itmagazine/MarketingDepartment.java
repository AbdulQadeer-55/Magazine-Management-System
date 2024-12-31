package com.itmagazine;

import java.util.ArrayList;
import java.util.List;

public class MarketingDepartment {
    private List<Advertisement> advertisements;

    public MarketingDepartment() {
        this.advertisements = new ArrayList<>();
    }

    public void receiveAdvertisement(Advertisement advertisement) {
        advertisements.add(advertisement);
    }

    public List<Advertisement> getAdvertisements() {
        return advertisements;
    }
}