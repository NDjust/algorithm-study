package DivideConquer;

import java.util.Scanner;

public class baekjoon2630 {

    static int oneCounts = 0;
    static int zeroCounts = 0;


    public static boolean checkZero(int[][] a, int x, int y, int n) {
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (a[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkOne(int[][] a, int x, int y, int n) {
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (a[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void solve(int[][] a, int x, int y, int n) {
        if (checkOne(a, x, y ,n)) {
            oneCounts++;
        } else if (checkZero(a, x, y, n)) {
            zeroCounts++;
        } else {
            int m = n / 2;

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    solve(a, x + i * m, y + j * m, m);
                }

            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] w = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                w[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }
        solve(w, 0, 0, n);
        System.out.println(zeroCounts);
        System.out.println(oneCounts);

    }
}
