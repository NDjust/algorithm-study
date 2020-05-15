package practice.dfsbfs;

import java.util.ArrayList;

public class Network {

    public static boolean[] visited;

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();
        visited = new boolean[n];
        int a = computers.length;
        int b = computers[0].length;

        for (int i = 0; i < n; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (computers[i][j] == 1 && i != j) {
                    nodes.get(i).add(j);
                    nodes.get(j).add(i);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, nodes);
                answer++;
            }
        }

        return answer;
    }

    public static void dfs(int r, ArrayList<ArrayList<Integer>> nodes) {
        visited[r] = true;

        for (Integer next : nodes.get(r)) {
            if (!visited[next]) {
                dfs(next, nodes);
            }
        }
    }
}
