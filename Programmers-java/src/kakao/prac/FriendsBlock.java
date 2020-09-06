package kakao.prac;

public class FriendsBlock {

    private int m;
    private int n;

    private String[] board;

    private int ans;

    public int solution(int m, int n, String[] board) {
        this.m = m;
        this.n = n;
        this.board = board;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i].charAt(j) != '0') {
                    searchBoard(i, j, board);
                }
            }
        }
        return ans;
    }

    private void searchBoard(final int row, final int col, final String[] board) {
        char friend = board[row].charAt(col);
        boolean isBomb = true;

        for (int i = row; i < 2; i++) {
            for (int j = col; j < 2; j++) {
                if (i >= m || j >= n) {
                    return;
                }

                char c = board[i].charAt(j);
                if (c != friend) {
                    isBomb = false;
                }
            }
        }

        if (isBomb) {
            bombBoard(row, col, board);
            ans += 4;
        }
    }

    private void bombBoard(final int row, final int col, final String[] board) {

    }
}
