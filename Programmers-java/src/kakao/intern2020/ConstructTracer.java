package kakao.intern2020;

import java.util.LinkedList;
import java.util.Queue;

public class ConstructTracer {

    private int cost;
    private int row;
    private int col;
    private int currCost;
    private int straightCount;
    private int curveCount;
    private boolean[][] visited;
    private int[][] map;

    public int solution(int[][] board) {
        row = board.length;
        col = board[0].length;
        cost = Integer.MAX_VALUE;
        map = board;
        visited = new boolean[row][col];

        visited[0][0] = true;
        straightCount++;
//        dfs(null, 0, 0,  board);
        bfs(0, 0, board);
        return cost;
    }

    private void bfs(final int r, final int c, int[][] board) {
        Queue<Root> queue = new LinkedList<>();
        queue.add(new Root(r, c, null,0));
        map[0][0] = 1;

        while (!queue.isEmpty()) {
            Root poll = queue.poll();

            if (poll.r == row - 1 && poll.c == col - 1) {
                cost = Math.min(poll.sum, cost);
                continue;
            }

            for (Direction direction : Direction.values()) {
                int mr = poll.r + direction.move[0];
                int mc = poll.c + direction.move[1];

                if (mr < 0 || mc < 0 || mr >= row || mc >= col || board[mr][mc] == 1) {
                    continue;
                }

                int nextSum;

                if (poll.d == null || poll.d.equals(direction)) {
                    nextSum = 100 + poll.sum;
                } else {
                    nextSum = 600 + poll.sum;
                }

                if (map[mr][mc] == 0) {
                    map[mr][mc] = nextSum;
                    queue.add(new Root(mr, mc, direction, nextSum));
                } else if (nextSum <= map[mr][mc]) {
                    map[mr][mc] = nextSum;
                    queue.add(new Root(mr, mc, direction, nextSum));
                }
            }
        }
    }

    private static class Root {
        int r;
        int c;
        Direction d;
        int sum;

        public Root(final int r, final int c, final Direction direction, final int sum) {
            this.r = r;
            this.c = c;
            this.d = direction;
            this.sum = sum;
        }
    }

    private void dfs(final Direction prevDirection, final int r, final int c, final int[][] board) {
        if ((r == row - 1) && (c == col - 1)) {
            currCost = curveCount * 500 + 100 * (straightCount - 1);
            cost = Math.min(cost, currCost);
            return;
        }


        for (Direction direction : Direction.values()) {
            int mr = r + direction.move[0];
            int mc = c + direction.move[1];

            if (mr < 0 || mc < 0 || mr >= row || mc >= col) {
                continue;
            }

            if (board[mr][mc] == 1 || visited[mr][mc]) {
                continue;
            }


            if (prevDirection == null) {
                straightCount++;
                visited[mr][mc] = true;
                dfs(direction, mr, mc, board);
                straightCount--;
                visited[mr][mc] = false;
            } else {
                if (prevDirection.equals(direction)) {
                    straightCount++;
                    visited[mr][mc] = true;
                    dfs(direction, mr, mc, board);
                    straightCount--;
                    visited[mr][mc] = false;
                } else {
                    straightCount++;
                    curveCount += 1;
                    visited[mr][mc] = true;
                    dfs(direction, mr, mc, board);
                    straightCount--;
                    curveCount -= 1;
                    visited[mr][mc] = false;
                }
            }
        }
    }

    private static enum Direction {
        LEFT(new int[]{0, 1}),
        RIGHT(new int[]{0, -1}),
        UP(new int[]{-1, 0}),
        DOWN(new int[]{1, 0});

        private int[] move;

        Direction(final int[] move) {
            this.move = move;
        }
    }

    public static void main(String[] args) {
        ConstructTracer constructTracer = new ConstructTracer();
        int[][] board = new int[][] {
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 1, 0, 1},
                {1, 0, 0, 0}
        };
        int solution = constructTracer.solution(board);
        System.out.println(solution);
    }
}
