package dp;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1641 {

    private List<String> combinations;

    private int n;

    private StringBuilder sb;

    public int countVowelStrings(int n) {
        combinations = new ArrayList<>();
        sb = new StringBuilder();
        this.n = n;
        char[] vowels = new char[] {
                'a', 'e', 'i', 'o', 'u'
        };

        backTracking(0, 0, vowels);

        return combinations.size();
    }

    private void backTracking(int count, int i, final char[] vowels) {

        if (count == n) {
            combinations.add(sb.toString());
            return;
        }

        for (int j = i; j < vowels.length; j++) {
            sb.append(vowels[j]);
            backTracking(count + 1, j, vowels);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        Leetcode1641 leetcode1641 = new Leetcode1641();

        int i = leetcode1641.countVowelStrings(33);
        System.out.println(i);
    }
}
