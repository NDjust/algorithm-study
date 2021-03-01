package Graph;

import java.io.*;
import java.util.*;

public class Baekjoon1753 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] VE = br.readLine().split(" ");
        int V = Integer.parseInt(VE[0]);
        int E = Integer.parseInt(VE[1]);
        int startPoint = Integer.parseInt(br.readLine());
        List<Edge>[] graph = new ArrayList[V + 1];


        for (int i = 0; i < V + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            String[] edgeInfo = br.readLine().split(" ");
            int v1 = Integer.parseInt(edgeInfo[0]);
            int v2 = Integer.parseInt(edgeInfo[1]);
            int w = Integer.parseInt(edgeInfo[2]);
            graph[v1].add(new Edge(v2, w));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.w));
        boolean[] check = new boolean[V + 1];
        Edge[] D = new Edge[V + 1];

        for (int i = 0; i < V + 1; i++) {

            if (i == startPoint) {
                D[i] = new Edge(i, 0);
                pq.add(D[i]);
            } else {
                D[i] = new Edge(i, Integer.MAX_VALUE);
            }
        }


        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            if (check[edge.v]) {
                continue;
            }

            check[edge.v] = true;
            for (Edge next : graph[edge.v]) {
                if (D[next.v].w > D[edge.v].w + next.w) {
                    D[next.v].w = D[edge.v].w + next.w;
                    pq.add(new Edge(D[next.v].v, D[next.v].w));
                }
            }

        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= V; i++) {
            if (D[i].w == Integer.MAX_VALUE) {
                sb.append("INF\n");
            } else {
                sb.append(D[i].w).append("\n");
            }
        }

        bw.write(sb.toString());

        bw.close();
        br.close();
    }

    private static class Edge {
        public int v;

        public int w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "v=" + v +
                    ", w=" + w +
                    '}';
        }
    }
}
