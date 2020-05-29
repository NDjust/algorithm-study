package dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        int[][] dp = new int[left.length+1][right.length+1];

        for (int i = left.length - 1; i >= 0; i--) {
            for (int j = right.length - 1; j >= 0; j--) {
                if (left[i] > right[j]) {
                    dp[i][j] = dp[i][j+1] + right[j];
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i+1][j+1]);
                }
            }
        }

        return dp[0][0];
    }
}