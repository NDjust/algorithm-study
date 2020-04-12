package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baekjoon11724 {

    private static ArrayList<ArrayList<Integer>> node = new ArrayList<>();
    private static boolean[] visited;
    private static int visitCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            node.add(new ArrayList<>());
        }

        visited = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            StringTokenizer stn = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stn.nextToken());
            int y = Integer.parseInt(stn.nextToken());

            node.get(x).add(y);
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                bfs(i);
                visitCount++;
            }
        }

        System.out.println(visitCount);
    }

    public static void bfs(int r){
        visited[r] = true;

        for (Integer i : node.get(r)) {
            if (!visited[i]) {
                bfs(i);
            }
        }
    }
}
