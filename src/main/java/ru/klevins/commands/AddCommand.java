package ru.klevins.commands;

import ru.klevins.DBHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        boolean getCategory = validationCategory(chargeCategory);
        if (!getCategory)   {
            return false;
        }

        System.out.println(a);
        System.out.println(date);
        System.out.println(charge);
        System.out.println(chargeCategory);

        DBHelper helper = new DBHelper();

        Connection con = helper.getConnection();

        try {
            Statement statement = con.createStatement();
            String query = "insert into CHARGES (DATE, CHARGES, CATEGORY) values " +
                    "('"+sqlDate+"'," +
                    ""+charge+"," +
                    " '"+chargeCategory+"')";
            statement.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        System.out.println("Показания приняты");
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
    public boolean validationCategory (String chargeCategory) {

        DBHelper helper = new DBHelper();

        Connection con = helper.getConnection();

        try {
            Statement statement = con.createStatement();

            statement.execute("select category from categories");

            ResultSet set = statement.getResultSet();
            while(set.next()){
                String cat = set.getString("category");
                if (cat.equals(chargeCategory))  {
                    return true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Выбрана неверная категория затрат");
        return false;
    }
}
