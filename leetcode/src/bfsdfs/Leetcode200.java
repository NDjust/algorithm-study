package bfsdfs;

public class Leetcode200 {

    private int[][] dxdy = {
            {1, 0}, {-1, 0},
            {0, 1}, {0, -1}
    };
    private boolean[][] visited;

    private int m;

    private int n;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i][j];

                if (!visited[i][j] && c == '1') {
                    dfs(grid, i, j);
                    result++;
                }
            }
        }

        return result;
    }

    private void dfs(final char[][] grid, final int i, final int j) {
        if (grid[i][j] == '0') {
            return;
        }

        visited[i][j] = true;

        for (int[] move : dxdy) {
            int dx = i + move[0];
            int dy = j + move[1];

            if (dx < 0 || dy < 0 || dx >= m || dy >= n) {
                continue;
            }

            if (!visited[dx][dy]) {
                dfs(grid, dx, dy);
            }
        }
    }

    public static void main(String[] args) {
        Leetcode200 leetcode200 = new Leetcode200();
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        int i = leetcode200.numIslands(grid);

        System.out.println(i);
    }

}
