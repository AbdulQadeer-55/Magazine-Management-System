package marketing;

import main.ConsoleUI;

import java.util.List;
import java.util.Scanner;

public class MarketingDepartment {
    private final List<Advertisement> advertisements;

    public MarketingDepartment(List<Advertisement> advertisements) {
        this.advertisements = advertisements;
    }

    public void manageAdvertisements(Scanner scanner, ConsoleUI consoleUI) {
        consoleUI.printHeader("Marketing Department");
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
            default -> consoleUI.printMessage("Invalid option, please try again.", "red");
        }
    }

    public void addAdvertisement(Scanner scanner, ConsoleUI consoleUI) {
        consoleUI.printMessage("Enter advertiser name:", "yellow");
        String advertiser = scanner.nextLine();
        consoleUI.printMessage("Enter amount for advertisement:", "yellow");
        double amount = scanner.nextDouble();

        Advertisement advertisement = new Advertisement(advertiser, amount);
        advertisements.add(advertisement);
        consoleUI.printMessage("Advertisement added successfully.", "green");
    }

    public void viewAdvertisements(ConsoleUI consoleUI) {
        consoleUI.printHeader("View Advertisements");
        if (advertisements.isEmpty()) {
            consoleUI.printMessage("No advertisements available.", "yellow");
        } else {
            advertisements.forEach(advertisement -> {
                consoleUI.printMessage("Advertiser: " + advertisement.getAdvertiser() + ", Amount: $" + advertisement.getAmount(), "green");
            });
        }
    }
}
