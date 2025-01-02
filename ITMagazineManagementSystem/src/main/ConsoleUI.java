package main;

import java.util.Scanner;

public class ConsoleUI {

    public int getChoice(Scanner scanner) {

        System.out.print("Enter your choice: ");

        while (!scanner.hasNextInt()) {

            System.out.print("Invalid input. Please enter a number: ");

            scanner.next();

        }

        return scanner.nextInt();

    }

    public void printHeader(String header) {
        System.out.println("\n" + header + "\n" + "-".repeat(header.length()));
    }

    public void printMenu(String[] options) {
        for (String option : options) {
            System.out.println(option);
        }
    }

    // public int getChoice(Scanner scanner) {
    //     int choice = scanner.nextInt();
    //     return choice;
    // }

    public void printMessage(String message, String color) {
        String coloredMessage = switch (color) {
            case "green" -> "\u001B[32m" + message + "\u001B[0m";
            case "yellow" -> "\u001B[33m" + message + "\u001B[0m";
            case "red" -> "\u001B[31m" + message + "\u001B[0m";
            default -> message;
        };
        System.out.println(coloredMessage);
    }
}
