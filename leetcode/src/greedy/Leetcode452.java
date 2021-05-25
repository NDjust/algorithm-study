package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcode452 {

    public static void main(String[] args) {
        Leetcode452 leetcode452 = new Leetcode452();

        int[][] points = new int[][]{
                {1, 2}, {3, 4}, {5, 6}, {7, 8}
        };

        System.out.println(leetcode452.findMinArrowShots(points));
    }

    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        if (n <= 1)
            return n;
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int count = 1;
        int start = Integer.MIN_VALUE;
        int end = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (points[i][1] < start || points[i][0] > end) {
                count++;
                start = Integer.MIN_VALUE;
                end = Integer.MAX_VALUE;
                i--;
            } else {
                if (start < points[i][0])
                    start = points[i][0];
                if (end > points[i][1])
                    end = points[i][1];
            }
        }
        return count;
    }
}
