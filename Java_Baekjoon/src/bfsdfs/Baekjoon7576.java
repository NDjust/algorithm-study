package bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Parameter;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon7576 {

    private static int[][] dxdy = new int[][] {
            {0,1},{1,0},
            {0,-1},{-1,0}
    };

    private static int[][] box;

    private static int m;

    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        m = Integer.parseInt(nm[0]);
        n = Integer.parseInt(nm[1]);

        box = new int[n][m];


        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(row[j]);
            }
        }


        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 1) {
                    queue.add(new Pair(i, j));
                }
            }
        }

        System.out.println(bfs(queue));
    }

    private static int bfs(Queue<Pair> queue) {
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            Pair poll = queue.poll();

            for (int[] move : dxdy) {
                int dx = poll.x + move[0];
                int dy = poll.y + move[1];


                if (dx < 0 || dy < 0 || dx >= n || dy >= m || box[dx][dy] == -1) {
                    continue;
                }

                if (box[dx][dy] == 0) {
                    box[dx][dy] = box[poll.x][poll.y] + 1;
                    queue.add(new Pair(dx, dy));

                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 0) {
                    return -1;
                }

                max = Math.max(max, box[i][j]);
            }
        }

        return  max-1;
    }


    static class Pair {
        int x;
        int y;

        public Pair(final int x, final int y) {
            this.x = x;
            this.y = y;
        }
    }
}
