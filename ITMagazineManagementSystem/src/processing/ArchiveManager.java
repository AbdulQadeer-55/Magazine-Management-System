package processing;

import editing.Story;
import editing.Photograph;
import main.ConsoleUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArchiveManager {
    private final List<Story> archivedStories;
    private final List<Photograph> archivedPhotographs;

    public ArchiveManager() {
        this.archivedStories = new ArrayList<>();
        this.archivedPhotographs = new ArrayList<>();
    }

    public void archiveContent(Scanner scanner, ConsoleUI consoleUI) {
        consoleUI.printHeader("ARCHIVE UNUSED CONTENT");
        consoleUI.printMenu(new String[]{
                "1. Archive Stories",
                "2. Archive Photographs",
                "3. View Archived Content",
                "4. Go Back"
        });

        int choice = consoleUI.getChoice(scanner);

        switch (choice) {
            case 1 -> archiveStories(scanner, consoleUI);
            case 2 -> archivePhotographs(scanner, consoleUI);
            case 3 -> viewArchivedContent(consoleUI);
            case 4 -> consoleUI.printMessage("Returning to the main menu.", "yellow");
            default -> consoleUI.printMessage("Invalid option.", "red");
        }
    }

    private void archiveStories(Scanner scanner, ConsoleUI consoleUI) {
        consoleUI.printMessage("Enter story title to archive:", "yellow");
        String title = scanner.next();

        Story story = new Story(title, "Archived Content");
        archivedStories.add(story);
        consoleUI.printMessage("Story archived successfully.", "green");
    }

    private void archivePhotographs(Scanner scanner, ConsoleUI consoleUI) {
        consoleUI.printMessage("Enter photograph caption to archive:", "yellow");
        String caption = scanner.next();

        Photograph photograph = new Photograph(caption);
        archivedPhotographs.add(photograph);
        consoleUI.printMessage("Photograph archived successfully.", "green");
    }

    private void viewArchivedContent(ConsoleUI consoleUI) {
        consoleUI.printHeader("ARCHIVED CONTENT");
        if (archivedStories.isEmpty() && archivedPhotographs.isEmpty()) {
            consoleUI.printMessage("No archived content available.", "yellow");
            return;
        }

        System.out.println("Archived Stories:");
        for (Story story : archivedStories) {
            System.out.println(story);
        }

        System.out.println("Archived Photographs:");
        for (Photograph photo : archivedPhotographs) {
            System.out.println(photo);
        }
    }
}
