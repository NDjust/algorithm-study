package BruteForce;

import java.util.Scanner;

public class baekjoon1107 {

    static boolean[] channel = new boolean[10];

    public static int possible(int c) {
        if (c == 0) {
            if (channel[0]) {
                return 0;
            } else {
                return 1;
            }
        }

        int len = 0;

        while (c > 0) {
            if (channel[c % 10]) {
                return 0;
            }

            len += 1;
            c /= 10;
        }
        return len;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int m = Integer.parseInt(sc.nextLine());


        for (int i = 0; i < m; i++) {
            int k = sc.nextInt();
            channel[k] = true;
        }

        int ans = n - 100;

        if (ans < 0) {
            ans = -ans;
        }

        for (int i = 0; i <= 1000000; i++) {
            int c = i;
            int len = possible(c);

            if (len > 0) {
                int press = c - n;

                if (press < 0) {
                    press = -press;
                }

                if (ans > len + press) {
                    ans = len + press;
                }
            }
        }
        System.out.println(ans);
    }
}
