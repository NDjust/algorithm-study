package Greedy;

import java.util.ArrayList;
import java.util.Stack;

public class DFS {

    private static boolean[] visited;

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        visited = new boolean[11];
        for (int i = 0; i < 10; i++) {
            graph.add(new ArrayList<>());
        }

        // 0번 노드는 더미로 취급하고 1번 노드부터 사용
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(2).add(1);
        graph.get(2).add(4);
        graph.get(2).add(5);
        graph.get(4).add(2);
        graph.get(4).add(8);
        graph.get(5).add(2);
        graph.get(3).add(6);
        graph.get(3).add(7);
        graph.get(6).add(3);
        graph.get(6).add(9);
        graph.get(7).add(3);
        dfs(1, graph);

    }

    private static void dfs(int r, ArrayList<ArrayList<Integer>> graph) {
        Stack<Integer> stack = new Stack<>();
        stack.add(r);
        visited[r] = true;
        System.out.println(r);
        while (!stack.isEmpty()) {
            int pop = stack.pop();

            for (Integer nextNode : graph.get(pop)) {
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    stack.add(nextNode);
                    System.out.println(nextNode);
                }
            }
        }
    }
}
