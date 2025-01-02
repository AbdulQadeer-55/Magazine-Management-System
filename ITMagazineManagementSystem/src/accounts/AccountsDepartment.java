package accounts;

import main.ConsoleUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountsDepartment {
    private final List<Invoice> invoices;

    public AccountsDepartment() {
        this.invoices = new ArrayList<>();
    }

    // Method to manage payments and invoices
    public void managePayments(Scanner scanner, ConsoleUI consoleUI) {
        consoleUI.printHeader("MANAGE PAYMENTS");
        consoleUI.printMenu(new String[]{
                "1. Create Invoice",
                "2. View Invoices",
                "3. Go Back"
        });

        int choice = consoleUI.getChoice(scanner);

        switch (choice) {
            case 1 -> createInvoice(scanner, consoleUI);
            case 2 -> viewInvoices(consoleUI);
            case 3 -> consoleUI.printMessage("Returning to the main menu.", "yellow");
            default -> consoleUI.printMessage("Invalid option.", "red");
        }
    }

    // Method to create an invoice
    private void createInvoice(Scanner scanner, ConsoleUI consoleUI) {
        consoleUI.printMessage("Enter contributor's name:", "yellow");
        String contributorName = scanner.next();
        consoleUI.printMessage("Enter amount to invoice:", "yellow");
        double amount = scanner.nextDouble();
        consoleUI.printMessage("Enter description for the invoice:", "yellow");
        scanner.nextLine(); // Consume newline
        String description = scanner.nextLine();

        Invoice invoice = new Invoice(contributorName, amount, description);
        invoices.add(invoice);

        consoleUI.printMessage("Invoice created successfully!", "green");
    }

    // Method to view all invoices
    private void viewInvoices(ConsoleUI consoleUI) {
        consoleUI.printHeader("VIEW INVOICES");

        if (invoices.isEmpty()) {
            consoleUI.printMessage("No invoices available.", "yellow");
            return;
        }

        for (Invoice invoice : invoices) {
            System.out.println(invoice);
        }
    }
}
