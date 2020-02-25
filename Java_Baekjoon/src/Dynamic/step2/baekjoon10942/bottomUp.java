package Dynamic.step2.baekjoon10942;

import java.util.Scanner;

public class bottomUp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        boolean[][] d = new boolean[n][n];

        for (int i = 0; i < n; i++) { // 길이가 1인 경우 처리.
            d[i][i] = true;
        }
        for (int i = 0; i <n-1 ; i++) { // 길이가 2인 경우 처리.
            if (a[i] == a[i+1]) {
                d[i][i+1] = true;
            }
        }

        for (int k = 2; k < n; k++) {  // 길이가 3 이상인 경우.
            for (int i = 0; i < n - k; i++) {
                int j = i + k;
                if (a[i] == a[j] && d[i+1][j-1]) {
                    d[i][j] = true;
                }
            }
        }

        int m = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        while (m-- > 0) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            if (d[s-1][e-1]) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
