package accounts;

import main.ConsoleUI;
import marketing.Advertisement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountsDepartment {
    private final Map<String, Double> paymentsDue;
    private final Map<String, Double> advertiserInvoices;

    public AccountsDepartment() {
        this.paymentsDue = new HashMap<>();
        this.advertiserInvoices = new HashMap<>();
    }

    public List<Advertisement> getAdvertisements() {

        // return the list of advertisements

        return new ArrayList<>();

    }

    public void viewInvoices(ConsoleUI consoleUI) {
        consoleUI.printHeader("Invoices Management");
        if (advertiserInvoices.isEmpty()) {
            consoleUI.printMessage("No invoices available.", "yellow");
        } else {
            advertiserInvoices.forEach((advertiser, amount) -> {
                consoleUI.printMessage("Invoice for " + advertiser + ": $" + amount, "green");
            });
        }
    }

    public void payContributors(ConsoleUI consoleUI) {
        consoleUI.printHeader("Paying Contributors");
        if (paymentsDue.isEmpty()) {
            consoleUI.printMessage("No payments due to contributors.", "yellow");
        } else {
            paymentsDue.forEach((contributor, amount) -> {
                consoleUI.printMessage("Paying " + contributor + ": $" + amount, "green");
            });
            paymentsDue.clear();
            consoleUI.printMessage("All payments have been processed.", "green");
        }
    }

    public void addPayment(String contributor, double amount) {
        paymentsDue.put(contributor, amount);
    }

    public void addInvoice(String advertiser, double amount) {
        advertiserInvoices.put(advertiser, amount);
    }
}
