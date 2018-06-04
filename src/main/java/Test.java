import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author tangxiaoshuang
 * @date 2018/3/14 15:40
 */
public class Test
{
    public static void main(String[] args) {
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.YEAR,10);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        System.out.println(sf.format(c.getTime()));
    }
}
