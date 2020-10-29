package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Retiring {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] T = new int[n + 10];
        int[] P = new int[n + 10];

        for (int i = 1; i <= n; i++) {
            String[] s = br.readLine().split(" ");
            T[i] = Integer.parseInt(s[0]);
            P[i] = Integer.parseInt(s[1]);
        }

        int[] dp = new int[n + 10];
        int max = 0;

        for (int i = 1; i <= n + 1; i++) {
            dp[i] = Math.max(max, dp[i]);
            dp[i + T[i]] = Math.max(dp[i] + P[i], dp[i + T[i]]);

            max = Math.max(max, dp[i]);

        }

        System.out.println(max);
    }
}
