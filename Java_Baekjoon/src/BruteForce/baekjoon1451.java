package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon1451 {

    private static int n;

    private static int m;

    private static int[][] squareNumbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        squareNumbers = new int[n][m];
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            String rows = br.readLine();

            for (int j = 0; j < rows.length(); j++) {
                squareNumbers[i][j] = rows.charAt(j) - '0';
            }
        }

        // -|
        // --
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < m-1; j++) {
                int firstSquareSum = squareSumInner(0, i, 0, j);
                int twiceSquareSum = squareSumInner(0, i, j+1, m);
                int thirdSquareSum = squareSumInner(i+1, n,0, m);
                int result = firstSquareSum * twiceSquareSum * thirdSquareSum;

                if (result > ans) {
                    ans = result;
                }
            }
        }

        // - |
        // - |
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < m-1; j++) {
                int firstSquareSum = squareSumInner(0, i, 0, j);
                int twiceSquareSum = squareSumInner(i+1, n, 0, j);
                int thirdSquareSum = squareSumInner(0, n,j+1, m);
                int result = firstSquareSum * twiceSquareSum * thirdSquareSum;

                if (result > ans) {
                    ans = result;
                }
            }
        }

        // |||
        // a = n
        for (int i = 0; i < m-2; i++) {
            for (int j = i+1; j < m-1; j++) {
                int firstSquareSum = squareSumInner(0, n, 0, i);
                int twiceSquareSum = squareSumInner(0, n, i+1, j);
                int thirdSquareSum = squareSumInner(0, n, j+1, m);
                int result = firstSquareSum * twiceSquareSum * thirdSquareSum;

                if (result > ans) {
                    ans = result;
                }

            }
        }

        // | -
        // | -
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < m-1; j++) {
                int firstSquareSum = squareSumInner(0, n, 0, j);
                int twiceSquareSum = squareSumInner(0, i, j+1, m);
                int thirdSquareSum = squareSumInner(i+1, n,j+1, m);
                int result = firstSquareSum * twiceSquareSum * thirdSquareSum;

                if (result > ans) {
                    ans = result;
                }
            }
        }

        // --
        // ||
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < m-1; j++) {
                int firstSquareSum = squareSumInner(0, i, 0, m);
                int twiceSquareSum = squareSumInner(i+1, n, 0, j);
                int thirdSquareSum = squareSumInner(i+1, n,j+1, m);
                int result = firstSquareSum * twiceSquareSum * thirdSquareSum;

                if (result > ans) {
                    ans = result;
                }
            }
        }
        // -
        // -
        // -
        // k = m
        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < n-1; j++) {
                int firstSquareSum = squareSumInner(0, i, 0, m);
                int twiceSquareSum = squareSumInner(i+1, j, 0, m);
                int thirdSquareSum = squareSumInner(j+1, n, 0, m);
                int result = firstSquareSum * twiceSquareSum * thirdSquareSum;

                if (result > ans) {
                    ans = result;
                }

            }
        }
        System.out.println(ans);
    }

    private static int squareSumInner(int x, int dx, int y, int dy) {
        int sum = 0;

        for (int i = x; i < dx; i++) {
            for (int j = y; j < dy; j++) {
                sum += squareNumbers[i][j];
            }
        }
        return sum;
    }
}
