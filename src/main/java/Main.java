import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

    public static void main (String args[])   {

        /*Scanner scan = new Scanner(System.in);
        System.out.print("Enter your word: ");
        String s = scan.nextLine();
        System.out.println("Last word: "+s);
        if (s.trim().equals("1")) {
            System.out.println("mission complit");
            System.out.println("fdvbiu");
        }*/

        DBHelper helper = new DBHelper();

        Connection con = helper.getConnection();

        try {
            Statement statement = con.createStatement();
            //statement.execute("create table tbl2(id simpleint, name varchar(30))");
            //statement.execute("insert into tbl2 values(1, 'Nik')");
            //statement.execute("insert into tbl2 values(2, 'Vas')");
            //statement.execute("insert into tbl2 values(3, 'Yur')");
            statement.execute("select category from categories where category = 'Бар'");
            System.out.println(statement.getResultSet().getString("category"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
