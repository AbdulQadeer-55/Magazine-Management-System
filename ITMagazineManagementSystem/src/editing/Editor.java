package editing;

import main.ConsoleUI;

import java.util.Scanner;

public class Editor {

    public void manageContent(Scanner scanner, ConsoleUI consoleUI) {
        consoleUI.printHeader("EDITOR MANAGEMENT");
        consoleUI.printMenu(new String[]{
                "1. Manage Stories",
                "2. Manage Photographs",
                "3. Go Back"
        });

        int choice = consoleUI.getChoice(scanner);

        switch (choice) {
            case 1 -> manageStories(scanner, consoleUI);
            case 2 -> managePhotographs(scanner, consoleUI);
            case 3 -> consoleUI.printMessage("Returning to the main menu.", "yellow");
            default -> consoleUI.printMessage("Invalid option, please try again.", "red");
        }
    }

    private void manageStories(Scanner scanner, ConsoleUI consoleUI) {
        consoleUI.printMessage("Enter story title:", "yellow");
        String title = scanner.nextLine();
        Story story = new Story(title);
        consoleUI.printMessage("Story \"" + story.getTitle() + "\" created successfully.", "green");
    }

    private void managePhotographs(Scanner scanner, ConsoleUI consoleUI) {
        consoleUI.printMessage("Enter photograph caption:", "yellow");
        String caption = scanner.nextLine();
        Photograph photograph = new Photograph(caption);
        consoleUI.printMessage("Photograph \"" + photograph.getCaption() + "\" added successfully.", "green");
    }
}
