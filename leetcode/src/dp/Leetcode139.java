package dp;

import java.util.List;

public class Leetcode139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] hasSequence = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {
            String substring = s.substring(0, i+1);

            if (wordDict.contains(substring)) {
                hasSequence[i] = true;
            } else {
                for (int j = 0; j < i; j++) {
                    hasSequence[i] = hasSequence[j] && wordDict.contains(s.substring(j+1, i+1));
                    if (hasSequence[i]) break;
                }

            }
        }

        return hasSequence[s.length()-1];
    }
}
