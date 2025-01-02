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

    public void manageArchive(Scanner scanner, ConsoleUI consoleUI) {
        consoleUI.printHeader("Archive Management");
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
            default -> consoleUI.printMessage("Invalid option, please try again.", "red");
        }
    }

    private void archiveStories(Scanner scanner, ConsoleUI consoleUI) {
        consoleUI.printMessage("Enter story title to archive:", "yellow");
        String title = scanner.nextLine();

        Story story = new Story(title);
        archivedStories.add(story);
        consoleUI.printMessage("Story archived successfully.", "green");
    }

    private void archivePhotographs(Scanner scanner, ConsoleUI consoleUI) {
        consoleUI.printMessage("Enter photograph caption to archive:", "yellow");
        String caption = scanner.nextLine();

        Photograph photograph = new Photograph(caption);
        archivedPhotographs.add(photograph);
        consoleUI.printMessage("Photograph archived successfully.", "green");
    }

    public void viewArchivedContent(ConsoleUI consoleUI) {
        consoleUI.printHeader("View Archived Content");
        if (archivedStories.isEmpty() && archivedPhotographs.isEmpty()) {
            consoleUI.printMessage("No archived content available.", "yellow");
        } else {
            consoleUI.printMessage("Archived Stories:", "yellow");
            archivedStories.forEach(story -> consoleUI.printMessage(story.toString(), "green"));

            consoleUI.printMessage("Archived Photographs:", "yellow");
            archivedPhotographs.forEach(photograph -> consoleUI.printMessage(photograph.toString(), "green"));
        }
    }
}
