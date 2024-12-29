package com.example.geektrust.Constants;

import java.util.HashSet;

public class Constants {
    public static final String startSubscription = "START_SUBSCRIPTION";
    public static final String ADD_SUBSCRIPTION = "ADD_SUBSCRIPTION";
    public static final Integer dateLength = 10;
    public static final Integer dateStart = 1;
    public static final Integer dateEnd = 31;
    public static final Integer monthStart = 1;
    public static final Integer monthEnd = 12;
    public static final String invalidSubscriptionDateError = "INVALID_DATE";
    public static final String ADD_SUBSCRIPTION_FAILEDINVALID_DATE = "ADD_SUBSCRIPTION_FAILED INVALID_DATE";
    public static final String ADD_SUBSCRIPTION_FAILEDDUPLICATE_CATEGORY = "ADD_SUBSCRIPTION_FAILED DUPLICATE_CATEGORY";
    public static final String ADD_TOPUP = "ADD_TOPUP";
    public static final String ADD_TOPUP_FAILEDSUBSCRIPTIONS_NOT_FOUND = "ADD_TOPUP_FAILED SUBSCRIPTIONS_NOT_FOUND";
    public static final String ADD_TOPUP_FAILEDDUPLICATE_TOPUP = "ADD_TOPUP_FAILED DUPLICATE_TOPUP";
    public static final String FREE = "FREE";
    public static final String PERSONAL = "PERSONAL";
    public static final String PREMIUM = "PREMIUM";
    public static final String FOUR_DEVICE = "FOUR_DEVICE";
    public static final String TEN_DEVICE = "TEN_DEVICE";
    public static final String PRINT_RENEWAL_DETAILS = "PRINT_RENEWAL_DETAILS";
    public static final String SUBSCRIPTIONS_NOT_FOUND = "SUBSCRIPTIONS_NOT_FOUND";
    public static final String MUSIC = "MUSIC";
    public static final String VIDEO = "VIDEO";
    public static final String PODCAST = "PODCAST";
    public static final String ADD_TOPUP_FAILED_INVALID_DATE = "ADD_TOPUP_FAILED INVALID_DATE";
    public static final int daysToSubtract = 10;
    public static final int zero = 0;
    public static final int six = 6;
    public static final int three = 3;
    public static final int five = 5;
    public static final int two = 2;
    public static HashSet<String> categoryList = getCategoryList();
    public static HashSet<String> planList = getPlanList();

    private static HashSet<String> getPlanList() {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("PREMIUM");
        hashSet.add("PERSONAL");
        hashSet.add("FREE");
        return hashSet;
    }

    private static HashSet<String> getCategoryList() {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("MUSIC");
        hashSet.add("VIDEO");
        hashSet.add("PODCAST");
        return hashSet;
    }


}
