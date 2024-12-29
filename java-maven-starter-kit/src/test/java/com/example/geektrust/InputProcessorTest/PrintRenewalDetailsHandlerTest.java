package com.example.geektrust.InputProcessorTest;

import com.example.geektrust.DAO.Subscription;
import com.example.geektrust.DAO.TopUp;
import com.example.geektrust.DAO.User;
import com.example.geektrust.InputProcessor.PrintRenewalDetailsHandler;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;

import static com.example.geektrust.Constants.Constants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrintRenewalDetailsHandlerTest {

    PrintRenewalDetailsHandler printRenewalDetailsHandler = new PrintRenewalDetailsHandler();
    User mockedUser = Mockito.mock(User.class);

    @Test
    public void printRenewalsTestWithUserNotCreated()
    {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        Mockito.when(mockedUser.getCreated()).thenReturn(false);
        printRenewalDetailsHandler.printRenewals(mockedUser);
        assertEquals(SUBSCRIPTIONS_NOT_FOUND, byteArrayOutputStream.toString().trim());
        System.setOut(System.out);
    }

    @Test
    public void printRenewalsTestWithNoSubscriptions()
    {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        Mockito.when(mockedUser.getCreated()).thenReturn(true);
        Mockito.when(mockedUser.getSubscriptionList()).thenReturn(new ArrayList<>());
        printRenewalDetailsHandler.printRenewals(mockedUser);
        assertEquals(SUBSCRIPTIONS_NOT_FOUND, byteArrayOutputStream.toString().trim());
        System.setOut(System.out);
    }

    @Test
    public void printRenewalsTestWithNoInalidCase()
    {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        ArrayList<Subscription> subscriptionList = new ArrayList<>();
        subscriptionList.add(new Subscription(MUSIC,PERSONAL));
        subscriptionList.add(new Subscription(VIDEO,PERSONAL));
        subscriptionList.add(new Subscription(PODCAST,PERSONAL));
        User user = new User();
        user.setCreated(true);
        user.setSubscriptionList(subscriptionList);
        user.setTopUp(new TopUp(TEN_DEVICE,"1"));
        user.setSubscriptionDate( LocalDate.of(2022, 10, 22));
        User result = printRenewalDetailsHandler.printRenewals(user);
        assertEquals(500, Integer.parseInt(result.getRenewalAmount()));
        System.setOut(System.out);
    }

    @Test
    public void printRenewalsTestWithNoTopUp()
    {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        ArrayList<Subscription> subscriptionList = new ArrayList<>();
        subscriptionList.add(new Subscription(MUSIC,PERSONAL));
        subscriptionList.add(new Subscription(VIDEO,PERSONAL));
        subscriptionList.add(new Subscription(PODCAST,PERSONAL));
        User user = new User();
        user.setCreated(true);
        user.setSubscriptionList(subscriptionList);
        user.setSubscriptionDate( LocalDate.of(2022, 10, 22));
        User result = printRenewalDetailsHandler.printRenewals(user);
        assertEquals(400, Integer.parseInt(result.getRenewalAmount()));
        System.setOut(System.out);
    }
}
