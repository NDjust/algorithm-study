package dp;

public class Leetcode1143 {
    public int longestCommonSubsequence(String text1, String text2)  {
        int A = text1.length();
        int B = text2.length();
        int[][] dp = new int[A+1][B+1];

        for (int i = 1; i <= A; i++) {
            for (int j = 1; j <= B; j++) {

                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[A][B];
    }


    public static void main(String[] args) {
        Leetcode1143 leetcode1143 = new Leetcode1143();

        int i = leetcode1143.longestCommonSubsequence("abcde", "ace");

        System.out.println(i);
    }
}
