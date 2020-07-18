package string.test;

import java.util.Arrays;

public class Leetcode899 {
    public String orderlyQueue(String S, int K) {
        if (K == 1) {
            String ans = S;
            for (int i = 0; i < S.length(); i++) {
                String substring = S.substring(i) + S.substring(0, i);

                if (ans.compareTo(substring) > -1) {
                    ans = substring;
                }
            }

            return ans;
        } else {
            char[] chars = S.toCharArray();
            Arrays.sort(chars);

            return new String(chars);
        }
    }

    public static void main(String[] args) {
        Leetcode899 leetcode899 = new Leetcode899();

        String aba = leetcode899.orderlyQueue("cba", 1);
        System.out.println(aba);
    }
}
