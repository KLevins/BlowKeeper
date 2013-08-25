package ru.klevins.commands;

import ru.klevins.DBHelper;

import java.sql.*;

public class HelpCommand implements Command {

    @Override
    public boolean execute() {
        System.out.println("Добро пожаловать в BlowKeeper");
        System.out.println("Доступные категории затрат");

        DBHelper helper = new DBHelper();

        Connection con = helper.getConnection();

        try {
            Statement statement = con.createStatement();

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
