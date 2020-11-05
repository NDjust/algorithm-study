package string;

public class Leetcode3 {

    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int counter = 0;
        int max = 0;

        int[] count = new int[256];

        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i)]++ == 0) {
                counter++;
            }

            if (i - start + 1 > counter) {
                if (--count[s.charAt(start++)] == 0) {
                    counter--;
                }
            }

            max = Math.max(max, i - start  +1);
        }

        return max;
    }

    public static void main(String[] args) {
        Leetcode3 leetcode3 = new Leetcode3();

        int abcabcbb = leetcode3.lengthOfLongestSubstring(" ");

        System.out.println(abcabcbb);
    }
}
