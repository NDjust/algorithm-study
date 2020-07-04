/*
package practice.graph;

import java.util.*;

public class RoomCount {

    private int[][] moves = new int[][]{{0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}, {-1,-1}, {-1,0},{-1,1}};

    public int solution(int[] arrows) {
        int ans = 0;
        Map<Loc, Integer> cnt = new HashMap<>();
        Map<Loc, Integer> dir = new HashMap<>();
        Deque<Loc> deque = new LinkedList<>();

        int x = 0, y = 0;

        for (final int arrow : arrows) {
            for (int j = 0; j < 2; j++) {
                int[] move = moves[arrow];
                int dx = x + move[0];
                int dy = y + move[1];
                cnt.put(new Loc(dx, dy), 0);
                dir.put(new int[]{x, y, dx, dy}, 0);
                dir.put(new int[]{dx, dy, x, y}, 0);
                deque.add(new int[]{dx, dy});
                x = dx;
                y = dy;
            }
        }

        int[] xy = deque.pollFirst();
        cnt.put(new int[]{xy[0], xy[1]}, 1);

        while (!deque.isEmpty()) {
            int[] dxdy = deque.pollFirst();

            if (cnt.get(new int[]{dxdy[0], dxdy[1]}) == 1) {
                if (dir.get(new int[]{xy[0], xy[1], dxdy[0], dxdy[1]}) == 0) {
                    ans++;
                    dir.put(new int[]{xy[0], xy[1], dxdy[0], dxdy[1]}, 1);
                    dir.put(new int[]{dxdy[0], dxdy[1], xy[0], xy[1]}, 1);
                }
            } else {
                cnt.put(new int[]{dxdy[0], dxdy[1]}, 1);
                dir.put(new int[]{xy[0], xy[1], dxdy[0], dxdy[1]}, 1);
                dir.put(new int[]{dxdy[0], dxdy[1], xy[0], xy[1]}, 1);
            }
        }

        return ans;
    }

    static class Loc {
        int x;
        int y;

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            final Loc loc = (Loc) o;
            return x == loc.x &&
                    y == loc.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) {
        RoomCount roomCount = new RoomCount();
        int[] arrows = new int[]{6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0};

        System.out.println(roomCount.solution(arrows));
    }
}
*/
