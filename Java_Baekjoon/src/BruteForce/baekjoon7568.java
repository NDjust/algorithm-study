package BruteForce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class baekjoon7568 {

    public static int compare(int[] a, int[] b) {
        if (a[0] < b[0] && a[1] < b[1]) {
            return 1;
        } else {
            return 2;
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] info = new int[n][2];
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            info[i][0] = sc.nextInt();
            info[i][1] = sc.nextInt();
        }


        for (int i = 0; i < n; i++) {
            int rank = 1;
            for (int j = 0; j < n; j++) {
                if (compare(info[i], info[j]) == 1) {
                    rank++;
                }
            }
            ans[i] = rank;
        }

        for (int i = 0; i < n; i++) {
            System.out.printf("%d ", ans[i]);
        }


    }
}
