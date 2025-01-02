// src/main/Main.java
package main;

import accounts.AccountsDepartment;
import editing.Editor;
import marketing.MarketingDepartment;
import processing.ArchiveManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ConsoleUI consoleUI = new ConsoleUI();
        MarketingDepartment marketing = new MarketingDepartment();
        Editor editor = new Editor();
        AccountsDepartment accounts = new AccountsDepartment();
        ArchiveManager archiveManager = new ArchiveManager();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            consoleUI.printHeader("IT IN THE VALLEY MAGAZINE MANAGEMENT SYSTEM");
            consoleUI.printMenu(new String[]{
                    "1. Manage Advertisements",
                    "2. Manage Stories and Photographs",
                    "3. Manage Payments",
                    "4. Archive Unused Content",
                    "5. Exit"
            });

            int choice = consoleUI.getChoice(scanner);

            switch (choice) {
                case 1 -> marketing.manageAdvertisements(scanner, consoleUI);
                case 2 -> editor.manageContent(scanner, consoleUI);
                case 3 -> accounts.managePayments(scanner, consoleUI);
                case 4 -> archiveManager.archiveContent(scanner, consoleUI);
                case 5 -> {
                    consoleUI.printMessage("Thank you for using the system. Goodbye!", "green");
                    return;
                }
                default -> consoleUI.printMessage("Invalid option. Please try again.", "red");
            }
        }
    }
}