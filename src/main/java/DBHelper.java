import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

    public Connection getConnection(){

        Connection conn = null;

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:BlowKeeper.db");
        }catch(SQLException se) {
            System.out.println("SQLError: " + se);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
