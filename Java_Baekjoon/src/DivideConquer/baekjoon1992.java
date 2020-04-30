package DivideConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon1992 {

    private static int[][] video;

    private static boolean isSame(int x, int y, int n, StringBuilder sb) {
        for (int i = x; i < x+n; i++) {
            for (int j = y; j < y+n; j++) {
                if (video[x][y] != video[i][j]) {
                    return false;
                }
            }
        }
        sb.append(video[x][y]);
        return true;
    }

    private static void compress(int x, int y, int n, StringBuilder sb) {
        if (isSame(x, y, n, sb)) {
            return;
        }

        int m = n / 2;
        sb.append("(");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                compress(x+i*m, y+j*m, m, sb);
            }
        }
        sb.append(")");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        video = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                video[i][j] = s.charAt(j) - 48;
            }
        }
        StringBuilder sb = new StringBuilder();
        compress(0, 0, n, sb);
        System.out.println(sb);
    }
}
