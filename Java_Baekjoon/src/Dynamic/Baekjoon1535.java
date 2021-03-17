package Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon1535 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        int[] healthMinusPoint = new int[count + 1];
        int[] happyPoint = new int[count + 1];

        String[] health = br.readLine().split(" ");
        String[] happy = br.readLine().split(" ");

        for (int i = 1; i <= count; i++) {
            healthMinusPoint[i] = Integer.parseInt(health[i - 1]);
            happyPoint[i] = Integer.parseInt(happy[i - 1]);
        }


        int[][] dp = new int[count + 1][100 + 1];

        for (int i = 1; i <= count; i++) {
            for (int j = 1; j <= 100; j++) {
                if (j + healthMinusPoint[i] <= 100) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j + healthMinusPoint[i]] + happyPoint[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[count][1]);
    }
}
