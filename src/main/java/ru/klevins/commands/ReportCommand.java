package ru.klevins.commands;

import ru.klevins.DBHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created with IntelliJ IDEA.
 * User: Никита
 * Date: 25.08.13
 * Time: 21:24
 * To change this template use File | Settings | File Templates.
 */
public class ReportCommand implements Command  {

    private final Connection connection;

    public  ReportCommand(Connection connection){
        this.connection = connection;
    }

    @Override
    public boolean execute(String input) {
        System.out.println("Отчет");

        try {
            Statement statement = connection.createStatement();

            statement.execute("select date, charge, category from charges");

            ResultSet set = statement.getResultSet();
            while(set.next()){
                String date = set.getString("date");
                String charge = set.getString("charge");
                String cat = set.getString("category");
                System.out.println("     "+date+" - "+charge+" - "+cat);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
