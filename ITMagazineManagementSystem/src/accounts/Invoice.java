package accounts;

public class Invoice {
    private final String advertiser;
    private final double amount;

    public Invoice(String advertiser, double amount) {
        this.advertiser = advertiser;
        this.amount = amount;
    }

    public String getAdvertiser() {
        return advertiser;
    }

    public double getAmount() {
        return amount;
    }
}
