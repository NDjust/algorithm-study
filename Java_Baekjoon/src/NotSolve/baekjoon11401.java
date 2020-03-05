package NotSolve;

import java.util.Scanner;

public class baekjoon11401 {
    private static long MOD = 1000000007L;

    public static long fac(long n) {
        long ans = 1;

        for (int i = 2; i < n + 1; i++) {
            ans = (ans * i) % MOD;
        }

        return ans;
    }

    public static long pow(long x, long y) {
        long ans = 1;

        while (y > 0) {
            if (y % 2 == 1) {
                ans = (ans * x) % MOD;
            }
            x = (x*x) % MOD;
            y = y / 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        long a = fac(n);
        long b = fac(k);
        long c = fac(n - k);



        System.out.println((a*pow(b*c, MOD-2)) % MOD);
    }
}
