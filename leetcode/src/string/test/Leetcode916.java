package string.test;

import java.util.*;

public class Leetcode916 {
    public List<String> wordSubsets(String[] A, String[] B) {
       int[] bMaxCount = new int[26];

        for (int i = 0; i < B.length; i++) {
            String word = B[i];
            int[] bCount = new int[26];

            for (char c : word.toCharArray()) {
                bCount[c - 'a']++;
            }

            for (int j = 0; j < 26; j++) {
                bMaxCount[j] = Math.max(bMaxCount[j], bCount[j]);
            }
        }

        List<String> ans = new ArrayList<>();
        loop:
        for (String s : A) {
            int[] aCount = new int[26];

            for (char c : s.toCharArray()) {
                aCount[c - 'a']++;
            }

            for (int j = 0; j < 26; j++) {
                if (aCount[j] < bMaxCount[j]) {
                    continue loop;
                }
            }

            ans.add(s);
        }
        return ans;
    }

    public static void main(String[] args) {
        Leetcode916 leetcode916 = new Leetcode916();
        String[] a = {"amazon", "apple", "facebook", "google", "leetcode"};
        List<String> A = Arrays.asList(a);
        String[] b = {"e","oo"};
        List<String> B = Arrays.asList(b);
        leetcode916.wordSubsets(a, b);
    }
}
