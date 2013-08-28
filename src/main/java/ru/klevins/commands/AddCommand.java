package ru.klevins.commands;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Никита
 * Date: 25.08.13
 * Time: 17:08
 * To change this template use File | Settings | File Templates.
 */
public class AddCommand implements Command {

    @Override
    public boolean execute(String input) {

        String a, date, charge, chargeCategory;
        a = input.substring(input.indexOf(" "),input.length());
        date = a.substring(a.indexOf(" ") + 1, a.indexOf(";"));
        charge = a.substring(a.indexOf(";")+1,a.indexOf(":"));
        chargeCategory = a.substring(a.indexOf(":") + 1, a.length());

        java.sql.Date sqlDate = getSqlDate(date);
        if (sqlDate==null) {
            return false;
        }
        int chargeInt = getIntValue(charge);
        if (chargeInt==-1)   {
            return  false;
        }

        System.out.println(a);
        System.out.println(date);
        System.out.println(charge);
        System.out.println(chargeCategory);
        return true;
    }
    private java.sql.Date getSqlDate(String date) {

        Date val = null;
        DateFormat formatter;
        try {
            formatter = new SimpleDateFormat("yyyy-MM-dd");
            val = formatter.parse(date);

        } catch (ParseException e) {
            System.out.println("Дата введена не в формате ГГГГ-ММ-ДД");
            return null;
        }
        java.sql.Date sqlDate = new java.sql.Date(val.getTime());

        return sqlDate;
    }
    private int getIntValue(String charge){

        int getInt = -1;

        try {
            getInt = Integer.parseInt(charge);
        }
        catch (NumberFormatException ex) {
            System.out.println("Затрата введена не в числовом формате");
        }
        return getInt;
    }

}
