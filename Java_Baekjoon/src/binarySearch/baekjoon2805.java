package binarySearch;

import java.util.Scanner;

public class baekjoon2805 {

    public static boolean check(long[] a, long m, long x) {
        long sum = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] - x > 0) {
                sum += a[i] - x;
            }
        }

        return sum >= m;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long m = sc.nextLong();
        long[] a = new long[n];
        long l = 0;
        long r = 0;
        long ans = 0;

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
            r = Math.max(r, a[i]);
        }

        while (l <= r) {
            long mid = (l + r) / 2;

            if (check(a, m, mid)) {
                ans = Math.max(ans, mid);
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        System.out.println(ans);
    }
}
