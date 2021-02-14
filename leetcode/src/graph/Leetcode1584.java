package graph;



import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Leetcode1584 {

    Set<Integer> vis;
    PriorityQueue<Pair> pq;

    public int minCostConnectPoints(int[][] points) {
        vis = new HashSet<>();
        pq = new PriorityQueue<>(Comparator.comparingInt(Pair::getDist));
        vis.add(0);
        getDistance(points, 0);
        int cnt = 0;
        int cost = 0;

        while (cnt != points.length - 1) {
            Pair p = pq.poll();
            int dist = p.getDist();
            int[] s = p.getPoint();
            int point = s[1];

            if (vis.contains(point)) {
                continue;
            }

            cnt += 1;
            cost += dist;
            vis.add(point);
            getDistance(points, point);
        }

        return cost;
    }

    public void getDistance(int[][] points, int idx) {
        for (int i = 0; i < points.length; i++) {
            if (i != idx && (!vis.contains(i))) {
                int[] s = new int[] {idx, i};
                int dist = Math.abs(points[i][0] - points[idx][0]) + Math.abs(points[i][1] - points[idx][1]);
                pq.add(new Pair(s, dist));
            }
        }
    }

    private static class Pair {
        int[] point;
        int dist;

        public Pair(final int[] point, final int dist) {
            this.point = point;
            this.dist = dist;
        }

        public int getDist() {
            return dist;
        }

        public int[] getPoint() {
            return point;
        }
    }
}
