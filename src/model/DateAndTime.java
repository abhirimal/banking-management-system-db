package model;
import java.sql.Timestamp;
import java.util.Date;
import java.text.SimpleDateFormat;
public class DateAndTime {

    public String TimeStamp(){
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println();
        return formatter.format(ts);
    }
}