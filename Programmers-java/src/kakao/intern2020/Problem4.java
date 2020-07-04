package kakao.intern2020;

public class Problem4 {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    static int moveCount = 0;
    static int curveCount = 0;
    static int min;

    public static int solution(int[][] board) {
        visited = new boolean[board.length][board[0].length];
        min = Integer.MAX_VALUE;
        dfs(board, 0, 0, 0);

        return min;
    }
    public static void dfs(int[][] board, int x, int y, int direction) {
        if (x == board.length - 1 && y == board[0].length - 1) {
            int cost = curveCount * 500 + moveCount * 100;
            System.out.println(curveCount);
            System.out.println(moveCount);
            if (min > cost) {
                min = cost;
            }
            return;
        }

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int mx = dx[i] + x;
            int my = dy[i] + y;

            if (mx >= 0 && my >= 0 && mx < board.length && my < board[0].length) {
                if (!visited[mx][my] && board[mx][my] != 1) {
                    if (direction != i) {
                        curveCount++;
                        moveCount++;
                    } else {
                        moveCount++;
                    }
                    dfs(board, mx, my, i);
                }
            }
        }
    }
    public static void main(String[] args) {
        int[][] board = {{0,0,0},{0,0,0},{0,0,0}};

        System.out.println(solution(board));

    }
}
