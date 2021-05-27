package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Leetcode56 {

    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();

        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));

        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];
            int[] prev = result.get(result.size() - 1);

            if (prev[1] >= next[0]) {
                result.remove(result.size() - 1);
                result.add(new int[] {prev[0], Math.max(prev[1], next[1])});
            } else {
                result.add(new int[] {next[0], next[1]});
            }
        }

        int[][] ans = new int[result.size()][2];

        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        Leetcode56 leetcode56 = new Leetcode56();
        final int[][] merge = leetcode56.merge(new int[][]{
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        });

        for (int[] ints : merge) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
