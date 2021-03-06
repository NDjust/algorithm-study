package Dynamic.step2;

import java.util.Scanner;

public class baekjoon2293 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int[] d = new int[k+1];
        d[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j - a[i] >= 0) {
                    d[j] += d[j - a[i]];
                }
            }
        }
        System.out.println(d[k]);
    }
}
