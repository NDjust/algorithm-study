package kakao.intern2019;

import java.util.Stack;

public class Crain {


    public static int solution(int[][] board, int[] moves) {
        int rows = board.length;
        int ans = 0;
        Stack<Integer> box = new Stack<>();

        for (int i = 0; i < moves.length; i++) {
            int col = moves[i]-1;
            for (int j = 0; j < rows; j++) {
                if (board[j][col] != 0) {
                    if (box.isEmpty()) {
                        box.push(board[j][col]);
                        board[j][col] = 0;
                        break;
                    } else {
                        if (box.peek() == board[j][col]) {
                            box.pop();
                            ans += 2;
                        } else {
                            box.push(board[j][col]);
                        }
                        board[j][col] = 0;
                        break;
                    }
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
        solution(board, moves);
    }
}
