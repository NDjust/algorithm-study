package kakao.prac;

import java.util.Stack;

public class Crane {

    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack= new Stack<>();
        int row = board.length;
        int ans = 0;

        for (int move : moves) {
            move = move - 1;
            for (int i = 0; i < row; i++) {
                if (board[i][move] != 0) {

                    if (!stack.isEmpty()) {
                        int peek = stack.peek();

                        if (peek == board[i][move]) {
                            stack.pop();
                            ans += 2;
                        } else {
                            stack.add(board[i][move]);
                        }
                    } else {
                        stack.add(board[i][move]);
                    }
                    board[i][move] = 0;
                    break;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] board = {
                {0,0,0,0,0},
                {0,0,1,0,3},
                {0,2,5,0,1},
                {4,2,4,4,2},
                {3,5,1,3,1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        Crane crane = new Crane();
        crane.solution(board, moves);
    }

}
