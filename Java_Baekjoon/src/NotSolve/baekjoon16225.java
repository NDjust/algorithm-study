package NotSolve;

import java.util.Arrays;
import java.util.Scanner;

public class baekjoon16225 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            if (a[i] <= b[i]) {
                ans[i] = a[i];
            } else {
                ans[i] = 0;
            }
        }

        Arrays.sort(ans);
        System.out.println(ans[n - 1] + ans[n - 2]);
    }
}
