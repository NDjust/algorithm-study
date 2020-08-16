package greedy;

import java.util.PriorityQueue;

public class Leetcode1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b-a);


        for (int stone : stones) {
            priorityQueue.offer(stone);
        }


        while (priorityQueue.size() > 1) {
            int num1 = priorityQueue.poll();
            int num2 = priorityQueue.poll();

            if (num1 != num2) {
                int remain = num1 - num2;
                priorityQueue.add(remain);
            }
        }

        return priorityQueue.isEmpty() ? 0 : priorityQueue.peek();
    }

    public static void main(String[] args) {
        Leetcode1046 leetcode1046 = new Leetcode1046();
        int[] stones = new int[] {2,7,4,1,8,1};
        int i = leetcode1046.lastStoneWeight(stones);
    }

}