package accounts;

public class Invoice {
    private final String contributorName;
    private final double amount;
    private final String description;

    public Invoice(String contributorName, double amount, String description) {
        this.contributorName = contributorName;
        this.amount = amount;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Invoice [Contributor: " + contributorName + ", Amount: $" + amount + ", Description: " + description + "]";
    }
}
