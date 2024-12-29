package com.example.geektrust.InputProcessorTest;

import com.example.geektrust.DAO.User;
import com.example.geektrust.InputProcessor.SubscriptionStarterHandler;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import static com.example.geektrust.Constants.Constants.invalidSubscriptionDateError;
import static org.junit.jupiter.api.Assertions.*;

public class SubscriptionStarterHandlerTest {
    SubscriptionStarterHandler subscriptionStarterHandler = new SubscriptionStarterHandler();

    @Test
    public void subscriptionStarterValidTest()
    {
        User user=new User();
        user = subscriptionStarterHandler.subscriptionStarter("START_SUBSCRIPTION 20-10-2022",user);
        assertTrue(user.getCreated());
        assertEquals(LocalDate.of(2022,10,20),user.getSubscriptionDate());
        assertFalse(user.getInvalidDateUsed());
    }

    @Test
    public void subscriptionStarterWithInValidSubscriptionDateTest()
    {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        User user=new User();
        user = subscriptionStarterHandler.subscriptionStarter("START_SUBSCRIPTION 40-15-2022",user);
        assertFalse(user.getCreated());
        assertTrue(user.getInvalidDateUsed());
        assertEquals(invalidSubscriptionDateError, byteArrayOutputStream.toString().trim());
    }
}
