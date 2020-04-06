package etc;

import java.util.Scanner;

public class baekjoon10820 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            int blank = 0;
            int lower = 0;
            int upper = 0;
            int num = 0;
            String s = sc.nextLine();

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') {
                    blank++;
                } else if (97 <= s.charAt(i) && s.charAt(i) <= 122) {
                    lower++;
                } else if (65 <= s.charAt(i) && s.charAt(i) <= 90) {
                    upper++;
                } else {
                    num++;
                }
            }
            System.out.printf("%d %d %d %d\n", lower, upper, num, blank);
        }
    }
}
