package com.example.geektrust.InputProcessor;

import com.example.geektrust.DAO.User;
import static com.example.geektrust.Constants.Constants.*;

public class Executor {
    User user = new User();
    AddSubscriptionsHandler addSubscriptionsHandler = new AddSubscriptionsHandler();
    SubscriptionStarterHandler subscriptionStarterHandler = new SubscriptionStarterHandler();
    AddTopUpHandler addTopUpHandler = new AddTopUpHandler();
    PrintRenewalDetailsHandler printRenewalDetailsHandler = new PrintRenewalDetailsHandler();
    public void executeLine(String input) {
        if(input.contains(startSubscription))
        {
            user = subscriptionStarterHandler.subscriptionStarter(input, user);
        }
        else if(input.contains(ADD_SUBSCRIPTION))
        {
            user = addSubscriptionsHandler.addSubscriptions(input, user);
        }
        else if(input.contains(ADD_TOPUP))
        {
            user = addTopUpHandler.addTopUp(input, user);
        }
        else if(input.contains(PRINT_RENEWAL_DETAILS))
        {
            user = printRenewalDetailsHandler.printRenewals(user);
        }
    }
}