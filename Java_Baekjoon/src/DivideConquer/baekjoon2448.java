package DivideConquer;

import java.util.Scanner;

public class baekjoon2448 {
    private static char BLANK = ' ';
    private static char STAR = '*';

    public static void go(int x, int y, int n, char[][] a, char color) {
        if (color == BLANK) {
            int m = 2*n-1;

            for (int i = x; i < x+n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j+i-x+y] = BLANK;
                }
                m -= 2;
            }
        } else if (color == STAR) {
            if (n != 1) {
                int m = n / 2;
                go(x, y, m ,a, STAR);
                go(x+m, y-m, m ,a, STAR);
                go(x+m, y+m, m ,a, STAR);

                if (n == 3) {
                    go(x+1, y, 1, a, BLANK);
                } else {
                    go(x+m, y-m+1, m, a, BLANK);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        char[][] a = new char[n][2*n];
        go(0, n-1, n, a, STAR);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-i-1; j++) {
                a[i][j] = BLANK;
                a[i][2*n-j-2] = BLANK;
            }
            a[i][2*n-1] = BLANK;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2*n; j++) {
                System.out.printf("%c", a[i][j]);
            }
            System.out.println();
        }
    }
}
