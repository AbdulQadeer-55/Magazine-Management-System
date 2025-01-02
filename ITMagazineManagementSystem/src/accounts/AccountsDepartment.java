package accounts;

import main.ConsoleUI;
import marketing.Advertisement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountsDepartment {
    private final List<Invoice> invoices;
    private final List<Advertisement> advertisements;

    public AccountsDepartment() {
        this.invoices = new ArrayList<>();
        this.advertisements = new ArrayList<>();
    }

    // Method to manage payments and invoices
    public void managePayments(Scanner scanner, ConsoleUI consoleUI) {
        consoleUI.printHeader("MANAGE PAYMENTS");
        consoleUI.printMenu(new String[]{
                "1. Create Invoice",
                "2. View Invoices",
                "3. Pay Contributors",
                "4. Go Back"
        });

        int choice = consoleUI.getChoice(scanner);

        switch (choice) {
            case 1 -> createInvoice(scanner, consoleUI);
            case 2 -> viewInvoices(consoleUI);
            case 3 -> payContributors(consoleUI);
            case 4 -> consoleUI.printMessage("Returning to the main menu.", "yellow");
            default -> consoleUI.printMessage("Invalid option.", "red");
        }
    }

    // Method to create an invoice
    public void createInvoice(Scanner scanner, ConsoleUI consoleUI) {
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
    public void viewInvoices(ConsoleUI consoleUI) {
        consoleUI.printHeader("VIEW INVOICES");

        if (invoices.isEmpty()) {
            consoleUI.printMessage("No invoices available.", "yellow");
            return;
        }

        for (Invoice invoice : invoices) {
            System.out.println(invoice);
        }
    }

    // Method to pay contributors
    public void payContributors(ConsoleUI consoleUI) {
        consoleUI.printHeader("PAY CONTRIBUTORS");

        if (invoices.isEmpty()) {
            consoleUI.printMessage("No contributors to pay.", "yellow");
            return;
        }

        for (Invoice invoice : invoices) {
            consoleUI.printMessage("Processing payment for: " + invoice.getContributorName(), "blue");
            consoleUI.printMessage("Amount: " + invoice.getAmount(), "blue");
            // Logic to process payment (e.g., mark as paid)
            invoice.setPaid(true);
            consoleUI.printMessage("Payment successful for: " + invoice.getContributorName(), "green");
        }

        consoleUI.printMessage("All contributors have been paid.", "green");
    }

    public List<Advertisement> getAdvertisements() {
        return new ArrayList<>(advertisements);
    }

    public void addAdvertisement(Advertisement advertisement) {
        advertisements.add(advertisement);
    }
}
