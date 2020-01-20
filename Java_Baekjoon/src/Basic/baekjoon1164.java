package Basic;

import java.util.Scanner;

public class baekjoon1164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        char ascii = a.charAt(0);

        System.out.printf("%d", 65 + (ascii - 65));
    }
}
