package Dynamic.step1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class baekjoon9465 {

    public static void otherMethod() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long[][] a = new long[n+1][2];
            {
                String[] line = br.readLine().split(" ");
                for (int i=1; i<=n; i++) {
                    a[i][0] = Long.parseLong(line[i-1]);
                }
            }
            {
                String[] line = br.readLine().split(" ");
                for (int i=1; i<=n; i++) {
                    a[i][1] = Long.parseLong(line[i-1]);
                }
            }
            long[][] d = new long[n+1][3];
            for (int i=1; i<=n; i++) {
                d[i][0] = Math.max(d[i-1][0],Math.max(d[i-1][1],d[i-1][2])); // 뜯지 않음
                d[i][1] = Math.max(d[i-1][0],d[i-1][2])+a[i][0]; // 위쪽 스티커 뜯음
                d[i][2] = Math.max(d[i-1][0],d[i-1][1])+a[i][1]; // 아래쪽 스티커 뜯음
            }
            long ans = 0;
            ans = Math.max(d[n][0], Math.max(d[n][1], d[n][2]));
            System.out.println(ans);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int columns = Integer.parseInt(br.readLine());

            long[][] a = new long[2][columns + 1];
            long[][] d= new long[2][columns + 1];

            {
                String[] line = br.readLine().split(" ");
                for (int j = 1; j <= columns; j++) {
                    a[0][j] = Long.parseLong(line[i - 1]);

                }
            }

            {
                String[] line = br.readLine().split(" ");
                for (int j = 1; j <= columns; j++) {
                    a[1][j] = Long.parseLong(line[i - 1]);
                }
            }


            d[0][1] = a[0][1];
            d[1][1] = a[1][1];

            d[0][2] = a[0][2] + d[1][1];
            d[1][2] = a[1][2] + d[0][1];

            for (int j = 3; j <= columns; j++) {
                d[0][j] = Math.max(d[1][j-1], Math.max(d[0][j-2], d[1][j-2])) + a[0][j];
                d[1][j] = Math.max(d[0][j-1], Math.max(d[0][j-2], d[1][j-2])) + a[1][j];
            }

            System.out.println(Math.max(d[0][columns], d[1][columns]));
        }
    }
}
