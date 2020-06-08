package practice.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LongestNode {


    private boolean[] visited;

    private int[] visitedCount;

    private int max;

    public int solution(int n, int[][] edge) {
        int ans = 0;
        visited = new boolean[n + 1];
        visitedCount = new int[n + 1];

        List<List<Integer>> nodes = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int[] vertex : edge) {
            int nodeOne = vertex[0];
            int nodeTwo = vertex[1];

            nodes.get(nodeOne).add(nodeTwo);
            nodes.get(nodeTwo).add(nodeOne);
        }

        bfs(nodes);

        for (int i : visitedCount) {
            if (max == i) {
                ans++;
            }
        }

        return ans;
    }

    private void bfs(List<List<Integer>> nodes) {
        Queue<Integer> queue = new LinkedList<>();
        visited[1] = true;
        queue.add(1);

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            for (Integer next : nodes.get(poll)) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    visitedCount[next] = visitedCount[poll] + 1;
                    max = visitedCount[next];
                }
            }
        }
    }


    public static void main(String[] args) {
        LongestNode node = new LongestNode();
        int[][] edge = new int[][] {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println(node.solution(6, edge));
    }
}
