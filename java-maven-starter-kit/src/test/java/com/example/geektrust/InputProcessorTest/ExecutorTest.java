package com.example.geektrust.InputProcessorTest;

import com.example.geektrust.DAO.User;
import com.example.geektrust.InputProcessor.Executor;
import com.example.geektrust.InputProcessor.SubscriptionStarterHandler;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static com.example.geektrust.Constants.Constants.startSubscription;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

public class ExecutorTest {
    Executor executor = new Executor();

    @Test
    public void startSubscriptionTest(){
        executor.executeLine("START_SUBSCRIPTION 20-10-2022");
    }

    @Test
    public void AddSubscriptionTest(){
        executor.executeLine("ADD_SUBSCRIPTION MUSIC PERSONAL");
    }

    @Test
    public void AddTopUpTest(){
        executor.executeLine("ADD_TOPUP TEN_DEVICE 1");
    }

    @Test
    public void printRenewalTest(){
        executor.executeLine("PRINT_RENEWAL_DETAILS");
    }

}
