package Graph;

import java.util.*;

public class GraphPractice {

    public static boolean[] visited;

    public static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) {
        visited = new boolean[8];

        graph = new ArrayList<>();
        for (int i = 0; i <= 7; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(2).add(1);
        graph.get(2).add(2);
        graph.get(2).add(3);
        graph.get(2).add(4);
        graph.get(2).add(5);
        graph.get(3).add(1);
        graph.get(3).add(2);
        graph.get(3).add(6);
        graph.get(3).add(7);
        graph.get(4).add(2);
        graph.get(4).add(5);
        graph.get(5).add(2);
        graph.get(5).add(4);
        graph.get(6).add(3);
        graph.get(6).add(7);
        graph.get(7).add(3);
        graph.get(7).add(6);

        dfsStack(1);
        System.out.println("=====DFS Recursive=====");
        visited = new boolean[8];
        dfsRecursive(1);
        visited = new boolean[8];
        bfs(1);

    }

    public static void dfsStack(int r) {
        Stack<Integer> stack = new Stack<>();
        stack.add(r);
        visited[r] = true;
        System.out.println(r);
        while (!stack.isEmpty()) {
            int a = stack.pop();

            for (Integer integer : graph.get(a)) {
                if (!visited[integer]) {
                    visited[integer] = true;
                    stack.add(integer);
                    System.out.println(integer);
                }
            }
        }
    }

    public static void dfsRecursive(int r) {
        if (visited[r]) {
            return;
        }
        visited[r] = true;
        System.out.println(r);
        for (Integer integer : graph.get(r)) {
            dfsRecursive(integer);
        }
    }

    public static void bfs(int r) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(r);
        visited[r] = true;

        System.out.println(r);
        while (!queue.isEmpty()) {
            int a = queue.poll();

            for (Integer integer : graph.get(a)) {
                if (!visited[integer]) {
                    visited[integer] = true;
                    queue.add(integer);
                    System.out.println(integer);
                }
            }
        }

    }
}
