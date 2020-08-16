package greedy;

import java.util.Arrays;

public class Leetcode1029 {

    public int twoCitySchedCost(int[][] costs) {
        int totalCost = 0;

        int[] diff = new int[costs.length];
        for (int i = 0; i < costs.length; i++) {
            totalCost += costs[i][0];
            diff[i] = costs[i][1] - costs[i][0];
        }

        Arrays.sort(diff);

        for (int i = 0; i < diff.length / 2; i++) {
            totalCost += diff[i];
        }

        return totalCost;
    }

    public static void main(String[] args) {
        Leetcode1029 leetcode1029 = new Leetcode1029();
        int[][] costs = new int[][] {
                {10,20},{30,200},{400,50},{30,20}
        };
        int i = leetcode1029.twoCitySchedCost(costs);

        System.out.println(i);

    }
}
