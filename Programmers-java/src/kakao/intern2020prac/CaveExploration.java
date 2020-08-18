package kakao.intern2020prac;

import java.util.ArrayList;
import java.util.List;

public class CaveExploration {

    private boolean[] visited;

    private int[][] inputOrder;

    private int[] parent;

    private List<List<Integer>> graph = new ArrayList<>();
    public boolean solution(int n, int[][] path, int[][] order) {
        boolean answer = true;
        inputOrder = order;
        visited = new boolean[n];
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] node : path) {
            graph.get(node[0]).add(node[1]);
        }

        visited[0] = true;

        for (int i = 0; i < order.length; i++) {
            dfs(0);
        }


        for (boolean b : visited) {
            System.out.print(b + " ");
        }


        return answer;
    }

    private void dfs(final int i) {
        List<Integer> connectNodes = graph.get(i);

        if (connectNodes.isEmpty()) {
            System.out.println(String.format("i : %d , parent[%d] : %d", i, i, parent[i]));
            dfs(parent[i]);
        }

        for (Integer connectNode : connectNodes) {
            if (!visited[connectNode]) {
                int previousVisitNode = getPreviousVisitNode(connectNode);

                if (previousVisitNode != -1 && visited[previousVisitNode]) {
                    visited[connectNode] = true;
                    parent[connectNode] = parent[i];
                    dfs(connectNode);
                }

                if (previousVisitNode == -1) {
                    visited[connectNode] = true;
                    parent[connectNode] = parent[i];
                    dfs(connectNode);
                }
            }
        }
    }

    private int getPreviousVisitNode(final Integer connectNode) {
        for (int[] order : inputOrder) {
            if (connectNode == order[1]) {
                return order[0];
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        CaveExploration exploration = new CaveExploration();
        int n = 9;
        int[][] path = new int[][] {{0,1},{0,3},{0,7},{8,1}, {3,6}, {1,2},{4,7},{7,5}};
        int[][] order = new int[][] {{8,5},{6,7},{4,1}};
        exploration.solution(n, path, order);
    }
}
