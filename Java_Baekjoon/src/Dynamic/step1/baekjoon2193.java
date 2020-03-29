package Dynamic.step1;

import java.util.Scanner;

public class baekjoon2193 {

    public static long twoDimArr(int n) {
        long[][] d = new long[n+1][2];

        d[1][0] = 0;
        d[1][1] = 1;

        for (int i = 2; i <= n; i++) {
            d[i][0] = d[i-1][0] + d[i-1][1];
            d[i][1] = d[i-1][0];
        }

        return d[n][0] + d[n][1];
    }

    public static int oneDimArr(int n) {
        int[] d = new int[n + 1];

        d[1] = 1;

        if (n >= 2) {
            d[2] = 1;
        }

        for (int i = 3; i <= n; i++) {
            d[i] = d[i - 1] + d[i - 2];
        }

        return d[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(oneDimArr(n));
        System.out.println(twoDimArr(n));

    }
}
