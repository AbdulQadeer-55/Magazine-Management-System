package main;

import java.util.Scanner;

public class ConsoleUI {

    public void printHeader(String header) {
        System.out.println("\n====== " + header + " ======");
    }

    public void printMenu(String[] options) {
        for (String option : options) {
            System.out.println(option);
        }
    }

    public int getChoice(Scanner scanner) {
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    public void printMessage(String message, String color) {
        String coloredMessage = switch (color) {
            case "red" -> "\033[0;31m" + message + "\033[0m";
            case "green" -> "\033[0;32m" + message + "\033[0m";
            case "yellow" -> "\033[0;33m" + message + "\033[0m";
            default -> message;
        };
        System.out.println(coloredMessage);
    }
}
