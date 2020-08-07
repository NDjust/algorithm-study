package bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baekjoon11724 {

    static boolean[] visited;

    static List<List<Integer>> nodes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        visited = new boolean[n+1];

        for (int i = 0; i <= n; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] node = br.readLine().split(" ");
            int vertex = Integer.parseInt(node[0]);
            int childVertex = Integer.parseInt(node[1]);

            nodes.get(vertex).add(childVertex);
            nodes.get(childVertex).add(vertex);
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                ans++;
                dfs(i);
            }
        }
        System.out.println(ans);
    }

    private static void dfs(final int i) {
        List<Integer> child = nodes.get(i);
        visited[i] = true;
        for (Integer c : child) {
            if (!visited[c]) {
                dfs(c);
            }
        }
    }
}
