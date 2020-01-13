package DivideConquer;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class baekjoon1992 {

    public static int[][] a = new int[100][100];

    public static boolean same(int x, int y, int n) {
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (a[x][y] != a[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void solve(int x, int y, int n) {
        if (same(x, y, n)) {
            System.out.printf("%d", a[x][y]);
        } else {
            System.out.printf("(");
            int m = n / 2;

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    solve(x + m * i, y + m * i, m);
                }
            }
            System.out.printf(")");
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        solve(0, 0, n);
        System.out.println();

    }
}
