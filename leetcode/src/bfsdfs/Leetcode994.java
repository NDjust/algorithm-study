package bfsdfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode994 {

    private int[][] dxdy = new int[][] {
            {0, 1}, {0, -1},
            {1, 0}, {-1, 0}
    };

    private boolean[][] visited;


    public int orangesRotting(int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;

        List<int[]> rottingLocation = findRotting(grid);

        if (rottingLocation.isEmpty()) {
            if (hasOrange(grid)) {
                return -1;
            } else {
                return 0;
            }
        }

        int[][] newBoard = new int[rowLen][colLen];

        for (int[] rot : rottingLocation) {
            visited = new boolean[rowLen][colLen];
            newBoard[rot[0]][rot[1]] = 0;
            Queue<int[]> queue = new LinkedList<>();
            queue.add(rot);

            while (!queue.isEmpty()) {
                int[] poll = queue.poll();
                visited[poll[0]][poll[1]] = true;

                for (int[] move : dxdy) {
                    int dx = move[0] + poll[0];
                    int dy = move[1] + poll[1];

                    if (dx < 0 || dy < 0 || dx >= rowLen || dy >= colLen) {
                        continue;
                    }

                    if (!visited[dx][dy] && grid[dx][dy] == 1) {
                        if (newBoard[dx][dy] != 0) {
                            newBoard[dx][dy] = Math.min(newBoard[poll[0]][poll[1]] + 1, newBoard[dx][dy]);
                        } else {
                            newBoard[dx][dy] = newBoard[poll[0]][poll[1]] + 1;
                        }
                        queue.add(new int[] {dx, dy});
                    }
                }
            }
        }

        if (isAllVisited(newBoard, grid)) {
            return getMinute(newBoard);
        }

        return -1;
    }

    private boolean hasOrange(final int[][] grid) {
        for (int[] g : grid) {
            for (int i : g) {
                if (i == 1) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isAllVisited(final int[][] newBoard, final int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && newBoard[i][j] <= 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private int getMinute(final int[][] newBoard) {
        int minute = 0;

        for (int[] board : newBoard) {
            for (final int j : board) {
                minute = Math.max(j, minute);
            }
        }
        return minute;
    }

    private List<int[]> findRotting(final int[][] grid) {
        List<int[]> rots = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    rots.add(new int[] {i, j});
                }
            }
        }

        return rots;
    }

    public static void main(String[] args) {
        Leetcode994 leetcode994 = new Leetcode994();

        final int rotting = leetcode994.orangesRotting(new int[][]{
                {2,1,1},{1,1,1},{0,1,2}
        });

        System.out.println(rotting);
    }
}
