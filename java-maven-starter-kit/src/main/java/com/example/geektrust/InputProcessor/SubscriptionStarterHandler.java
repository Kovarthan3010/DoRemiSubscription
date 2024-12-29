package com.example.geektrust.InputProcessor;

import com.example.geektrust.DAO.User;
import com.example.geektrust.Helpers.Helper;

import java.time.LocalDate;

import static com.example.geektrust.Constants.Constants.*;

public class SubscriptionStarterHandler {
    Helper helper = new Helper();
    public User subscriptionStarter(String input, User user) {
        String inputDate = input.substring(input.length() - dateLength);
        int year = Integer.parseInt(inputDate.substring(six));
        int month = Integer.parseInt(inputDate.substring(three, five));
        int date = Integer.parseInt(inputDate.substring(zero, two));
        if (helper.isSubscriptionDateValid(date, month)) {
            LocalDate subscriptionDate = LocalDate.of(year, month, date);
            user.setCreated(true);
            user.setSubscriptionDate(subscriptionDate);
            user.setInvalidDateUsed(false);
        } else {
            System.out.println(invalidSubscriptionDateError);
            user.setCreated(false);
            user.setInvalidDateUsed(true);
        }
        return user;
    }
}
