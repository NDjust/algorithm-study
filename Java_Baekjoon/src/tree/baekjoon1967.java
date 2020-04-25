package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class WeightNode {
    int node;
    int distance;

    public WeightNode(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

public class baekjoon1967 {
    
    static boolean[] visited;
    static ArrayList<WeightNode>[] tree;
    static WeightNode maxNode;
    static int maxDistance;


    private static WeightNode dfs(WeightNode node, int dist) {
        visited[node.node] = true;

        for (WeightNode child : tree[node.node]) {
            if (!visited[child.node]) {
                dfs(child, dist + child.distance);
            }
        }

        if (maxDistance < dist) {
            maxNode = node;
            maxDistance = dist;
        }

        return maxNode;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        tree = new ArrayList[n+1];

        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList();
        }
        
        // add root Node
        tree[0].add(new WeightNode(1, 0));

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int connectionNode = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            tree[node].add(new WeightNode(connectionNode, distance));
            tree[connectionNode].add(new WeightNode(node, distance));
        }
        maxNode = dfs(tree[0].get(0), 0);
        visited = new boolean[n+1];
        dfs(maxNode, 0);
        System.out.println(maxDistance);
    }
}
