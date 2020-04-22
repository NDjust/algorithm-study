package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class baekjoon2178 {

    public static int n;

    public static int m;

    public static int[][] map;

    public static boolean[][] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        n = Integer.parseInt(st[0]);
        m = Integer.parseInt(st[1]);
        map = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                map[i][j+1] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        bfs();
        System.out.println(map[n][m]);
    }

    public static void bfs() {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, 1));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;

            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i];
                int my = y + dy[i];
                if (mx > 0 && my > 0 && mx <= n && my <= m) {
                    if (!visited[mx][my] && map[mx][my] == 1) {
                        visited[mx][my] = true;
                        map[mx][my] = map[x][y] + 1;
                        queue.add(new Node(mx, my));
                    }
                }
            }
        }
    }
}
