package com.example.geektrust.InputProcessorTest;

import com.example.geektrust.DAO.Subscription;
import com.example.geektrust.DAO.TopUp;
import com.example.geektrust.DAO.User;
import com.example.geektrust.InputProcessor.AddTopUpHandler;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static com.example.geektrust.Constants.Constants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

public class AddTopUpHandlerTest {
    User mockedUser = Mockito.mock(User.class);
    AddTopUpHandler addTopUpHandler = new AddTopUpHandler();

    @Test
    public void addTopUpInvalidDateUsed(){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        Mockito.when(mockedUser.getInvalidDateUsed()).thenReturn(true);
        addTopUpHandler.addTopUp("test",mockedUser);
        assertEquals(ADD_TOPUP_FAILED_INVALID_DATE , byteArrayOutputStream.toString().trim());
        System.setOut(System.out);
    }

    @Test
    public void addTopUpWithEmptySubscriptionList(){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        Mockito.when(mockedUser.getSubscriptionList()).thenReturn(new ArrayList<>());
        addTopUpHandler.addTopUp("test",mockedUser);
        assertEquals(ADD_TOPUP_FAILEDSUBSCRIPTIONS_NOT_FOUND , byteArrayOutputStream.toString().trim());
        System.setOut(System.out);
    }

    @Test
    public void addTopUpWithDuplicateTopUp(){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        ArrayList<Subscription> list = new ArrayList<>();
        list.add(new Subscription(MUSIC,PERSONAL));
        Mockito.when(mockedUser.getSubscriptionList()).thenReturn(list);
        Mockito.when(mockedUser.getTopUp()).thenReturn(new TopUp("TEN_DEVICE","1"));
        addTopUpHandler.addTopUp("test",mockedUser);
        assertEquals(ADD_TOPUP_FAILEDDUPLICATE_TOPUP , byteArrayOutputStream.toString().trim());
        System.setOut(System.out);
    }

    @Test
    public void addTopUpValidTopUp(){
        ArrayList<Subscription> list = new ArrayList<>();
        list.add(new Subscription(MUSIC,PERSONAL));
        doNothing().when(mockedUser).setTopUp(Mockito.any());
        Mockito.when(mockedUser.getSubscriptionList()).thenReturn(list);
        User user = addTopUpHandler.addTopUp("ADD_TOPUP TEN_DEVICE 1",mockedUser);
        verify(mockedUser).setTopUp(Mockito.any());
    }

}
