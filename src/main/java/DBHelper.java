import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Никита
 * Date: 25.08.13
 * Time: 10:01
 * To change this template use File | Settings | File Templates.
 */
public class DBHelper {

    public Connection getConnection(){

        Connection conn = null;

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:MoneyHolder.db");
        }catch(SQLException se) {
            System.out.println("SQLError: " + se);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
