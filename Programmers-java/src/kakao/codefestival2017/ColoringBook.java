package kakao.codefestival2017;

public class ColoringBook {

    private static boolean[][] visited;
    private static int[][] colors;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int areaWidth;
    private static int areaHeight;
    private static int count;

    private static void coloring(int i, int j, int[][] picture, int color) {
        visited[i][j] = true;
        colors[i][j] = color;

        for (int k = 0; k < 4; k++) {
            int mx = dx[k] + i;
            int my = dy[k] + j;

            if (mx >= 0 && my >= 0 && mx < areaWidth && my < areaHeight) {
                if (!visited[mx][my] && picture[i][j] == picture[mx][my]) {
                    coloring(mx, my, picture, color);
                }
            }

        }
    }

    public static void dfs(int i, int j) {
        visited[i][j] = true;
        count++;

        for (int k = 0; k < 4; k++) {
            int mx = dx[k] + i;
            int my = dy[k] + j;

            if (mx >= 0 && my >= 0 && mx < areaWidth && my < areaHeight) {
                if (!visited[mx][my] && colors[i][j] == colors[mx][my]) {
                    dfs(mx, my);
                }
            }
        }
    }

    public static int[] solution(int m, int n, int[][] picture) {
        int color = 1;
        areaWidth = m;
        areaHeight = n;
        colors = new int[m][n];
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0 && !visited[i][j]) {
                    coloring(i, j, picture, color);
                    color++;
                }
            }
        }
        visited = new boolean[m][n];
        int maxCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (colors[i][j] != 0 && !visited[i][j]) {
                    count = 0;
                    dfs(i, j);
                    if (maxCount < count) {
                        maxCount = count;
                    }
                }
            }
        }
        int[] ans = new int[2];
        ans[0] = color-1;
        ans[1] = maxCount;
        return ans;
    }

    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int[][] pictures = {
                {1, 1, 1, 0},
                {1, 2, 2, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 3},
                {0, 0, 0, 3}};
        solution(m, n, pictures);
    }
}
