package bfsdfs;

import java.util.*;

public class Leetcode743 {

    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] t : times) {
            int from = t[0];
            int to = t[1];
            int weight = t[2];
            map.putIfAbsent(from, new HashMap<>());
            map.get(from).put(to, weight);
        }

        int[] res = new int[N + 1];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[K] = 0;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{K, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int node = cur[0];
            int weight = cur[1];

            for (int next : map.getOrDefault(node, new HashMap<>()).keySet()) {
                int w = map.get(node).get(next);
                if (w + weight < res[next]) {
                    res[next] = w + weight;
                    queue.offer(new int[]{next, w + weight});
                }
            }
        }
        int max = 0;

        for (int i = 1; i <= N; ++i) {
            if (res[i] == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(max, res[i]);
        }

        return max;
    }


    public static void main(String[] args) {
        Leetcode743 leetcode743 = new Leetcode743();
        int[][] times = new int[][] {
                {1,2,1},{2,1,3}
        };
        int N = 2;
        int K = 2;
        int i = leetcode743.networkDelayTime(times, N, K);
        System.out.println(i);
    }
}
