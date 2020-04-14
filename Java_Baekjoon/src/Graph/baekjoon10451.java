package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon10451 {
    private static ArrayList<ArrayList<Integer>> gNode;
    private static boolean[] visited;
    private static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            gNode = new ArrayList<>();
            visited = new boolean[n + 1];
            count = 0;
            gNode.add(new ArrayList<>());

            for (int i = 1; i <= n; i++) {
                int a = sc.nextInt();
                ArrayList<Integer> node = new ArrayList<>();
                gNode.add(node);
                gNode.get(i).add(a);
            }

            for (int i = 1; i <= n; i++) {

                if (!visited[i]) {
                    bfs(i);
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    public static void bfs(int r) {
        Queue<Integer> queue = new LinkedList<>();
        visited[r] = true;
        queue.add(r);

        while (!queue.isEmpty()) {
            int a = queue.poll();
            for (Integer integer : gNode.get(a)) {
                if (!visited[integer]) {
                    visited[integer] = true;
                    queue.add(integer);
                }
            }
        }
    }
}
