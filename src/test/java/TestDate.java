import junit.framework.TestCase;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 04.09.13
 * Time: 22:45
 * To change this template use File | Settings | File Templates.
 */
public class TestDate extends TestCase {

    public void testDate(){

        Date val = null;
        //String date = "2013-06-01";
        String date = "2013-06";
        DateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-MM");
        try {
            val = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar c = Calendar.getInstance();
        c.setTime(val);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));

        Date endOfMonth = c.getTime();

        java.sql.Date sqlDate = new  java.sql.Date(endOfMonth.getTime());

        System.out.println(sqlDate);

    }
}
