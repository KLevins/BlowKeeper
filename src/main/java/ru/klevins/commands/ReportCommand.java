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
import java.util.Calendar;


public class ReportCommand implements Command  {

            private final Connection connection;

            public  ReportCommand(Connection connection){
                this.connection = connection;
    }

    @Override
    public boolean execute(String input) {

        String date;
        date = input.substring(input.indexOf(" ")+1,input.length());

        java.sql.Date sqlDate = getSqlDate(date);

        Date val = null;
        String date1 = date;
        DateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            val = formatter.parse(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar c = Calendar.getInstance();
        c.setTime(val);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date endOfMonth = c.getTime();

        java.sql.Date sqlDate1 = new  java.sql.Date(endOfMonth.getTime());



        if (sqlDate==null) {
            return false;
        }


        Statement statement = null;

        try {
            statement = connection.createStatement();
            String query = "select sum(charges)from charges where date between date 'sqlDate' and date 'sqlDate1'";
            statement.executeUpdate(query);
            System.out.println("Показания приняты");
            System.out.println("Суммарные затраты за текущий месяц: "+query);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }  finally {
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


        return true;
    }
    private java.sql.Date getSqlDate(String datevalues) {

        Date val = null;
        DateFormat formatter;
        try {
            formatter = new SimpleDateFormat("yyyy-MM-dd");
            val = formatter.parse(datevalues);

        } catch (ParseException e) {
            System.out.println("Дата введена не в формате ГГГГ-ММ-ДД");
            return null;
        }
        java.sql.Date sqlDate = new java.sql.Date(val.getTime());

        return sqlDate;
    }
}
