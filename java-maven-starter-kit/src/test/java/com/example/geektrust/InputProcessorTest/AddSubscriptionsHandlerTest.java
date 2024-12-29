package com.example.geektrust.InputProcessorTest;

import com.example.geektrust.DAO.Subscription;
import com.example.geektrust.DAO.User;
import com.example.geektrust.InputProcessor.AddSubscriptionsHandler;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static com.example.geektrust.Constants.Constants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddSubscriptionsHandlerTest {

User mockedUser = Mockito.mock(User.class);
AddSubscriptionsHandler addSubscriptionsHandler = new AddSubscriptionsHandler();

    @Test
    public void addSubscriptionsWithUserNotCreated()
    {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        Mockito.when(mockedUser.getCreated()).thenReturn(false);
        addSubscriptionsHandler.addSubscriptions("testInput",mockedUser);
        assertEquals(ADD_SUBSCRIPTION_FAILEDINVALID_DATE, byteArrayOutputStream.toString().trim());
        System.setOut(System.out);
    }

    @Test
    public void addSubscriptionsWithInvalidDateUsed()
    {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        Mockito.when(mockedUser.getInvalidDateUsed()).thenReturn(true);
        addSubscriptionsHandler.addSubscriptions("testInput",mockedUser);
        assertEquals(ADD_SUBSCRIPTION_FAILEDINVALID_DATE, byteArrayOutputStream.toString().trim());
        System.setOut(System.out);
    }

    @Test
    public void addSubscriptionsWithRepeatedSubscriptions()
    {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        List<Subscription> subscriptionList = new ArrayList<>();
        subscriptionList.add(new Subscription(MUSIC,PERSONAL));
        Mockito.when(mockedUser.getSubscriptionList()).thenReturn(subscriptionList);
        Mockito.when(mockedUser.getCreated()).thenReturn(true);
        addSubscriptionsHandler.addSubscriptions("ADD_SUBSCRIPTION MUSIC PERSONAL",mockedUser);
        assertEquals(ADD_SUBSCRIPTION_FAILEDDUPLICATE_CATEGORY,byteArrayOutputStream.toString().trim());
        System.setOut(System.out);
    }

    @Test
    public void addSubscriptionsWithValidSubscriptions()
    {
        List<Subscription> subscriptionList = new ArrayList<>();
        Mockito.when(mockedUser.getSubscriptionList()).thenReturn(subscriptionList);
        Mockito.when(mockedUser.getCreated()).thenReturn(true);
        User user = addSubscriptionsHandler.addSubscriptions("ADD_SUBSCRIPTION MUSIC PERSONAL",mockedUser);
        assertEquals(MUSIC,user.getSubscriptionList().get(0).getCategory());
    }

}
