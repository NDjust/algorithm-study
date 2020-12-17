package string;

import java.util.Arrays;
import java.util.List;

public class Leetcode539 {
    public int findMinDifference(List<String> timePoints) {
        int minDiff = Integer.MAX_VALUE;
        int n = timePoints.size();
        int[] times = new int[n];

        for (int i = 0; i < n; i++) {
            String s = timePoints.get(i);
            String[] hhmm = s.split(":");
            times[i] = Integer.parseInt(hhmm[0]) * 60 + Integer.parseInt(hhmm[1]);
        }

        Arrays.sort(times);

        for (int i = 1; i < n; i++) {
            minDiff = Math.min(minDiff, times[i] - times[i - 1]);
        }
        minDiff = Math.min(minDiff, times[0] + (24*60 - times[n - 1]));
        return minDiff;
    }

    public static void main(String[] args) {
        Leetcode539 leetcode539 = new Leetcode539();
        List<String> timePoints = Arrays.asList("12:12","00:13");
        int minDifference = leetcode539.findMinDifference(timePoints);
        System.out.println(minDifference);
    }
}
