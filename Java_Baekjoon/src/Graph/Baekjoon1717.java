package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1717 {

    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        parent = new int[n];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int w = Integer.parseInt(input[0]);
            int x = Integer.parseInt(input[1]);
            int y = Integer.parseInt(input[2]);

            if (w == 1) {
                System.out.println(isSameParent(x, y) ? "YES" : "NO");
            }

            if (w == 0) {
                union(x, y);
            }
        }
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
        }
    }

    private static boolean isSameParent(final int x, final int y) {
        int xParent = find(x);
        int yParent = find(y);

        return xParent == yParent;
    }

    private static int find(final int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }
}
