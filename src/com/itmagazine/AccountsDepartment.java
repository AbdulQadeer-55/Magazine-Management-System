package com.itmagazine;

import java.util.HashMap;
import java.util.Map;

public class AccountsDepartment {
    private Map<String, Double> payments;

    public AccountsDepartment() {
        this.payments = new HashMap<>();
    }

    public void sendPayment(String contributorName, double amount) {
        payments.put(contributorName, amount);
    }

    public void invoiceAdvertiser(Advertiser advertiser, double amount) {
        // Invoice logic
    }

    public Map<String, Double> getPayments() {
        return payments;
    }
}