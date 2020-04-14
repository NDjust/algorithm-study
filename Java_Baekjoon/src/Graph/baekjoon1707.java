package Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class baekjoon1707 {

    private static ArrayList<ArrayList<Integer>> gNode;
    private static int[] visited;
    private static int RED = 1;
    private static int BLUE = -1;
    private static boolean checkSum = true;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while (n-- > 0) {
            int v = sc.nextInt();
            int e = sc.nextInt();
            gNode = new ArrayList<>();
            visited = new int[v + 1];
            checkSum = true;

            for (int i = 0; i <= v; i++) {
                gNode.add(new ArrayList<>());
                visited[i] = 0;
            }

            for (int i = 0; i < e; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();

                gNode.get(x).add(y);
                gNode.get(y).add(x);
            }


            for (int i = 1; i <= v; i++) {
                if (!checkSum) {
                    break;
                }
                if (visited[i] == 0) {
                    dfs(i, RED);
                }
            }

            System.out.println(checkSum ? "YES" : "NO");
        }
    }

    public static void dfs(int r, int color) {
        if (visited[r] == -color) {
            return;
        }

        visited[r] = color;

        for (Integer integer : gNode.get(r)) {
            if (visited[r] == visited[integer]) {
                checkSum = false;
                return;
            }

            if (visited[integer] == 0) {
                dfs(integer, -color);
            }
        }
    }
}
