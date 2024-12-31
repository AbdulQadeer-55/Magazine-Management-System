package com.itmagazine;

import java.util.ArrayList;
import java.util.List;

public class MarketingDepartment {
    private List<Advertiser> advertisers = new ArrayList<>();

    public void addAdvertiser(Advertiser advertiser) {
        advertisers.add(advertiser);
    }

    public Advertiser getAdvertiserByName(String name) {
        for (Advertiser advertiser : advertisers) {
            if (advertiser.getName().equalsIgnoreCase(name)) {
                return advertiser;
            }
        }
        return null;
    }

    public List<Advertiser> getAdvertisers() {
        return advertisers;
    }

    public void setAdvertisers(List<Advertiser> advertisers) {
        this.advertisers = advertisers;
    }
}