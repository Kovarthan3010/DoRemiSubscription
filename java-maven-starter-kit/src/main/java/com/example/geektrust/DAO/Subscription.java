package com.example.geektrust.DAO;

import java.time.LocalDate;

public class Subscription {
    private final String category;
    private final String plan;
    private LocalDate renewalDate;
    private Integer amount;

    public Subscription(String category, String plan) {
        this.category = category;
        this.plan = plan;
    }

    public String getPlan() {
        return plan;
    }

    public String getCategory() {
        return category;
    }

    public LocalDate getRenewalDate() {
        return renewalDate;
    }

    public void setRenewalDate(LocalDate renewalDate) {
        this.renewalDate = renewalDate;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
