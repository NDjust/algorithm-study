package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2352 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] nums = br.readLine().split(" ");

        int[] dp = new int[n + 1];
        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(nums[i-1]);

            for (int j = 1; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        int max = 0;

        for (int i = 1; i <= n; i++) {
            max = Math.max(dp[i], max);
        }

        System.out.println(max + 1);
    }

}
