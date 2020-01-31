package BruteForce;

import java.util.Scanner;

public class baekjoon9663 {
    static boolean[][] a = new boolean[15][15];
    static private int n;
    static private int ans = 0;


    public static boolean check(int row, int col) {
        // |
        for (int i = 0; i < n; i++) {
            if (i == row) {
                continue;
            }

            if (a[i][col]) {
                return false;
            }
        }

        // 왼 위 대각선
        int x = row - 1;
        int y = col - 1;

        while (x >= 0 && y >= 0) {
            if (a[x][y] == true) {
                return false;
            }

            x--;
            y--;
        }

        // 오른쪽 대각선 위
        x = row - 1;
        y = col + 1;

        while (x >= 0 && y < n) {
            if (a[x][y] == true) {
                return false;
            }

            x--;
            y++;
        }

        return true;
    }

    public static void calc(int row) {
        if (row == n) {
            ans++;
        }

        for (int col = 0; col < n; col++) {
            a[row][col] = true;
            if (check(row, col)) {
                calc(row + 1);
            }
            a[row][col] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        calc(0);
        System.out.println(ans);
    }
}
