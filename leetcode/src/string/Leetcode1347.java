package string;

public class Leetcode1347 {

    public int minSteps(String s, String t) {
        int[] alphabet = new int[26];

        for (char c : s.toCharArray()) {
            alphabet[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            alphabet[c - 'a']--;
        }

        int ans = 0;

        for (int i : alphabet) {
            ans += Math.abs(i);
        }
        return ans / 2;
    }

    public static void main(String[] args) {
        Leetcode1347 leetcode1347 = new Leetcode1347();
        int i = leetcode1347.minSteps("bab", "aba");

        System.out.println(i);

    }
}
