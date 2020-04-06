package etc;

import java.util.Scanner;

public class baekjoon10824 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        String c = sc.next();
        String d = sc.next();


        String front = a + b;
        String back = c + d;

        System.out.println(Long.parseLong(front) + Long.parseLong(back));
    }
}
