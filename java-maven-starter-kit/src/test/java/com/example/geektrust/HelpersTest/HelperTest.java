package com.example.geektrust.HelpersTest;

import com.example.geektrust.Helpers.Helper;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static com.example.geektrust.Constants.Constants.*;
import static org.junit.jupiter.api.Assertions.*;

public class HelperTest {

    Helper helper = new Helper();

    @Test
    public void isSubscriptionDateValidWithValidDateTest()
    {
        assertTrue(helper.isSubscriptionDateValid(10,10));
    }

    @Test
    public void isSubscriptionDateValidWithInValidDateTest()
    {
        assertFalse(helper.isSubscriptionDateValid(40,10));
    }

    @Test
    public void isValidDayWithValidDayTest()
    {
        assertTrue(helper.isValidDay(10));
    }

    @Test
    public void isValidDayWithInValidDayTest()
    {
        assertFalse(helper.isValidDay(40));
    }

    @Test
    public void isValidMonthWithValidMonthTest()
    {
        assertTrue(helper.isValidDay(10));
    }

    @Test
    public void isValidMonthWithInValidMonthTest()
    {
        assertFalse(helper.isValidDay(40));
    }

    @Test
    public void getCategoryTestValid()
    {
        assertEquals(MUSIC,helper.getCategory("ADD_SUBSCRIPTION MUSIC PREMIUM"));
    }

    @Test
    public void getCategoryTestInValid()
    {
        assertEquals(MUSIC,helper.getCategory("MUSIC PREMIUM"));
    }

    @Test
    public void getPlanTestValid()
    {
        assertEquals(PREMIUM,helper.getPlan("ADD_SUBSCRIPTION MUSIC PREMIUM"));
    }

    @Test
    public void getTopUpNameTestValid()
    {
        assertEquals(TEN_DEVICE,helper.getTopUpName("ADD_TOPUP TEN_DEVICE 1"));
    }

    @Test
    public void getTopUpMonthTestValid()
    {
        assertEquals("1",helper.getTopUpMonth("ADD_TOPUP TEN_DEVICE 1"));
    }

    @Test
    public void reverseDateTest()
    {
        assertEquals("20-10-2022",helper.reverseDate(LocalDate.of(2022, 10, 20)));
    }

    @Test
    public void stringGeneratorTest()
    {
        StringBuilder result = helper.stringGenerator("Way to go!!!");
        assertEquals("Way",result.toString());
    }
}
