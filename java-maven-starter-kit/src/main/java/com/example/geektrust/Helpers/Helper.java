package com.example.geektrust.Helpers;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.example.geektrust.Constants.Constants.*;

public class Helper {
    public boolean isSubscriptionDateValid(int day, int month) {
        return (isValidDay(day) && isValidMonth(month));
    }

    public boolean isValidDay(int day) {
        return (day >= dateStart && day <= dateEnd);
    }

    public boolean isValidMonth(int month){
        return (month >= monthStart && month <= monthEnd);
    }

    public String getCategory(String input) {
        String inputLine = input;
        if (inputLine.contains(ADD_SUBSCRIPTION)) {
            inputLine = inputLine.substring(ADD_SUBSCRIPTION.length()).trim();
        }
        StringBuilder stringBuilder = stringGenerator(inputLine);
        return stringBuilder.toString();
    }

    public String getPlan(String input) {
        String inputLine = input.trim();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=inputLine.length()-1;i>=0;i--)
        {
            if(Character.isWhitespace(inputLine.charAt(i)))
            {
                stringBuilder.reverse();
                break;
            }
            else{
                stringBuilder.append(inputLine.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    public String getTopUpName(String input) {
        String inputLine = input;
        inputLine = inputLine.substring(ADD_TOPUP.length());
        inputLine=inputLine.trim();
        StringBuilder stringBuilder = stringGenerator(inputLine);
        return stringBuilder.toString();
    }

    public String getTopUpMonth(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=input.length()-1;i>=0;i--)
        {
            if(input.charAt(i) == ' ')
            {
                break;
            }
            stringBuilder.append(input.charAt(i));
        }
        return stringBuilder.toString();
    }

    public String reverseDate(LocalDate date)
    {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        int day = date.getDayOfMonth();
        int month = date.getMonthValue();
        int year = date.getYear();
        return dateTimeFormatter.format(LocalDate.of(year,month,day));
    }

    public StringBuilder stringGenerator(String inputLine)
    {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < inputLine.length(); i++) {
            if (inputLine.charAt(i) != ' ') {
                stringBuilder.append(inputLine.charAt(i));
            }
            else {
                break;
            }
        }
        return stringBuilder;
    }
}
