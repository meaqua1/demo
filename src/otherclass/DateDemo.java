package otherclass;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateDemo {
    public static void main(String[] args) {
        System.out.println(new Date().getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        System.out.println(sdf.format(new Date()));

    }
}

class XinDate{


    public static void main(String[] args) {
        LocalDate localDate;
        localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        LocalDateTime localDateTime1 = LocalDateTime.of(2022,10,6,23,13);
        System.out.println(localDateTime1);

        System.out.println(localDate.getMonthValue());





        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        System.out.println(dtf.format(localDateTime));
        System.out.println(dtf.parse("2019年07月19日 22:50:47"));

    }
}

class SSs{

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        int days = calendar.get(Calendar.YEAR);
        System.out.println(days);
        calendar.add(Calendar.YEAR,20);
    }

}