package accounts;

public class Invoice {
    private final String advertiserName;
    private final double amount;

    public Invoice(String advertiserName, double amount) {
        this.advertiserName = advertiserName;
        this.amount = amount;
    }

    public String getAdvertiserName() {
        return advertiserName;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Invoice for " + advertiserName + ": $" + amount;
    }
}
