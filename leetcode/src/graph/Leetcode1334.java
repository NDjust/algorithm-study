package graph;

import java.util.*;

public class Leetcode1334 {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int ans = 0;
        List<Edge>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];

            graph[from].add(new Edge(to, weight));
            graph[to].add(new Edge(from, weight));
        }

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
            boolean[] check = new boolean[n];
            Edge[] D = new Edge[n];

            for (int j = 0; j < n; j++) {
                if (i == j) {
                    D[j] = new Edge(j, 0);
                    pq.add(D[j]);
                } else {
                    D[j] = new Edge(j, Integer.MAX_VALUE);
                }
            }

            while (!pq.isEmpty()) {
                Edge edge = pq.poll();

                if (check[edge.to]) {
                    continue;
                }

                check[edge.to] = true;

                for (Edge next : graph[edge.to]) {
                    if (D[next.to].weight > D[edge.to].weight + next.weight) {
                        D[next.to].weight = D[edge.to].weight + next.weight;
                        pq.add(new Edge(D[next.to].to, D[next.to].weight));
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (D[j].weight <= distanceThreshold) {
                    result[i]++;
                }
            }
        }

        int smallest = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (result[i] <= smallest) {
                ans = i;
                smallest = result[i];
            }
        }

        return ans;
    }

    private static class Edge {
        int to;
        int weight;

        public Edge(final int to, final int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "to=" + to +
                    ", weight=" + weight +
                    '}';
        }
    }

    public static void main(String[] args) {
        Leetcode1334 leetcode1334 = new Leetcode1334();
        int n = 4;
        int distanceThreshold = 4;
        int[][] edges = new int[][] {
                {0,1,3},
                {1,2,1},
                {1,3,4},
                {2,3,1},
        };

        int theCity = leetcode1334.findTheCity(n, edges, distanceThreshold);

        System.out.println(theCity);
    }
}
