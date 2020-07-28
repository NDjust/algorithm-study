package bfsdfs;

import java.util.*;

public class Leetcode773 {

    public int slidingPuzzle(int[][] board) {
        int zeroX = 0;
        int zeroY = 0;
        int[][] dxdy = new int[][] {
                {1,0}, {-1,0},
                {0,1}, {0,-1}
        };

        int rowLen = board.length;
        int colLen = board[0].length;

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (board[i][j] == 0) {
                    zeroX = i;
                    zeroY = j;
                }
            }
        }

        if (isSlidingPuzzle(board)) {
            return 0;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(zeroX, zeroY, board,0));
        Boards boards = new Boards();
        boards.add(new Board(board));

        // TODO 불가능한 시점 즉 종료시점 찾기.
        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            if (isSlidingPuzzle(poll.board)) {
                return poll.swapCount;
            }

            for (int i = 0; i < 4; i++) {
                int dx = poll.x + dxdy[i][0];
                int dy = poll.y + dxdy[i][1];

                if (dx < 0 || dy < 0 || dx >= rowLen || dy >= colLen) {
                    continue;
                }

                int[][] copySwapBoard = getCopySwapBoard(poll.board, poll.x, poll.y, dx, dy);
                Board copyBoard = new Board(copySwapBoard);

                if (!boards.contains(copyBoard)) {
                    queue.add(new Node(dx, dy, copySwapBoard, poll.swapCount + 1));
                    boards.add(copyBoard);
                }


            }
        }
        return -1;
    }

    private int[][] getCopySwapBoard(final int[][] board,
                                     final int x, final int y,
                                     final int dx, final int dy) {
        int[][] arr = new int[board.length][];

        for (int i = 0; i < board.length; i++) {
            arr[i] = Arrays.copyOf(board[i], board[i].length);
        }
        int tmp = arr[x][y];
        arr[x][y] = arr[dx][dy];
        arr[dx][dy] = tmp;

        return arr;
    }

    private boolean isSlidingPuzzle(final int[][] board) {
        int[][] slidingPuzzle = {{1,2,3}, {4,5,0}};

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != slidingPuzzle[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    private static class Boards {
        List<Board> boards = new ArrayList<>();

        public Boards() {
        }

        public void add(Board board) {
            boards.add(board);
        }

        public boolean contains(Board newBoard) {
            return boards.stream()
                    .anyMatch(board -> board.isSame(newBoard));
        }
    }

    private static class Board {
        int[][] board;

        public Board(final int[][] board) {
            this.board = board;
        }

        public boolean isSame(final Board newBoard) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] != newBoard.board[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    private static class Node {
        int x;
        int y;
        int[][] board;
        int swapCount;

        public Node(final int x, final int y, final int[][] board, final int swapCount) {
            this.x = x;
            this.y = y;
            this.board = board;
            this.swapCount = swapCount;
        }
    }

    public static void main(String[] args) {
        int[][] board = {{3,2,4}, {1,5,0}};

        Leetcode773 leetcode773 = new Leetcode773();
        int cnt = leetcode773.slidingPuzzle(board);

        System.out.println(cnt);
    }
}
