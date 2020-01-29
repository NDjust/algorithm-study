package BruteForce;

import java.util.ArrayList;
import java.util.Scanner;

public class baekjoon6603 {

    public static boolean nextPermutation(int[] a) {
        int i = a.length - 1;

        while (i > 0 && a[i - 1] <= a[i]) {
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

        while (true) {
            int n = sc.nextInt();
            int[] testCase = new int[n];

            if (n == 0) {
                break;
            }

            for (int i = 0; i < n; i++) {
                testCase[i] = sc.nextInt();
            }

            int[] d = new int[n];

            for (int i = 0; i < n - 6; i++) {
                d[i] = 0;
            }

            for (int i = n - 6; i < n; i++) {
                d[i] = 1;
            }

            ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

            do {
                ArrayList<Integer> current = new ArrayList<Integer>();

                for (int i = 0; i < n; i++) {
                    if (d[1] == 1) {
                        current.add(testCase[i]);
                    }
                }
                ans.add(current);
            } while (nextPermutation(d));

        }
    }
}
