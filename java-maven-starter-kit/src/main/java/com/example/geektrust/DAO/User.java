package com.example.geektrust.DAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {

    private List<Subscription> subscriptionList;
    private TopUp topUp;
    private String renewalAmount;
    private LocalDate subscriptionDate;
    private boolean isCreated;
    private boolean isInvalidDateUsed;

    public User() {
        subscriptionList = new ArrayList<>();
    }

    public String getRenewalAmount() {
        return renewalAmount;
    }

    public void setRenewalAmount(String renewalAmount) {
        this.renewalAmount = renewalAmount;
    }

    public List<Subscription> getSubscriptionList() {
        return subscriptionList;
    }

    public LocalDate getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(LocalDate subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public boolean getCreated() {
        return isCreated;
    }

    public void setCreated(Boolean created) {
        isCreated = created;
    }

    public boolean getInvalidDateUsed() {
        return isInvalidDateUsed;
    }

    public void setInvalidDateUsed(Boolean invalidDateUsed) {
        isInvalidDateUsed = invalidDateUsed;
    }

    public TopUp getTopUp() {
        return topUp;
    }

    public void setTopUp(TopUp topUp) {
        this.topUp = topUp;
    }

    public void setSubscriptionList(List<Subscription> subscriptionList) {
        this.subscriptionList = subscriptionList;
    }


}
