package dp;

import java.util.Arrays;

public class Leetcode1402 {

    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int maxValue = 0;

        for (int i = 0; i < satisfaction.length; i++) {
            maxValue = Math.max(getSum(satisfaction, i), maxValue);
        }
        return maxValue;
    }

    public int dynamicSolution(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int[] dp = new int[satisfaction.length];
        dp[0] = getSum(satisfaction, 0);

        for (int i = 1; i < satisfaction.length; i++) {
           dp[i] = getSum(satisfaction, i);

           if (dp[i-1] >= dp[i]) {
               return dp[i-1];
           }
        }
        return 0;
    }

    public int getSum(int[] satisfaction, int start) {
        int sum = 0;
        int time = 1;
        for (int j = start; j < satisfaction.length; j++) {
            sum += time * satisfaction[j];
            time++;
        }

        return sum;
    }

    public static void main(String[] args) {
        Leetcode1402 leetcode1402 = new Leetcode1402();
        int[] satisfaction = {-1,-8,0,5,-9};
        int i = leetcode1402.maxSatisfaction(satisfaction);
        int i1 = leetcode1402.dynamicSolution(satisfaction);

        System.out.println(i);
        System.out.println(i1);
    }
}
