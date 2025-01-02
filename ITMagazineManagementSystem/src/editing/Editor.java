// src/editing/Editor.java
package editing;

import main.ConsoleUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Editor {
    private final List<Story> stories;
    private final List<Photograph> photographs;

    public Editor() {
        this.stories = new ArrayList<>();
        this.photographs = new ArrayList<>();
    }

    public void manageContent(Scanner scanner, ConsoleUI consoleUI) {
        consoleUI.printHeader("MANAGE STORIES AND PHOTOGRAPHS");
        consoleUI.printMenu(new String[]{
                "1. Add Story",
                "2. Add Photograph",
                "3. View Content",
                "4. Go Back"
        });

        int choice = consoleUI.getChoice(scanner);

        switch (choice) {
            case 1 -> addStory(scanner, consoleUI);
            case 2 -> addPhotograph(scanner, consoleUI);
            case 3 -> viewContent(consoleUI);
            case 4 -> consoleUI.printMessage("Returning to the main menu.", "yellow");
            default -> consoleUI.printMessage("Invalid option.", "red");
        }
    }

    private void addStory(Scanner scanner, ConsoleUI consoleUI) {
        consoleUI.printMessage("Enter story details:", "yellow");
        System.out.print("Title: ");
        String title = scanner.next();
        System.out.print("Content: ");
        String content = scanner.next();

        stories.add(new Story(title, content));
        consoleUI.printMessage("Story added successfully.", "green");
    }

    private void addPhotograph(Scanner scanner, ConsoleUI consoleUI) {
        consoleUI.printMessage("Enter photograph details:", "yellow");
        System.out.print("Caption: ");
        String caption = scanner.next();

        photographs.add(new Photograph(caption));
        consoleUI.printMessage("Photograph added successfully.", "green");
    }

    private void viewContent(ConsoleUI consoleUI) {
        consoleUI.printHeader("ALL CONTENT");
        if (stories.isEmpty() && photographs.isEmpty()) {
            consoleUI.printMessage("No content available.", "yellow");
            return;
        }

        System.out.println("Stories:");
        for (Story story : stories) {
            System.out.println(story);
        }

        System.out.println("Photographs:");
        for (Photograph photo : photographs) {
            System.out.println(photo);
        }
    }
}
