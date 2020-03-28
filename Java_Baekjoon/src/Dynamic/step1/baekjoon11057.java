package Dynamic.step1;

import java.util.Scanner;

public class baekjoon11057 {
    public static long mod = 10007L;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] d = new long[n+1][11];


        for (int i = 0; i <= 9; i++) {
            d[1][i] = 1;
        }


        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                d[i][j] = 0;
                for (int k = 0; k <= 9-j; k++) {
                    d[i][j] += d[i-1][j+k];
                    d[i][j] %= mod;
                }
            }
        }

        int ans = 0;

        for (int i = 0; i <= 9; i++) {
            ans += d[n][i];
        }
        ans %= mod;
        System.out.println(ans);
    }
}
