package bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon2842 {

    private static char[][] map;
    private static int[][] heightMap;
    private static List<Integer> heightList;
    private static int N, house;
    private static Node start;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = stringToInt(br.readLine());

        house = 0;
        map = new char[N][N];
        heightMap = new int[N][N];
        heightList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();

            for (int j = 0; j < N; j++) {
                map[i][j] = line[j];

                if (map[i][j] == 'K') {
                    house++;
                }

                if (map[i][j] == 'P') {
                    start = new Node(i, j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                heightMap[i][j] = stringToInt(st.nextToken());

                if (!heightList.contains(heightMap[i][j])) {
                    heightList.add(heightMap[i][j]);
                }
            }
        }

        // Two-Pointer를 사용하기 위해 오름차순 정렬
        Collections.sort(heightList);

        System.out.println(solve());
    }

    private static int solve() {
        int min = 0;
        int max = 0;
        int ans = Integer.MAX_VALUE;

        while (min < heightList.size() && max < heightList.size()) {
            if (bfs(heightList.get(min), heightList.get(max))) {
                int gap = heightList.get(max) - heightList.get(min);
                ans = Math.min(ans, gap);

                // 탐색 성공하면 min 값을 늘려 피로도 줄여줌
                min++;
            } else {
                // 탐색에 실패하면 max 값을 늘려 더 높은 피로도로 탐색할 수 있게함.
                max++;
            }
        }

        return ans;
    }

    private static boolean bfs(final int min, final int max) {
        int startH = heightMap[start.r][start.c];

        if (startH > max || startH < min) {
            return false;
        }

        int[][] dir = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1}, {0, 1}, {1, -1},
                {1, 0}, {1, 1}
        };
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        int cnt = 0;

        q.offer(start);
        visited[start.r][start.c] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (map[now.r][now.c] == 'K') {
                cnt++;
            }

            if (cnt == house) {
                return true;
            }

            for (int i = 0; i < 8; i++) {
                int nr = now.r + dir[i][0];
                int nc = now.c + dir[i][1];

                if (nr >= N || nr < 0 || nc >= N || nc < 0 || visited[nr][nc]) {
                    continue;
                }

                if (heightMap[nr][nc] >= min && heightMap[nr][nc] <= max) {
                    visited[nr][nc] = true;
                    q.offer(new Node(nr, nc));
                }
            }
        }

        return false;
    }

    private static int stringToInt(final String readLine) {
        return Integer.parseInt(readLine);
    }

    private static class Node {
        int r;
        int c;

        public Node(final int r, final int c) {
            this.r = r;
            this.c = c;
        }
    }
}
