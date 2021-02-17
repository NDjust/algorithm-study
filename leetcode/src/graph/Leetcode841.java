package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Leetcode841 {

    private boolean[] visited;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visited = new boolean[rooms.size()];
        dfs(0, rooms);
        boolean ans = true;

        for (boolean b : visited) {
            if (!b) {
                ans = false;
                break;
            }
        }

        return ans;
    }

    private void dfs(final int i, final List<List<Integer>> rooms) {
        visited[i] = true;

        for (Integer room : rooms.get(i)) {
            if (!visited[room]) {
                dfs(room, rooms);
            }
        }
    }

    public static void main(String[] args) {
        Leetcode841 leetcode841 = new Leetcode841();
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Collections.singletonList(1));
        rooms.add(Collections.singletonList(2));
        rooms.add(Collections.singletonList(3));
        rooms.add(new ArrayList<>());
        final boolean b = leetcode841.canVisitAllRooms(rooms);
        System.out.println(b);
    }
}
