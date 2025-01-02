package editing;

import main.ConsoleUI;

import java.util.Scanner;

public class Editor {
    public void manageContent(Scanner scanner, ConsoleUI consoleUI) {
        consoleUI.printHeader("MANAGE CONTENT");
        consoleUI.printMenu(new String[]{
                "1. Add New Story",
                "2. Add New Photograph",
                "3. View Stories and Photographs",
                "4. Go Back"
        });

        int choice = consoleUI.getChoice(scanner);

        switch (choice) {
            case 1 -> addNewStory(scanner, consoleUI);
            case 2 -> addNewPhotograph(scanner, consoleUI);
            case 3 -> viewContent(consoleUI);
            case 4 -> consoleUI.printMessage("Returning to the main menu.", "yellow");
            default -> consoleUI.printMessage("Invalid option.", "red");
        }
    }

    private void addNewStory(Scanner scanner, ConsoleUI consoleUI) {
        consoleUI.printMessage("Enter story title:", "yellow");
        String title = scanner.next();
        consoleUI.printMessage("Enter story content:", "yellow");
        String content = scanner.next();
        Story story = new Story(title, content);
        consoleUI.printMessage("New story added: " + story, "green");
    }

    private void addNewPhotograph(Scanner scanner, ConsoleUI consoleUI) {
        consoleUI.printMessage("Enter photograph caption:", "yellow");
        String caption = scanner.next();
        Photograph photograph = new Photograph(caption);
        consoleUI.printMessage("New photograph added: " + photograph, "green");
    }

    private void viewContent(ConsoleUI consoleUI) {
        consoleUI.printHeader("STORIES AND PHOTOGRAPHS");
        // Add logic to display stories and photographs
    }
}
