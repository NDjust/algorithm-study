package BruteForce;

import java.util.Scanner;

public class baekjoon10971 {

    public static boolean nextPermuatation(int[] a) {
        int i = a.length - 1;

        while (i > 0 && a[i - 1] >= a[i]) {
            i--;
        }

        if (i <= 0) {
            return false;
        }

        int j = a.length - 1;

        while (a[j] <= a[i - 1]) {
            j--;
        }

        int tmp = a[i - 1];
        a[i - 1] = a[j];
        a[j] = tmp;

        j = a.length - 1;

        while (i < j) {
            tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int[][] w = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                w[i][j]= sc.nextInt();
            }
            sc.nextLine();
        }

        int[] d = new int[n];

        for (int i = 0; i < n; i++) {
            d[i] = i;
        }

        int ans = Integer.MAX_VALUE;

        do {
            boolean ok = true;
            int sum = 0;

            for (int i = 0; i < n - 1; i++) {
                if (w[d[i]][d[i + 1]] == 0) {
                    ok = false;
                } else {
                    sum += w[d[i]][d[i + 1]];
                }
            }

            if (ok && w[d[n - 1]][d[0]] != 0) {
                sum += w[d[n - 1]][d[0]];

                if (ans > sum) {
                    ans = sum;
                }
            }

        } while (nextPermuatation(d));

        System.out.println(ans);
    }
}
