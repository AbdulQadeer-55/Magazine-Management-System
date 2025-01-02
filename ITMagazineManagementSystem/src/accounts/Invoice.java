package accounts;

public class Invoice {

    private String contributorName;

    private double amount;

    private String description;

    private boolean paid;



    public Invoice(String contributorName, double amount, String description) {

        this.contributorName = contributorName;

        this.amount = amount;

        this.description = description;

        this.paid = false;

    }



    // Getters and setters

    public String getContributorName() {

        return contributorName;

    }



    public double getAmount() {

        return amount;

    }



    public String getDescription() {

        return description;

    }



    public boolean isPaid() {

        return paid;

    }



    public void setPaid(boolean paid) {

        this.paid = paid;

    }

}
