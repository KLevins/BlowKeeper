import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

    public Connection getConnection() {

        Connection conn = null;
        String str = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String path=this.getClass().getResource("BlowKeeper.db").getPath();
            conn = DriverManager.getConnection("jdbc:sqlite:"+path);
            str.length();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }
}
