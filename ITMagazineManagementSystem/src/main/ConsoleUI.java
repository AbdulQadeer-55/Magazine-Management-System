// src/main/ConsoleUI.java
package main;

import java.util.Scanner;

public class ConsoleUI {

    public void printHeader(String title) {
        System.out.println("\033[1;34m" + "\n==== " + title + " ====" + "\033[0m");
    }

    public void printMenu(String[] options) {
        System.out.println("\033[1;36m\nChoose an option:\033[0m");
        for (String option : options) {
            System.out.println("  " + option);
        }
    }

    public int getChoice(Scanner scanner) {
        System.out.print("\033[1;33m\nEnter your choice: \033[0m");
        while (!scanner.hasNextInt()) {
            System.out.print("\033[1;31mInvalid input. Enter a number: \033[0m");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public void printMessage(String message, String color) {
        String colorCode;
        switch (color) {
            case "green" -> colorCode = "\033[1;32m";
            case "red" -> colorCode = "\033[1;31m";
            case "yellow" -> colorCode = "\033[1;33m";
            default -> colorCode = "\033[0m";
        }
        System.out.println(colorCode + message + "\033[0m");
    }
}
