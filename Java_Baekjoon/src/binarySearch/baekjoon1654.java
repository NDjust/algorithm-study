package binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class baekjoon1654 {

    public static boolean check(long[] a, int m, long x) {
        int cnt = 0;
        for (int i = 0; i < a.length; i++) {
            cnt += a[i] / x;
        }
        return cnt >= m;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        long[] lan = new long[k];
        long max = 0;
        for (int i = 0; i < k; i++) {
            lan[i] = sc.nextLong();
            max = Math.max(max, lan[i]);
        }

        long l = 0;
        long r = max;
        long ans = 0;

        while (l <= r) {
            long mid = (l + r) / 2;
            if (check(lan, n, mid)) {
                ans = Math.max(ans, mid);
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
