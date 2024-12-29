package com.example.geektrust.InputProcessor;

import com.example.geektrust.DAO.TopUp;
import com.example.geektrust.DAO.User;
import com.example.geektrust.Helpers.Helper;

import java.util.Objects;

import static com.example.geektrust.Constants.Constants.*;

public class AddTopUpHandler {
    Helper helper = new Helper();
    public User addTopUp(String input, User user) {
        if(user.getInvalidDateUsed())
        {
            System.out.println(ADD_TOPUP_FAILED_INVALID_DATE);
        }
        else if(user.getSubscriptionList().isEmpty())
        {
            System.out.println(ADD_TOPUP_FAILEDSUBSCRIPTIONS_NOT_FOUND);
        }
        else if(Objects.nonNull(user.getTopUp()))
        {
            System.out.println(ADD_TOPUP_FAILEDDUPLICATE_TOPUP);
        }
        else {
            String topUpName = helper.getTopUpName(input);
            String topUpMonth = helper.getTopUpMonth(input);
            TopUp topUp = new TopUp(topUpName,topUpMonth);
            user.setTopUp(topUp);
        }
        return user;
    }
}
