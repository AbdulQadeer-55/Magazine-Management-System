package com.itmagazine;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class ITMagazine {
    private static final String DATA_FILE = "magazine_data.json";

    public static void main(String[] args) {
        MarketingDepartment marketing = new MarketingDepartment();
        AccountsDepartment accounts = new AccountsDepartment();
        ProcessingCentre processing = new ProcessingCentre();
        Editor editor = new Editor("John Doe");

        loadSavedData(marketing, processing);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- IT in the Valley Magazine Management ---");
            System.out.println("1. Add Advertiser");
            System.out.println("2. Add Advertisement");
            System.out.println("3. Add Journalist");
            System.out.println("4. Add Story");
            System.out.println("5. Add Photographer");
            System.out.println("6. Add Photograph");
            System.out.println("7. Generate Magazine Issue");
            System.out.println("8. Save and Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addAdvertiser(marketing, scanner);
                    break;
                case 2:
                    addAdvertisement(marketing, scanner);
                    break;
                case 3:
                    addJournalist(processing, scanner);
                    break;
                case 4:
                    addStory(processing, scanner);
                    break;
                case 5:
                    addPhotographer(processing, scanner);
                    break;
                case 6:
                    addPhotograph(processing, scanner);
                    break;
                case 7:
                    generateMagazineIssue(editor, processing, accounts);
                    break;
                case 8:
                    saveData(marketing, processing);
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void addAdvertiser(MarketingDepartment marketing, Scanner scanner) {
        System.out.print("Enter advertiser name: ");
        String name = scanner.nextLine();
        Advertiser advertiser = new Advertiser(name);
        marketing.addAdvertiser(advertiser);
        System.out.println("Advertiser added.");
    }

    private static void addAdvertisement(MarketingDepartment marketing, Scanner scanner) {
        System.out.print("Enter advertiser name: ");
        String advertiserName = scanner.nextLine();
        Advertiser advertiser = marketing.getAdvertiserByName(advertiserName);

        if (advertiser != null) {
            System.out.print("Enter advertisement content: ");
            String content = scanner.nextLine();
            System.out.print("Enter advertisement size: ");
            String size = scanner.nextLine();
            System.out.print("Enter advertisement position: ");
            String position = scanner.nextLine();

            Advertisement advertisement = new Advertisement(content, size, position, advertiser);
            advertiser.addAdvertisement(advertisement);
            System.out.println("Advertisement added.");
        } else {
            System.out.println("Advertiser not found.");
        }
    }

    private static void addJournalist(ProcessingCentre processing, Scanner scanner) {
        System.out.print("Enter journalist name: ");
        String name = scanner.nextLine();
        Journalist journalist = new Journalist(name);
        processing.addJournalist(journalist);
        System.out.println("Journalist added.");
    }

    private static void addStory(ProcessingCentre processing, Scanner scanner) {
        System.out.print("Enter journalist name: ");
        String journalistName = scanner.nextLine();
        Journalist journalist = processing.getJournalistByName(journalistName);

        if (journalist != null) {
            System.out.print("Enter story title: ");
            String title = scanner.nextLine();
            System.out.print("Enter story content: ");
            String content = scanner.nextLine();

            Story story = new Story(title, content, journalist);
            journalist.submitStory(story);
            processing.storeStory(story);
            System.out.println("Story added.");
        } else {
            System.out.println("Journalist not found.");
        }
    }

    private static void addPhotographer(ProcessingCentre processing, Scanner scanner) {
        System.out.print("Enter photographer name: ");
        String name = scanner.nextLine();
        Photographer photographer = new Photographer(name);
        processing.addPhotographer(photographer);
        System.out.println("Photographer added.");
    }

    private static void addPhotograph(ProcessingCentre processing, Scanner scanner) {
        System.out.print("Enter photographer name: ");
        String photographerName = scanner.nextLine();
        Photographer photographer = processing.getPhotographerByName(photographerName);

        if (photographer != null) {
            System.out.print("Enter photograph description: ");
            String description = scanner.nextLine();

            Photograph photograph = new Photograph(description, photographer);
            photographer.submitPhotograph(photograph);
            processing.storePhotograph(photograph);
            System.out.println("Photograph added.");
        } else {
            System.out.println("Photographer not found.");
        }
    }

    private static void generateMagazineIssue(Editor editor, ProcessingCentre processing, AccountsDepartment accounts) {
        System.out.print("Enter issue date (e.g., December 2024): ");
        Scanner scanner = new Scanner(System.in);
        String issueDate = scanner.nextLine();

        MagazineIssue issue = new MagazineIssue(issueDate);
        editor.assembleMagazineIssue(issue, processing.getStories(), processing.getAdvertisements(), processing.getPhotographs());

        for (Story story : issue.getStories()) {
            accounts.sendPayment(story.getJournalist().getName(), 500.0); // Example payment amount
        }

        for (Photograph photograph : issue.getPhotographs()) {
            accounts.sendPayment(photograph.getPhotographer().getName(), 300.0); // Example payment amount
        }

        for (Advertisement advertisement : issue.getAdvertisements()) {
            accounts.invoiceAdvertiser(advertisement.getAdvertiser(), 1000.0); // Example invoice amount
        }

        System.out.println("\nMagazine Issue Date: " + issue.getIssueDate());
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

    private static void loadSavedData(MarketingDepartment marketing, ProcessingCentre processing) {
        try (Reader reader = new FileReader(DATA_FILE)) {
            Gson gson = new Gson();
            Type dataType = new TypeToken<Map<String, Object>>() {}.getType();
            Map<String, Object> data = gson.fromJson(reader, dataType);

            if (data != null) {
                List<Advertiser> advertisers = gson.fromJson(gson.toJson(data.get("advertisers")), new TypeToken<List<Advertiser>>() {}.getType());
                List<Journalist> journalists = gson.fromJson(gson.toJson(data.get("journalists")), new TypeToken<List<Journalist>>() {}.getType());
                List<Photographer> photographers = gson.fromJson(gson.toJson(data.get("photographers")), new TypeToken<List<Photographer>>() {}.getType());
                List<Story> stories = gson.fromJson(gson.toJson(data.get("stories")), new TypeToken<List<Story>>() {}.getType());
                List<Advertisement> advertisements = gson.fromJson(gson.toJson(data.get("advertisements")), new TypeToken<List<Advertisement>>() {}.getType());
                List<Photograph> photographs = gson.fromJson(gson.toJson(data.get("photographs")), new TypeToken<List<Photograph>>() {}.getType());

                marketing.setAdvertisers(advertisers);
                processing.setJournalists(journalists);
                processing.setPhotographers(photographers);
                processing.setStories(stories);
                processing.setAdvertisements(advertisements);
                processing.setPhotographs(photographs);
            }
        } catch (IOException e) {
            System.out.println("No saved data found.");
        }
    }

    private static void saveData(MarketingDepartment marketing, ProcessingCentre processing) {
        Map<String, Object> data = new HashMap<>();
        data.put("advertisers", marketing.getAdvertisers());
        data.put("journalists", processing.getJournalists());
        data.put("photographers", processing.getPhotographers());
        data.put("stories", processing.getStories());
        data.put("advertisements", processing.getAdvertisements());
        data.put("photographs", processing.getPhotographs());

        try (Writer writer = new FileWriter(DATA_FILE)) {
            Gson gson = new Gson();
            gson.toJson(data, writer);
        } catch (IOException e) {
            System.out.println("Error saving data.");
        }
    }
}