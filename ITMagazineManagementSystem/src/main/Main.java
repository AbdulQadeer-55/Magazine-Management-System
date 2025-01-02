package main;

import accounts.AccountsDepartment;
import editing.Editor;
import marketing.MarketingDepartment;
import processing.ArchiveManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initialize necessary objects
        ConsoleUI consoleUI = new ConsoleUI();
        Scanner scanner = new Scanner(System.in);

        // Initialize departments and managers
        AccountsDepartment accountsDepartment = new AccountsDepartment();
        final MarketingDepartment marketingDepartment = new MarketingDepartment("defaultArgument"); // Replace with appropriate arguments
        ArchiveManager archiveManager = new ArchiveManager();
        Editor editor = new Editor();

        // Main menu loop
        while (true) {
            consoleUI.printHeader("IT Magazine Management System");
            consoleUI.printMenu(new String[]{
                    "1. Manage Accounts Department",
                    "2. Manage Marketing Department",
                    "3. Manage Editing Department",
                    "4. Manage Archive",
                    "5. Exit"
            });

            int choice = consoleUI.getChoice(scanner);

            switch (choice) {
                case 1 -> manageAccounts(scanner, consoleUI, accountsDepartment);
                case 2 -> marketingDepartment.manageAdvertisements(scanner, consoleUI);
                case 3 -> editor.manageContent(scanner, consoleUI);
                case 4 -> archiveManager.manageArchive(scanner, consoleUI);
                case 5 -> {
                    consoleUI.printMessage("Exiting the system. Goodbye!", "yellow");
                    return; // Exit the application
                }
                default -> consoleUI.printMessage("Invalid option, please try again.", "red");
            }
        }
    }

    private static void manageAccounts(Scanner scanner, ConsoleUI consoleUI, AccountsDepartment accountsDepartment) {
        consoleUI.printHeader("ACCOUNTS DEPARTMENT");
        consoleUI.printMenu(new String[]{
                "1. View Invoices",
                "2. Pay Contributors",
                "3. Go Back"
        });

        int choice = consoleUI.getChoice(scanner);

        switch (choice) {
            case 1 -> accountsDepartment.viewInvoices(consoleUI);
            case 2 -> accountsDepartment.payContributors(consoleUI);
            case 3 -> consoleUI.printMessage("Returning to the main menu.", "yellow");
            default -> consoleUI.printMessage("Invalid option, please try again.", "red");
        }
    }
}
