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
        MarketingDepartment marketingDepartment = new MarketingDepartment(accountsDepartment.getAdvertisements());
        ArchiveManager archiveManager = new ArchiveManager();
        Editor editor = new Editor();

        // Main menu loop
        while (true) {
            consoleUI.printHeader("IT MAGAZINE MANAGEMENT SYSTEM");
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
                case 2 -> manageMarketing(scanner, consoleUI, marketingDepartment);
                case 3 -> manageEditing(scanner, consoleUI, editor);
                case 4 -> manageArchive(scanner, consoleUI, archiveManager);
                case 5 -> {
                    consoleUI.printMessage("Exiting the system. Goodbye!", "yellow");
                    scanner.close();
                    return;
                }
                default -> consoleUI.printMessage("Invalid option, please try again.", "red");
            }
        }
    }

    private static void manageAccounts(Scanner scanner, ConsoleUI consoleUI, AccountsDepartment accountsDepartment) {
        while (true) {
            consoleUI.printHeader("ACCOUNTS DEPARTMENT");
            consoleUI.printMenu(new String[]{
                    "1. View Invoices",
                    "2. Create Invoice",
                    "3. Pay Contributors",
                    "4. Go Back"
            });

            int choice = consoleUI.getChoice(scanner);

            switch (choice) {
                case 1 -> accountsDepartment.viewInvoices(consoleUI);
                case 2 -> accountsDepartment.createInvoice(scanner, consoleUI);
                case 3 -> accountsDepartment.payContributors(consoleUI);
                case 4 -> {
                    consoleUI.printMessage("Returning to the main menu.", "yellow");
                    return;
                }
                default -> consoleUI.printMessage("Invalid option, please try again.", "red");
            }
        }
    }

    private static void manageMarketing(Scanner scanner, ConsoleUI consoleUI, MarketingDepartment marketingDepartment) {
        while (true) {
            consoleUI.printHeader("MARKETING DEPARTMENT");
            consoleUI.printMenu(new String[]{
                    "1. View Advertisements",
                    "2. Add Advertisement",
                    "3. Go Back"
            });

            int choice = consoleUI.getChoice(scanner);

            switch (choice) {
                case 1 -> marketingDepartment.viewAdvertisements(consoleUI);
                case 2 -> marketingDepartment.addAdvertisement(scanner, consoleUI);
                case 3 -> {
                    consoleUI.printMessage("Returning to the main menu.", "yellow");
                    return;
                }
                default -> consoleUI.printMessage("Invalid option, please try again.", "red");
            }
        }
    }

    private static void manageEditing(Scanner scanner, ConsoleUI consoleUI, Editor editor) {
        while (true) {
            consoleUI.printHeader("EDITING DEPARTMENT");
            consoleUI.printMenu(new String[]{
                    "1. View Stories",
                    "2. Add Story",
                    "3. Go Back"
            });

            int choice = consoleUI.getChoice(scanner);

            switch (choice) {
                case 1 -> editor.viewStories(consoleUI);
                case 2 -> editor.addStory(scanner, consoleUI);
                case 3 -> {
                    consoleUI.printMessage("Returning to the main menu.", "yellow");
                    return;
                }
                default -> consoleUI.printMessage("Invalid option, please try again.", "red");
            }
        }
    }

    private static void manageArchive(Scanner scanner, ConsoleUI consoleUI, ArchiveManager archiveManager) {
        while (true) {
            consoleUI.printHeader("ARCHIVE MANAGEMENT");
            consoleUI.printMenu(new String[]{
                    "1. Archive Content",
                    "2. View Archived Content",
                    "3. Go Back"
            });

            int choice = consoleUI.getChoice(scanner);

            switch (choice) {
                case 1 -> archiveManager.archiveContent(scanner, consoleUI);
                case 2 -> archiveManager.viewArchivedContent(consoleUI);
                case 3 -> {
                    consoleUI.printMessage("Returning to the main menu.", "yellow");
                    return;
                }
                default -> consoleUI.printMessage("Invalid option, please try again.", "red");
            }
        }
    }
}
