package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon11501 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] values = br.readLine().split(" ");
            int[] cost = new int[n];
            long ans = 0;
            int max = 0;

            for (int j = 0; j < n; j++) {
                cost[j] = Integer.parseInt(values[j]);
            }

            for (int j = n - 1; j > -1; j--) {
                if (cost[j] > max) {
                    max = cost[j];
                } else {
                    ans += max - cost[j];
                }
            }

            System.out.println(ans);
        }
    }
}
