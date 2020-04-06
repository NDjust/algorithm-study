package etc;

import java.util.Scanner;

public class baekjoon11655 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (65 <= c && c <= 90) {
                if (c + 13 > 90) {
                    System.out.printf("%c", 65 + (c + 13 - 91));
                } else {
                    System.out.printf("%c", c+13);
                }
            } else if (97 <= c && c <= 122) {
                if (c + 13 > 122) {
                    System.out.printf("%c", 97 + (c+13 - 123));
                } else {
                    System.out.printf("%c", c+13);
                }
            } else {
                System.out.printf("%c", str.charAt(i));
            }
        }
    }
}
