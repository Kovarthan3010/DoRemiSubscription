package com.example.geektrust.InputProcessor;

import com.example.geektrust.DAO.Subscription;
import com.example.geektrust.DAO.User;
import com.example.geektrust.Helpers.Helper;

import java.time.LocalDate;
import java.util.Objects;

import static com.example.geektrust.Constants.Constants.*;
import static com.example.geektrust.Constants.PremiumRepo.*;

public class PrintRenewalDetailsHandler {
    Helper helper = new Helper();
    public User printRenewals(User user) {
        if (Objects.nonNull(user) && (!user.getCreated() || user.getSubscriptionList().isEmpty())) {
            System.out.println(SUBSCRIPTIONS_NOT_FOUND);
        } else {
            user = renewalDateCalculation(user);
            int totalAmount = getTotalAmount(user);
            user.setRenewalAmount(totalAmount + "");
            printResult(user);
        }
        return user;
    }

    public int getTotalAmount(User user) {
        int totalAmount = user.getSubscriptionList().stream()
                .map(Subscription::getAmount)
                .reduce(0, Integer::sum);
        if(Objects.nonNull(user.getTopUp())) {
            totalAmount = totalAmount + (topUpStore.get(user.getTopUp().topUpName).amount * Integer.parseInt(user.getTopUp().topUpMonths));
        }
        return totalAmount;
    }

    public void printResult(User user) {
        user.getSubscriptionList()
                .forEach(subscription -> System.out.println("RENEWAL_REMINDER " + subscription.getCategory() + " " + helper.reverseDate(subscription.getRenewalDate())));
        System.out.println("RENEWAL_AMOUNT " + user.getRenewalAmount());
    }

    public User renewalDateCalculation(User user) {
        int numberOfSubscriptions = user.getSubscriptionList().size();
        for (int i = 0; i < numberOfSubscriptions; i++) {
            Subscription currentSubscription = user.getSubscriptionList().get(i);
            currentSubscription = calculateAndSetRenewalDate(currentSubscription, user);
            user.getSubscriptionList().set(i, currentSubscription);
        }
        return user;
    }

    public Subscription calculateAndSetRenewalDate(Subscription currentSubscription, User user) {
        String category = currentSubscription.getCategory();
        int currentPlanLength = zero;
        int currentPlanAmount = zero;
        if (category.contains(MUSIC)) {
            currentPlanLength = musicStore.get(currentSubscription.getPlan()).months;
            currentPlanAmount = musicStore.get(currentSubscription.getPlan()).amount;
        }
        else if (category.contains(VIDEO)) {
            currentPlanLength = videoStore.get(currentSubscription.getPlan()).months;
            currentPlanAmount = videoStore.get(currentSubscription.getPlan()).amount;
        }
        else if (category.contains(PODCAST)) {
            currentPlanLength = podCastStore.get(currentSubscription.getPlan()).months;
            currentPlanAmount = podCastStore.get(currentSubscription.getPlan()).amount;
        }
        currentSubscription.setAmount(currentPlanAmount);
        currentSubscription.setRenewalDate(getRenewalRemainderDate(user.getSubscriptionDate(), currentPlanLength));
        return currentSubscription;
    }

    public LocalDate getRenewalRemainderDate(LocalDate subscriptionDate, int currentPlanLength) {
        subscriptionDate=subscriptionDate.plusMonths(currentPlanLength);
        subscriptionDate=subscriptionDate.minusDays(daysToSubtract);
        return subscriptionDate;
    }

}
