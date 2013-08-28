package ru.klevins.commands;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 27.08.13
 * Time: 22:09
 * To change this template use File | Settings | File Templates.
 */
import javafx.util.converter.DateStringConverter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Test {
    public static void main (String args[])  {

        String str = "2013-06-15";
        Date date = null;
        DateFormat formatter;
        try {
            formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = formatter.parse(str);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        System.out.println(sqlDate);

    }
}

