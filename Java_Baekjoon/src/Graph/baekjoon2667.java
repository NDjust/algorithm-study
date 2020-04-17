package Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class baekjoon2667 {

    public static boolean[][] visited;

    public static int[][] houseComplex;

    public static int tile[][];

    public static int num;

    public static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tile = new int[n+1][n+1];
        num = 1;
        visited = new boolean[n+1][n+1];
        houseComplex = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for (int j = 1; j <= n; j++) {
                tile[i][j] = s.charAt(j-1) - 48;
            }
        }
        List<Integer> counts = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (tile[i][j] == 1 && !visited[i][j]) {
                    count = 1;
                    count = dfs(i, j, num);
                    num++;
                    counts.add(count);
                }
            }
        }
        Collections.sort(counts);

        System.out.println(num-1);
        for (int i = 0; i < counts.size(); i++) {
            System.out.println(counts.get(i));
        }
    }

    private static int dfs(int i, int j, int num) {
        if (visited[i][j]) {
            return count;
        }
        visited[i][j] = true;
        houseComplex[i][j] = num;

        // 오른쪽
        if (j+1 < tile.length && tile[i][j+1] == 1 && !visited[i][j+1]) {
            dfs(i, j+1, num);
            count++;
        }
        if (tile[i][j-1] == 1 && !visited[i][j-1]) { // 왼쪽
            dfs(i, j-1, num);
            count++;
        }
        if (i+1 < tile.length && tile[i+1][j] == 1 && !visited[i+1][j]) { // 아래쪽
            dfs(i+1, j, num);
            count++;
        }
        if (tile[i-1][j] == 1 && !visited[i-1][j]){ // 위쪽
            dfs(i-1, j, num);
            count++;
        }
        return count;
    }
}
