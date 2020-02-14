package KakaoCodeFestival;

import java.util.Arrays;
import java.util.Scanner;

public class baekjoon15954 {

    public static double getSd(int[] a, int start, int k) {
        double m = 0;
        double d = 0;

        for (int i = start; i < start + k; i++) {
            m += a[i];
        }

        m = m / k;

        for (int i = start; i < start + k; i++) {
            d += Math.pow(a[i] - m, 2);
        }

        d = Math.sqrt(d / k);

        return d;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        double ans;
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        ans = getSd(a, 0, k);

        while (k <= n){

            for (int i = 0; i <= n - k ; i++) {
                double sd = getSd(a, i , k);

                if (sd < ans) {
                    ans = sd;
                }
            }
            k++;
        }

        System.out.println(ans);

    }
}
