package kakao.prac;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class BlockMove {

    int ans;
    int n;
    Queue<Node> queue;
    HashSet<Node> visited;
    int[][] map;

    public int solution(int[][] board) {
        ans = 0;
        n = board.length;
        visited = new HashSet<>();
        queue = new LinkedList<>();
        map = new int[n + 2][n + 2];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {

                if (i == 0 || i == map.length - 1 || j == 0 || j == map.length - 1) {
                    map[i][j] = 1;
                } else {
                    map[i][j] = board[i-1][j-1];
                }
            }
        }

        push(1, 1, 1, 2);
        bfs();
        return ans;
    }

    private void bfs() {
        int[] rotate = {-1, 1};
        int[][] dxdy = new int[][] {
                {1, 0}, {0, 1},
                {-1, 0}, {0, -1}
        };

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node now = queue.poll();

                if((now.r1 == n && now.c1 == n) || (now.r2 == n && now.c2 == n)) {
                    return;
                }

                for (int j = 0; j < 4; j++) {
                    int nr1 = now.r1 + dxdy[j][0];
                    int nc1 = now.c1 + dxdy[j][1];
                    int nr2 = now.r2 + dxdy[j][0];
                    int nc2 = now.c2 + dxdy[j][1];

                    if (map[nr1][nc1] == 0 && map[nr2][nc2] == 0) {
                        push(nr1, nc1, nr2, nc2);
                    }
                }


                // 가로 회전
                if (now.r1 == now.r2) {
                    for (int r : rotate) {
                        int nr1 = now.r1 + r;
                        int nc1 = now.c1;
                        int nr2 = now.r2 + r;
                        int nc2 = now.c2;

                        if (map[nr1][nc1] == 0 && map[nr2][nc2] == 0) {
                            push(now.r1, now.c1, nr1, nc1);
                            push(now.r2, now.c2, nr2, nc2);
                        }
                    }
                }

                // 세로 회전
                if (now.c1 == now.c2) {
                    for (int r : rotate) {
                        int nr1 = now.r1;
                        int nc1 = now.c1 + r;
                        int nr2 = now.r2;
                        int nc2 = now.c2 + r;

                        if (map[nr1][nc1] == 0 && map[nr2][nc2] == 0) {
                            push(now.r1, now.c1, nr1, nc1);
                            push(now.r2, now.c2, nr2, nc2);
                        }
                    }
                }
            }
            ans++;
        }
    }

    private void push(final int r1, final int c1, final int r2, final int c2) {
        Node node = new Node(r1, c1, r2, c2);

        if (visited.contains(node)) {
            return;
        }
        visited.add(node);
        queue.offer(new Node(r1, c1, r2, c2));

    }

    private class Node {
        int r1, c1;
        int r2, c2;


        public Node(final int r1, final int c1, final int r2, final int c2) {
            this.r1 = r1;
            this.c1 = c1;
            this.r2 = r2;
            this.c2 = c2;
        }

        @Override
        public boolean equals(final Object o) {
            final Node node = (Node) o;
            if (this.r1 == node.r1 && this.c1 == node.c1 && this.r2 == node.r2 && this.c2 == node.c2) return true;
            return this.r1 == node.r2 && this.c1 == node.c2 && this.r2 == node.r1 && this.c2 == node.c1;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r1, c1, r2, c2);
        }
    }


}
