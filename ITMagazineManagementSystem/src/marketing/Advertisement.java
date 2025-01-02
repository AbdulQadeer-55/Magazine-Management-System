package marketing;

public class Advertisement {
    private final String advertiser;
    private final double amount;

    public Advertisement(String advertiser, double amount) {
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
