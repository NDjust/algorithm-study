package bfsdfs;

public class Leetcode980 {

    private boolean[][] visited;

    private int result;

    private int[][] dxdy = {
        {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };

    private int n;

    private int m;

    public int uniquePathsIII(int[][] grid) {
        n = grid.length;;
        m = grid[0].length;
        visited = new boolean[n][m];

        int[] startPoint = getStartPoint(grid);
        visited[startPoint[0]][startPoint[1]] = true;
        dfs(startPoint[0], startPoint[1], grid);

        return result;
    }

    private int[] getStartPoint(final int[][] grid) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }

    private void dfs(final int x, final int y, final int[][] grid) {
        if (grid[x][y] == 2) {
            if (isAllVisited(grid)) {
                result++;
            }
            return;
        }


        for (int[] move : dxdy) {
            int dx = x + move[0];
            int dy = y + move[1];


            if (dx < 0 || dy < 0 || dx >= n || dy >= m || grid[dx][dy] == -1) {
                continue;
            }

            if (!visited[dx][dy]) {
                visited[dx][dy] = true;

                dfs(dx, dy, grid);

                visited[dx][dy] = false;
            }
        }
    }

    private boolean isAllVisited(final int[][] grid) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == -1) {
                    continue;
                }

                if (!visited[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }


    public static void main(String[] args) {
        Leetcode980 leetcode980 = new Leetcode980();
        int[][] grid = new int[][] {
                {1,0,0,0},{0,0,0,0},{0,0,2,-1}
        };

        int i = leetcode980.uniquePathsIII(grid);

        System.out.println(i);
    }
}
