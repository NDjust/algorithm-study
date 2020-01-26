package Basic;

import java.util.Scanner;

public class baekjoon2908 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        String r_a = new String();
        String r_b = new String();

        for (int i = a.length() - 1; i >= 0; i--) {
            r_a = r_a + a.charAt(i);
            r_b = r_b + b.charAt(i);
        }



        if (Integer.parseInt(r_a) > Integer.parseInt(r_b)) {
            System.out.println(r_a);
        } else {
            System.out.println(r_b);
        }
    }
}
