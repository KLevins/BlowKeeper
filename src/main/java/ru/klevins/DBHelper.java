package ru.klevins;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

    private final Connection connection;
    private static DBHelper helper;

    private DBHelper(){
        this.connection = getConn();
    }

    public static DBHelper getInstance(){

        if(helper == null){
            helper = new DBHelper();
        }
        return helper;
    }

    public Connection getConnection(){

        return connection;
    }

    private Connection getConn() {

        Connection conn = null;

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:"+new File("src/main/resources/BlowKeeper.db").getAbsolutePath());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }
}
