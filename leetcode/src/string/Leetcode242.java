package string;

import java.util.Arrays;

public class Leetcode242 {
    public boolean isAnagram(String s, String t) {
        final char[] sChars = s.toCharArray();
        final char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return Arrays.equals(sChars, tChars);
    }
}
