package BruteForce;

import java.util.Scanner;

public class baekjoon1182 {

    public static int go(int[] a, int m, int i, int sum) {
        if (i == a.length) {
            if (sum == m) {
                return 1;
            } else {
                return 0;
            }
        }
        return go(a, m, i + 1, sum + a[i]) + go(a, m, i + 1, sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int ans = go(a, m, 0, 0);

        if (m == 0) {
            ans -= 1;
        }
        System.out.println(ans);

    }

    public static void bitMask() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int ans = 0;

        for (int i = 0; i < (1<<n); i++) {
            int sum = 0;

            for (int j = 0; j < n; j++) {
                if ((i & (1<<j)) != 0) {
                    sum += a[j];
                }
            }
            if (sum == s) {
                ans += 1;
            }
        }
        System.out.println(ans);
    }
}
