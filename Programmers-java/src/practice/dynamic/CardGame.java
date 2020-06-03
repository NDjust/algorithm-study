package practice.dynamic;

import java.util.Arrays;

public class CardGame {

    private static int[][] dp;

    private static int sum = 0;

    public static int solution(int[] left, int[] right) {
        int ans = 0;
        dp = new int[left.length][right.length];

        for (int i = 0; i < left.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        ans = searchMaxSum(left, right, 0, 0);
        return ans;
    }

    private static int searchMaxSum(int[] left, int[] right, int leftLoc, int rightLoc) {
        if (leftLoc == left.length || rightLoc == right.length) {
            return sum;
        }

        if (dp[leftLoc][rightLoc] != -1) {
            return dp[leftLoc][rightLoc];
        }

        if (left[leftLoc] > right[rightLoc]) {
            int currentSum = searchMaxSum(left, right, leftLoc, rightLoc+1) + right[rightLoc];
            dp[leftLoc][rightLoc] = currentSum;
            return currentSum;
        } else {
            int currentSum = Math.max(searchMaxSum(left, right, leftLoc + 1, rightLoc + 1), searchMaxSum(left, right, leftLoc+1, rightLoc));
            dp[leftLoc][rightLoc] = currentSum;
            return currentSum;
        }
    }

    public static void main(String[] args) {
    }
}


class SolutionBottomUp {
    public int solution(int[] left, int[] right) {
        int answer = 0;
        int[][] dp = new int[left.length + 1][right.length + 1];

        for(int i = 1; i < left.length + 1; i++) {
            for(int j = 1; j < right.length + 1; j++) {
                if(left[left.length - i] > right[right.length - j]) {
                    dp[i][j] = Math.max(dp[i][j - 1] + right[right.length - j], Math.max(dp[i - 1][j], dp[i - 1][j - 1]));
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
                }
            }
        }
        answer = dp[left.length][right.length];
        return answer;
    }
}