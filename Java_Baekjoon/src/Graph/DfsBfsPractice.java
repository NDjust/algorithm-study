package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DfsBfsPractice {

    private static ArrayList<ArrayList<Integer>> graph;
    private static boolean[] visited;

    public static void main(String[] args) {
        graph = new ArrayList<>();
        visited = new boolean[10];
        for (int i = 0; i < 10; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(1).add(3);
        graph.get(1).add(2);
        graph.get(2).add(1);
        graph.get(2).add(5);
        graph.get(2).add(4);
        graph.get(4).add(2);
        graph.get(4).add(8);
        graph.get(5).add(4);
        graph.get(3).add(1);
        graph.get(3).add(7);
        graph.get(3).add(6);
        graph.get(6).add(3);
        graph.get(6).add(9);
        graph.get(7).add(3);
        graph.get(8).add(4);
        graph.get(9).add(6);
//        dfsStack(1);
//
//        visited = new boolean[10];
//        dfs(1);
//
        visited = new boolean[10];
        bfs(1);
    }

    private static void dfsStack(int r) {
        Stack<Integer> stack = new Stack<>();
        stack.add(r);
        visited[r] = true;

        while (!stack.isEmpty()) {
            int a = stack.pop();
            System.out.println(a);
            for (Integer s : graph.get(a)) {
                if (!visited[s]) {
                    visited[s] = true;
                    stack.add(s);
                }
            }
        }
    }

    private static void dfs(int r) {
        visited[r] = true;
        System.out.println(r);

        for (Integer s : graph.get(r)) {
            if (!visited[s]) {
                visited[s] = true;
                dfs(s);
            }
        }
    }

    private static void bfs(int r) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(r);
        visited[r] = true;

        while (!queue.isEmpty()) {
            int a = queue.poll();
            System.out.println(a);
            for (Integer s : graph.get(a)) {
                if (!visited[s]) {
                    visited[s] = true;
                    queue.add(s);
                }
            }
        }
    }
}


