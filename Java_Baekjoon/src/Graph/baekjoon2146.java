package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class MapPoint {
    int x;
    int y;

    public MapPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class baekjoon2146 {
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static int[][] map;
    private static boolean[][] visited;
    private static int[][] bridge;
    private static int n;
    private static Queue<MapPoint> pointQueue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];
        visited = new boolean[n+1][n+1];
        bridge = new int[n+1][n+1];
        pointQueue = new LinkedList<>();


        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    pointQueue.add(new MapPoint(i, j));
                }
            }
        }

        // 섬 구별하기
        int color = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    coloringBFS(i, j, color);
//                    coloringDFS(i, j, color);
                    color++;
                }
            }
        }
        bfs();
        System.out.println(getMinLength());
    }


    public static int getMinLength() {
        int minCount =  Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 0; k < 4; k++) {
                    int mx = i + dx[k];
                    int my = j + dy[k];

                    if (mx > 0 && my > 0 && mx <= n && my <= n &&
                            map[i][j] != map[mx][my]) {
                        minCount = Math.min(minCount, bridge[i][j] + bridge[mx][my]);
                    }
                }
            }
        }
        return minCount;
    }

    // 영토 확장
    public static void bfs() {
        while (!pointQueue.isEmpty()) {
            MapPoint point = pointQueue.poll();

            for (int i = 0; i < 4; i++) {
                int mx = point.x + dx[i];
                int my = point.y + dy[i];

                if (mx > 0 && my > 0 && mx <= n && my <= n) {
                    if (map[mx][my] == 0 && bridge[mx][my] == 0) {
                        bridge[mx][my] = bridge[point.x][point.y] + 1;
                        map[mx][my] = map[point.x][point.y];
                        pointQueue.add(new MapPoint(mx, my));
                    }
                }
            }
        }
    }

    public static void coloringDFS(int x, int y, int color) {
        map[x][y] = color;

        for (int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];

            if (mx > 0 && my > 0 && mx <= n && my <= n) {
                if (!visited[mx][my] && map[mx][my] == 1) {
                    visited[mx][my] = true;
                    coloringDFS(mx, my, color);
                }
            }
        }
    }

    // 영토 구분
    public static void coloringBFS(int x, int y, int color) {
        Queue<MapPoint> queue = new LinkedList<>();
        map[x][y] = color;
        queue.add(new MapPoint(x, y));

        while (!queue.isEmpty()) {
            MapPoint point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int mx = point.x + dx[i];
                int my = point.y + dy[i];

                if (mx > 0 && my >0 && my <= n && mx <= n) {
                    if (!visited[mx][my] && map[mx][my] == 1) {
                        visited[mx][my] = true;
                        map[mx][my] = color;
                        queue.add(new MapPoint(mx, my));
                    }
                }
            }
        }
    }
}

