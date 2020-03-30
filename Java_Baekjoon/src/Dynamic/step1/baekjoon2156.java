package Dynamic.step1;

import java.util.Scanner;

public class baekjoon2156 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        int[] d = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }

        d[1] = a[1];

        if (n >= 2) {
            d[2] = a[1] + a[2];
        }

        for (int i = 3; i <= n; i++) {
            d[i] = d[i-1]; // i 번째 잔 마시지 x
            if (d[i] < d[i-2] + a[i]) { // i-1 번째 잔 마시지 x
                d[i] = d[i-2] + a[i];
            }

            if (d[i] < d[i-3] + a[i] + a[i-1]) { // i-2 번째 잔 마시지 x
                d[i] = d[i-3] + a[i] + a[i-2];
            }
        }

        int ans = d[1];

        for (int i = 2; i <= n; i++) {
            ans = Math.max(ans, d[i]);
        }
        System.out.println(ans);

    }
}
