package backtracking;

import java.util.*;

public class Leetcode1291 {

    public List<Integer> sequentialDigits(int low, int high) {
        String digits = "123456789";
        List<Integer> ans = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            for (int j = 0; j + i <= 9; j++) {
                String substring = digits.substring(j, i+j);
                int value = Integer.parseInt(substring);
                if (value >= low && value <= high) {
                    ans.add(value);
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Leetcode1291 leetcode1291 = new Leetcode1291();
        int pow = (int) Math.pow(10, 9);
        System.out.println(pow);
        leetcode1291.sequentialDigits(100, pow);
    }
}
