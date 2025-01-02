package accounts;

public class Photographer extends Contributor {
    private final double ratePerPhotograph;

    public Photographer(String name, String email, double ratePerPhotograph) {
        super(name, email);
        this.ratePerPhotograph = ratePerPhotograph;
    }

    @Override
    public double getPaymentAmount() {
        return ratePerPhotograph;
    }
}
