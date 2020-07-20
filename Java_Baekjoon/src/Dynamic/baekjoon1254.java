package Dynamic;

import java.util.Scanner;

public class baekjoon1254 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int len = s.length();

        for (int i = 0; i < len; i++) {
            String substring = s.substring(i);
            if (isPhilandrome(substring)) {
                System.out.println(len + i);
                return;
            }
        }


        System.out.println(len % 2 == 0 ? len * 2: len * 2 - 1);
    }

    public static boolean isPhilandrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
