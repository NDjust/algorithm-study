package Dynamic.step2.baekjoon11048;

import java.util.Scanner;

// Top-Down Method.
public class Method4 {
    static int[][] a;
    static int[][] d;

    public static int go(int x, int y) {
        if (x == 1 && y ==1) { // Base Value
            return a[1][1];
        }
        if (x < 1 || y < 1) { // 불가능한 경우
            return 0;
        }

        if (d[x][y] >= 0) { // Memoization
            return d[x][y];
        }

        d[x][y] = Math.max(go(x, y - 1), go(x - 1, y)) + a[x][y];
        return d[x][y];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        a = new int[n+1][m+1];
        d = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                a[i][j] = sc.nextInt();
                d[i][j] = -1;
            }
        }

        System.out.println(go(n, m));
    }
}
