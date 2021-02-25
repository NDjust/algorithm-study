package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon4195 {

    private static int[] parent;
    private static int[] connectedCount;
    private static Map<String, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            int networkCount = Integer.parseInt(br.readLine());
            int n = networkCount * 2;
            parent = new int[n];
            connectedCount = new int[n];

            for (int j = 0; j < n; j++) {
                parent[j] = j;
                connectedCount[j] = 1;
            }

            map = new HashMap<>();
            int id = 0;

            for (int j = 0; j < networkCount; j++) {
                String[] network = br.readLine().split(" ");
                String a = network[0];
                String b = network[1];

                if (!map.containsKey(a)) {
                    map.put(a, id++);
                }

                if (!map.containsKey(b)) {
                    map.put(b, id++);
                }

                union(map.get(a), map.get(b));
                System.out.println(Math.max(findConnectedCount(map.get(a)), findConnectedCount(map.get(b))));
            }
        }
    }

    private static int findConnectedCount(int a) {
        a = find(a);
        return connectedCount[a];
    }


    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
            connectedCount[a] = connectedCount[b] + connectedCount[a];
        }
    }

    private static int find(final int a) {
        if (a == parent[a]) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }
}
