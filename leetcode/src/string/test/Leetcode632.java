package string.test;

import java.util.List;
import java.util.PriorityQueue;

public class Leetcode632 {
    public int[] smallestRange(List<List<Integer>> nums) {
        int minx = 0;
        int miny = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int[] next = new int[nums.size()];
        boolean flag = true;

        PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>((i, j) -> nums.get(i).get(next[i]) - nums.get(j).get(next[j]));

        for (int i = 0; i < nums.size(); i++) {
            minQueue.offer(i);
            max = Math.max(max, nums.get(i).get(0));
        }

        for (int i = 0; i < nums.size() && flag; i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                int minI = minQueue.poll();

                if (miny - minx > max - nums.get(minI).get(next[minI])) {
                    minx = nums.get(minI).get(next[minI]);
                    miny = max;
                }

                next[minI]++;

                if (next[minI] == nums.get(minI).size()) {
                    flag = false;
                    break;
                }

                minQueue.offer(minI);
                max = Math.max(max, nums.get(minI).get(next[minI]));
            }
        }

        return new int[]{minx, miny};
    }

}
