package com.itmagazine;

public class Advertisement {
    private String content;
    private String size;
    private String position;
    private Advertiser advertiser;

    public Advertisement(String content, String size, String position, Advertiser advertiser) {
        this.content = content;
        this.size = size;
        this.position = position;
        this.advertiser = advertiser;
    }

    public String getContent() {
        return content;
    }

    public String getSize() {
        return size;
    }

    public String getPosition() {
        return position;
    }

    public Advertiser getAdvertiser() {
        return advertiser;
    }
}