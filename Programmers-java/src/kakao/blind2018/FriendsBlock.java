package kakao.blind2018;

public class FriendsBlock {

    private int m;
    private int n;
    private char[][] board;
    private int answer;

    public int solution(int m, int n, String[] board) {
        this.m = m;
        this.n = n;
        this.board = new char[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = board[i].charAt(j);
                this.board[i][j] = c;
            }
        }

        while (true) {
            int count = bombBoard();

            if (count == 0) {
                break;
            }
            answer += count;
            dropDown();
        }

        return answer;
    }

    private int bombBoard() {
        boolean[][] checked = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m-1; ++i) {
            for (int j = 0; j < n-1; ++j) {
                if (board[i][j] != '.') {
                    bomb(checked, i, j);
                }
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (checked[i][j]) {
                    board[i][j] = '.';
                    count++;
                }
            }
        }
        return count;
    }

    private void dropDown() {
        for(int c = 0 ; c < n ; ++c) {
            for(int r = m - 1 ; r >= 0 ; --r) {
                if(board[r][c] == '.') {
                    for(int nr = r - 1 ; nr >= 0 ; --nr) {
                        if(board[nr][c] != '.') {
                            board[r][c] = board[nr][c];
                            board[nr][c] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }
    
    private void bomb(final boolean[][] checked, final int i, final int j) {
        char friend = board[i][j];

        for (int k = i; k < i + 2; ++k) {
            for (int l = j; l < j + 2; ++l) {
                if (friend != board[k][l]) {
                    return;
                }
            }
        }

        for (int k = i; k < i + 2; ++k) {
            for (int l = j; l < j + 2; ++l) {
                checked[k][l] = true;
            }
        }
    }


    public static void main(String[] args) {
        FriendsBlock friendsBlock = new FriendsBlock();
        int m = 6;
        int n = 6;
        String[] board = new String[] {
                "TTTANT",
                "RRFACC",
                "RRRFCC",
                "TRRRAA",
                "TTMMMF",
                "TMMTTJ"};

        int solution = friendsBlock.solution(m, n, board);
        System.out.println(solution);
    }
}
