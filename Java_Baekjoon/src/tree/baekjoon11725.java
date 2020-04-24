package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon11725 {
    private static ArrayList<ArrayList<Integer>> list;
    private static int[] parent;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        parent = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
//        bfs(1);
        dfs(1, 0);
        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }

    }

    public static void bfs(int r) {
        Queue<Integer> queue = new LinkedList<>();
        parent[r] = r;
        queue.add(r);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (Integer next : list.get(current)) {
                if (parent[next] == 0) {
                    parent[next] = current;
                    queue.add(next);
                }
            }
        }
    }

    public static void dfs(int current, int parentNum) {
        parent[current] = parentNum;

        for (Integer next : list.get(current)) {
            if (next != parentNum) {
                dfs(next, current);
            }
        }
    }
}
