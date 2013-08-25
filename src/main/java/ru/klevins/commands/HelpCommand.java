package ru.klevins.commands;

import ru.klevins.DBHelper;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class HelpCommand implements Command {

    @Override
    public boolean execute() {
        System.out.println("Добро пожаловать в BlowKeeper");
        System.out.println("Доступные категории затрат");

        DBHelper helper = new DBHelper();

        Connection con = helper.getConnection();

        try {
            Statement statement = con.createStatement();
            //statement.execute("create table tbl2(id simpleint, name varchar(30))");
            //statement.execute("insert into tbl2 values(1, 'Nik')");
            //statement.execute("insert into tbl2 values(2, 'Vas')");
            //statement.execute("insert into tbl2 values(3, 'Yur')");
            //statement.execute("select name from tbl2 where id = 1");

            statement.execute("select category, style from categories");
            System.out.println(statement.getResultSet().getString("category"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
