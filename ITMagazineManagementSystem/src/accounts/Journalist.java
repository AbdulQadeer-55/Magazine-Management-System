package accounts;

public class Journalist extends Contributor {
    private final double ratePerStory;

    public Journalist(String name, String email, double ratePerStory) {
        super(name, email);
        this.ratePerStory = ratePerStory;
    }

    @Override
    public double getPaymentAmount() {
        return ratePerStory;
    }
}
