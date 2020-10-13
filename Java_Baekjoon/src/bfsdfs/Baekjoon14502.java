package bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon14502 {

    private static int[][] board;

    private static int[][] dxdy = {
            {1, 0}, {0, 1},
            {-1, 0}, {0, -1}
    };

    private static int[][] copyBoard;

    private static List<Point> virusPoints;

    private static int maxSafeAreaCount = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        board = new int[n][m];
        virusPoints = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(line[j]);
                if (board[i][j] == 2) {
                    virusPoints.add(new Point(i, j));
                }
            }
        }

        dfs(0, 0);
        System.out.println(maxSafeAreaCount);
    }

    private static void dfs(final int start, int count) {
        if (count == 3) {
            copyArray();
            for (Point virusPoint : virusPoints) {
                spreadVirus(virusPoint.x, virusPoint.y);
            }
            maxSafeAreaCount = Math.max(getMaxSafeArea(), maxSafeAreaCount);
            return;
        }


        for (int k = start; k < board.length * board[0].length; k++) {
            int x = k / board[0].length;
            int y = k % board[0].length;

            if (board[x][y] == 0) {
                board[x][y] = 1;
                dfs(k + 1, count + 1);
                board[x][y] = 0;
            }
        }
    }

    private static void spreadVirus(int x, int y) {
        for (int[] move : dxdy) {
            int dx = x + move[0];
            int dy = y + move[1];

            if (dx < 0 || dy < 0 || dx >= board.length || dy >= board[0].length) {
                continue;
            }

            if (copyBoard[dx][dy] == 0) {
                copyBoard[dx][dy] = 2;
                spreadVirus(dx, dy);
            }
        }
    }

    private static int getMaxSafeArea() {
        int count = 0;
        for (final int[] ints : copyBoard) {
            for (int j = 0; j < copyBoard[0].length; j++) {
                if (ints[j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private static void copyArray() {
        copyBoard = new int[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            copyBoard[i] = Arrays.copyOf(board[i], board[i].length);
        }
    }

    private static class Point {
        int x;
        int y;

        public Point(final int x, final int y) {
            this.x = x;
            this.y = y;
        }
    }
}
