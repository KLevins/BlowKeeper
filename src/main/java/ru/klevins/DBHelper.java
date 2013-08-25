package ru.klevins;

import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

    public Connection getConnection() {

        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            ClassLoader cl = ClassLoader.getSystemClassLoader();
            String path = cl.getResource("BlowKeeper.db").getPath();
            conn = DriverManager.getConnection("jdbc:sqlite:"+path);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }
}
