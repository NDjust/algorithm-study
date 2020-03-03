package Dynamic.step2;

import java.util.Scanner;

public class baekjoon2240 {

    public static int go(int n, int m, int[] a, int[][] d, int sec, int turn) {
        if (sec == n+1 && turn <= m) {
            return 0;
        }

        if (turn > m) {
            return 0;
        }

        if (d[sec][turn] != -1) {
            return d[sec][turn];
        }

        int where = turn % 2 + 1;
        d[sec][turn] = Math.max(go(n,m,a,d,sec+1,turn),
                go(n,m,a,d,sec+1,turn+1))
                + (where == a[sec] ? 1 : 0);

        return d[sec][turn];
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[]a = new int[n+1];

        for (int i=1; i<=n; i++) {
            a[i] = sc.nextInt();
        }

        int[][] d = new int[n+1][m+1];

        for (int i=0; i<=n; i++) {
            for (int j=0; j<=m; j++) {
                d[i][j] = -1;
            }
        }

        System.out.println(Math.max(go(n,m,a,d,0,0),
                go(n,m,a,d,0,1)));
    }

}
