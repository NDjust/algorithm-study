package Graph;

import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class baekjoon7576 {

    public static int[][] area;

    public static boolean[][] visited;

    public static int m;

    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().trim().split(" ");
        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);

        area = new int[n][m];
        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            input = br.readLine().trim().split(" ");
            for (int j = 0; j < m; j++) {
                area[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (area[i][j] == 1) {
                    bfs(i, j);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (area[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                if (max < area[i][j]) {
                    max = area[i][j];
                }
            }
        }
        System.out.println(max-1);
    }


    public static void bfs(int a, int b) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(a, b));

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int mx = p.x + dx[i];
                int my = p.y + dy[i];

                if (mx >= 0 && mx < n && my < m && my >= 0) {
                    if ((area[mx][my] == 0 || area[mx][my] > area[p.x][p.y] + 1)) {
                        area[mx][my] = area[p.x][p.y] + 1;
                        queue.offer(new Point(mx, my));
                    }
                }
            }
        }
    }
}
