package accounts;

import main.ConsoleUI;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AccountsDepartment {
    private final Map<String, Double> paymentsDue;
    private final Map<String, Double> advertiserInvoices;

    public AccountsDepartment() {
        this.paymentsDue = new HashMap<>();
        this.advertiserInvoices = new HashMap<>();
    }

    public void managePayments(Scanner scanner, ConsoleUI consoleUI) {
        consoleUI.printHeader("MANAGE PAYMENTS");
        consoleUI.printMenu(new String[]{
                "1. Process Payments to Contributors",
                "2. Invoice Advertisers",
                "3. View Outstanding Payments",
                "4. Go Back"
        });

        int choice = consoleUI.getChoice(scanner);

        switch (choice) {
            case 1 -> processContributorPayments(consoleUI);
            case 2 -> invoiceAdvertisers(scanner, consoleUI);
            case 3 -> viewOutstandingPayments(consoleUI);
            case 4 -> consoleUI.printMessage("Returning to the main menu.", "yellow");
            default -> consoleUI.printMessage("Invalid option.", "red");
        }
    }

    private void processContributorPayments(ConsoleUI consoleUI) {
        if (paymentsDue.isEmpty()) {
            consoleUI.printMessage("No payments due to contributors.", "yellow");
            return;
        }

        paymentsDue.forEach((contributor, amount) -> {
            consoleUI.printMessage("Processing payment of $" + amount + " to " + contributor, "green");
        });
        paymentsDue.clear();
    }

    private void invoiceAdvertisers(Scanner scanner, ConsoleUI consoleUI) {
        consoleUI.printMessage("Enter advertiser name:", "yellow");
        String name = scanner.next();
        consoleUI.printMessage("Enter amount to invoice:", "yellow");
        double amount = scanner.nextDouble();

        advertiserInvoices.put(name, amount);
        consoleUI.printMessage("Invoice of $" + amount + " sent to " + name, "green");
    }

    private void viewOutstandingPayments(ConsoleUI consoleUI) {
        consoleUI.printHeader("OUTSTANDING PAYMENTS");
        if (advertiserInvoices.isEmpty()) {
            consoleUI.printMessage("No outstanding payments.", "yellow");
            return;
        }

        advertiserInvoices.forEach((advertiser, amount) -> {
            System.out.println("[Advertiser: " + advertiser + ", Amount Due: $" + amount + "]");
        });
    }
}
