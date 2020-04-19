package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class baekjoon4963 {

    public static int[][] map;

    public static boolean[][] visited;

    public static int count;

    public static int w;

    public static int h;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        while (true) {
            w = sc.nextInt();
            h = sc.nextInt();
            map = new int[h+1][w+1];
            visited = new boolean[h+1][w+1];
            count = 0;

            if (w == 0 && h == 0) {
                break;
            }

            for (int i = 1; i <= h; i++) {
                for (int j = 1; j <= w; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            for (int i = 1; i <= h; i++) {
                for (int j = 1; j <= w; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        count += dfs(i, j);
                    }
                }
            }

            System.out.println(count);
        }

    }

    private static int dfs(int x, int y) {
        visited[x][y] = true;
        int[] dx= {1,1,0,-1,-1,-1,0,1};
        int[] dy= {0,1,1,1,0,-1,-1,-1};

        for (int k = 0; k < 8; k++) {
            int mx = dx[k] + x;
            int my = dy[k] + y;

            if (mx <= h && my <= w && mx > 0 && my >0) {
                if (map[mx][my] == 1 && !visited[mx][my]) {
                    dfs(mx, my);
                }
            }
        }
        return 1;
    }
}
