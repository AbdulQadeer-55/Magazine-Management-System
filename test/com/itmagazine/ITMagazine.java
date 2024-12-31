package com.itmagazine;

import java.util.List;

public class ITMagazine {
    public static void main(String[] args) {
        // Create departments
        MarketingDepartment marketing = new MarketingDepartment();
        AccountsDepartment accounts = new AccountsDepartment();
        ProcessingCentre processing = new ProcessingCentre();
        Editor editor = new Editor("John Doe");

        // Create advertisers
        Advertiser advertiser1 = new Advertiser("TechCorp");
        Advertiser advertiser2 = new Advertiser("GadgetWorld");

        // Create advertisements
        Advertisement ad1 = new Advertisement("TechCorp Ad Content", "Full Page", "Front Page", advertiser1);
        Advertisement ad2 = new Advertisement("GadgetWorld Ad Content", "Half Page", "Back Page", advertiser2);

        // Receive and store advertisements
        marketing.receiveAdvertisement(ad1);
        marketing.receiveAdvertisement(ad2);

        // Store advertisements in processing centre
        processing.storeAdvertisement(ad1);
        processing.storeAdvertisement(ad2);

        // Create journalists and stories
        Journalist journalist1 = new Journalist("Alice Johnson");
        Story story1 = new Story("Tech Innovations", "Content of Tech Innovations", journalist1);
        journalist1.submitStory(story1);
        processing.storeStory(story1);

        // Create photographers and photographs
        Photographer photographer1 = new Photographer("Bob Smith");
        Photograph photo1 = new Photograph("Tech Conference Photo", photographer1);
        photographer1.submitPhotograph(photo1);
        processing.storePhotograph(photo1);

        // Create a magazine issue
        MagazineIssue issue = new MagazineIssue("December 2024");
        editor.assembleMagazineIssue(issue, processing.getStories(), processing.getAdvertisements(), processing.getPhotographs());

        // Send payments and invoices
        accounts.sendPayment(journalist1.getName(), 500.0);
        accounts.sendPayment(photographer1.getName(), 300.0);
        accounts.invoiceAdvertiser(advertiser1, 1500.0);
        accounts.invoiceAdvertiser(advertiser2, 1000.0);

        // Output magazine issue details
        System.out.println("Magazine Issue Date: " + issue.getIssueDate());
        System.out.println("Stories in the Issue:");
        for (Story story : issue.getStories()) {
            System.out.println("- " + story.getTitle() + " by " + story.getJournalist().getName());
        }
        System.out.println("Advertisements in the Issue:");
        for (Advertisement advertisement : issue.getAdvertisements()) {
            System.out.println("- " + advertisement.getContent() + " by " + advertisement.getAdvertiser().getName());
        }
        System.out.println("Photographs in the Issue:");
        for (Photograph photograph : issue.getPhotographs()) {
            System.out.println("- " + photograph.getDescription() + " by " + photograph.getPhotographer().getName());
        }
    }
}