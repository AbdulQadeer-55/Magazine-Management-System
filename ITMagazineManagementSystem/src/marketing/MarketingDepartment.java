// src/marketing/MarketingDepartment.java
package marketing;

import main.ConsoleUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MarketingDepartment {
    private final List<Advertisement> advertisements;

    public MarketingDepartment() {
        this.advertisements = new ArrayList<>();
    }

    public void manageAdvertisements(Scanner scanner, ConsoleUI consoleUI) {
        consoleUI.printHeader("MANAGE ADVERTISEMENTS");
        consoleUI.printMenu(new String[]{
                "1. Add Advertisement",
                "2. View Advertisements",
                "3. Go Back"
        });

        int choice = consoleUI.getChoice(scanner);

        switch (choice) {
            case 1 -> addAdvertisement(scanner, consoleUI);
            case 2 -> viewAdvertisements(consoleUI);
            case 3 -> consoleUI.printMessage("Returning to the main menu.", "yellow");
            default -> consoleUI.printMessage("Invalid option.", "red");
        }
    }

    private void addAdvertisement(Scanner scanner, ConsoleUI consoleUI) {
        consoleUI.printMessage("Enter advertisement details:", "yellow");
        System.out.print("Title: ");
        String title = scanner.next();
        System.out.print("Size: ");
        String size = scanner.next();
        System.out.print("Month: ");
        String month = scanner.next();

        Advertisement ad = new Advertisement(title, size, month);
        advertisements.add(ad);
        consoleUI.printMessage("Advertisement added successfully.", "green");
    }

    private void viewAdvertisements(ConsoleUI consoleUI) {
        consoleUI.printHeader("ALL ADVERTISEMENTS");
        if (advertisements.isEmpty()) {
            consoleUI.printMessage("No advertisements found.", "yellow");
            return;
        }
        for (Advertisement ad : advertisements) {
            System.out.println(ad);
        }
    }
}
