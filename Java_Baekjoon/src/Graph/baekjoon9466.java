package Graph;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class baekjoon9466 {

    public static int[] students;

    public static int ans;

    public static boolean[] visited;

    public static boolean[] finished;

    public static ArrayList<Integer> visitedValue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        // O(n^2) -> O(n)으로 바꾸는게 핵심
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            ans = 0;
            students = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];

            for (int i = 1; i <= n; i++) {
                students[i] = Integer.parseInt(s[i-1]);
            }


            for (int i = 1; i <= n; i++) {
                dfs(i);
            }

            System.out.println(n-ans);
        }
    }

    public static void dfs(int r) {
        if (visited[r]) {
            return;
        }
        visited[r] = true;
        int next = students[r];

        if (!visited[next]) {
            dfs(next);
        } else {
            if (!finished[next]) {
                // 노드가 끝나려면 싸이클을 무조건 거쳐야한다.
                // 따라서 현재 노드가 아닌 다음 노드 기준으로 하면 싸이클이 무조건 존재
                ans++;
                for (int i = next; i != r; i = students[i]) {
                    ans++;
                }
            }
        }

        finished[r] = true;
    }
}
