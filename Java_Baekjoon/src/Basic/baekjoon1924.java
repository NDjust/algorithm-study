package Basic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class baekjoon1924 {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();

        String day = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse("2007-01-11");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int dayNum = calendar.get(Calendar.DAY_OF_WEEK);


        switch (dayNum) {
            case 1:
                day = "MON";
            case 2:
                day = "TUE";
            case 3:
                day = "WED";
            case 4:
                day = "THU";
            case 5:
                day = "FRI";
            case 6:
                day = "SAT";
            case 7:
                day = "SUN";
        }
        System.out.println(day);
    }
}
