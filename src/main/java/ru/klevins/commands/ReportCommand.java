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
        Date date1 = new Date();

        if (sqlDate==null) {
            return false;
        }

        System.out.println(date);

        Statement statement = null;

        try {
            statement = connection.createStatement();
            String query = "where date between date'date' and date'date1'";
            statement.executeUpdate(query);

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

        System.out.println("Показания приняты");
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
