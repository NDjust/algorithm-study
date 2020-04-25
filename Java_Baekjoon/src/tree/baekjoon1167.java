package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int node;
    int dist;

    public Node(int node, int distance) {
        this.node = node;
        this.dist = distance;
    }
}
public class baekjoon1167 {

    private static boolean[] visited;

    private static Node maxNode;

    static int max = 0;

    static List<Node>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        tree = new ArrayList[n+1];
        visited = new boolean[n+1];

        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        tree[0].add(new Node(1, 0));

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int nodeNum = Integer.parseInt(st.nextToken());

            while (st.hasMoreTokens()) {
                int nextNode = Integer.parseInt(st.nextToken());
                if (nextNode == -1) {
                    break;
                }
                int distance = Integer.parseInt(st.nextToken());
                tree[nodeNum].add(new Node(nextNode, distance));
                tree[nextNode].add(new Node(nodeNum, distance));
            }
        }
        // 루트 노드가 다를 경우를 대비해 MaxNode 를 찾아 백트래킹
        maxNode = dfs(tree[0].get(0), 0);
        visited = new boolean[n+1];
        dfs(maxNode, 0);
        System.out.println(max);
    }

    private static Node dfs(Node n, int dist) {
        visited[n.node] = true;

        for (Node child : tree[n.node]) {
            if (!visited[child.node])  {
                dfs(child, dist + child.dist);
            }
        }

        if (max < dist) {
            maxNode = n;
            max = dist;
        }

        return maxNode;
    }
}
