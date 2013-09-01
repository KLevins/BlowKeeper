package ru.klevins.commands;

import ru.klevins.DBHelper;

import java.sql.*;

public class HelpCommand implements Command {

    private final Connection connection;

    public  HelpCommand(Connection connection){
        this.connection = connection;
    }

    @Override
    public boolean execute(String input) {

        System.out.println("Доступные категории затрат:\n");

        try {
            Statement statement = connection.createStatement();

            statement.execute("select category, style from categories");

            ResultSet set = statement.getResultSet();
            while(set.next()){
                String cat = set.getString("category");
                String sryle = set.getString("style");
                System.out.println("     "+cat+" - "+sryle);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
