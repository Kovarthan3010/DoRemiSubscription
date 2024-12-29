package com.example.geektrust.InputProcessor;

import com.example.geektrust.DAO.Subscription;
import com.example.geektrust.DAO.User;
import com.example.geektrust.Helpers.Helper;
import java.util.List;
import java.util.Objects;
import static com.example.geektrust.Constants.Constants.ADD_SUBSCRIPTION_FAILEDDUPLICATE_CATEGORY;
import static com.example.geektrust.Constants.Constants.ADD_SUBSCRIPTION_FAILEDINVALID_DATE;

public class AddSubscriptionsHandler {
    Helper helper = new Helper();
    public User addSubscriptions(String input, User user) {
        if (!user.getCreated() || user.getInvalidDateUsed()) {
            System.out.println(ADD_SUBSCRIPTION_FAILEDINVALID_DATE);
        } else {
            String category = helper.getCategory(input);
            String plan = helper.getPlan(input);
            List<Subscription> subscriptionList = user.getSubscriptionList();
            user = addSubscriptionToList(subscriptionList,category,plan,user);
            }
        return user;
        }

    public User addSubscriptionToList(List<Subscription> subscriptionList, String category, String plan, User user) {
        if(Objects.nonNull(subscriptionList)&&subscriptionList.stream()
                .anyMatch(subscription -> subscription.getCategory().equals(category))){
            System.out.println(ADD_SUBSCRIPTION_FAILEDDUPLICATE_CATEGORY);
        }
        else{
            Subscription subscription = new Subscription(category, plan);
            user.getSubscriptionList().add(subscription);
        }
        return user;
    }

}
