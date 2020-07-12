package backtracking;

public class Leetcode1219 {

    private int maxGold = Integer.MIN_VALUE;

    private boolean[][] visited;

    private int[][] dxdy = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int getMaximumGold(int[][] grid) {
        visited = new boolean[grid.length][grid[0].length];


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] != 0) {
                    DFS(i, j, grid, 0);
                }
            }
        }
        return maxGold;
    }

    private void DFS(final int i, final int j, final int[][] grid, int sum) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || visited[i][j]) {
            if (sum > maxGold) {
                maxGold = sum;
            }
            return;
        }

        visited[i][j] = true;
        sum += grid[i][j];

        for (int k = 0; k < 4; k++) {
            int dx = i + dxdy[k][0];
            int dy = j + dxdy[k][1];
            DFS(dx, dy, grid, sum);
        }

        visited[i][j] = false;
        sum -= grid[i][j];
    }



    public static void main(String[] args) {
        Leetcode1219 leetcode1219 = new Leetcode1219();

        int[][] grid = {{0, 6, 0}, {5, 8, 7}, {0, 9, 0}};
        int maximumGold = leetcode1219.getMaximumGold(grid);
        System.out.println(maximumGold);
    }
}
