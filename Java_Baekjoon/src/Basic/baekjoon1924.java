package Basic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class baekjoon1924 {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);

        String x = sc.next();
        String y = sc.next();

        String day = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String currDate = "2007-";

        if (x.length() == 1) {
            currDate += "0" + x;
        } else {
            currDate += x;
        }

        if (y.length() == 1) {
            currDate += "-0" + y;
        } else {
            currDate += "-" + y;
        }

        Date date = dateFormat.parse(currDate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayNum = calendar.get(Calendar.DAY_OF_WEEK);

        switch (dayNum) {
            case 1:
                day = "SUN";
                break;
            case 2:
                day = "MON";
                break;
            case 3:
                day = "TUE";
                break;
            case 4:
                day = "WED";
                break;
            case 5:
                day = "THU";
                break;
            case 6:
                day = "FRI";
                break;
            case 7:
                day = "SAT";
                break;
        }
        System.out.println(day);
    }
}
