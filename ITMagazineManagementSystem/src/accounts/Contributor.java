package accounts;

public abstract class Contributor {
    private final String name;
    private final String email;

    public Contributor(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
