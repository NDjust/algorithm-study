package sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class Leetcode973 {

    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        PriorityQueue<Point> queue = new PriorityQueue<>(Comparator.comparingDouble(o -> o.distance));

        Arrays.stream(points)
                .forEach(point -> queue.add(new Point(calculateDistance(point), point)));

        for (int i = 0; i < k; i++) {
            result[i] = Objects.requireNonNull(queue.poll()).location;
        }

        return result;
    }
    private double calculateDistance(final int[] point) {
        return Math.sqrt(point[0] * point[0] + point[1] * point[1]);
    }

    private static class Point {
        double distance;
        int[] location;

        public Point(final double distance, final int[] location) {
            this.distance = distance;
            this.location = location;
        }
    }

    public static void main(String[] args) {
        Leetcode973 leetcode973 = new Leetcode973();
        final int[][] ints = leetcode973.kClosest(new int[][]{
                {3, 3}, {5, -1}, {-2, 4}
        }, 2);

        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }
}
