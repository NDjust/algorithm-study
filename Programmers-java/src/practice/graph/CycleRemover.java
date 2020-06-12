package practice.graph;

import java.util.ArrayList;
import java.util.List;

public class CycleRemover {

    private int nodeCount;

    public int solution(int n, int[][] edges) {
        nodeCount = n;
        int ans = 0;
        List<List<Integer>> nodes = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];

            nodes.get(node1).add(node2);
            nodes.get(node2).add(node1);
        }

        List<Integer> oddNodes = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (nodes.get(i).size() % 2 == 1) {
                oddNodes.add(i);
            }
        }

        for (Integer oddNode : oddNodes) {
            if (!isCycle(nodes, oddNode)) {
                ans += oddNode;
            }
        }

        return ans;
    }

    private boolean isCycle(List<List<Integer>> nodes, int removeNode) {
        int connectCountIsOneCount = 0;
        for (int i = 1; i <= nodeCount; i++) {
            if (i == removeNode) continue;

            List<Integer> list = nodes.get(i);
            int connectCount = connectCountByRemove(list, removeNode);
            connectCountIsOneCount += connectCount == 1 ? 1 : 0;
        }
        return connectCountIsOneCount != 2;
    }

    private int connectCountByRemove(List<Integer> list, int node) {
        int count = 0;
        for (Integer integer : list) {
            if (node != integer) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CycleRemover cycleRemover = new CycleRemover();
        int n = 4;
        int[][] edges = new int[][] {{1,2,}, {1,3}, {2,3}, {2,4}, {3,4}};
        int solution = cycleRemover.solution(n, edges);
        System.out.println(solution);

    }
}
