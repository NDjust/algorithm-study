package DivideConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class baekjoon1780 {

    private static int[] ansNum = new int[3];

    private static boolean isSame(int x, int y, int n, int[][] matrix) {
        for (int i = x; i < x+n; i++) {
            for (int j = y; j < y+n; j++) {
                if (matrix[x][y] != matrix[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void solve(int x, int y, int n, int[][] matrix) {
        if (isSame(x, y, n, matrix)) {
            ansNum[matrix[x][y]+1] += 1;
            return;
        }
        int m = n / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                solve(x+i*m, y+j*m, m, matrix);
            }
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, 0, n, matrix);
        for (int i = 0; i < ansNum.length; i++) {
            System.out.println(ansNum[i]);
        }
    }
}
