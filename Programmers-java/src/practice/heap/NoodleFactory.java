package practice.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class NoodleFactory {


    public static int solution(int stock, int[] date, int[] supplies, int k) {
        int answer = 0;
        int supplyIdx = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        while (k > stock) {
            for (int i = supplyIdx;  i < date.length; i++) {
                if (date[i] <= stock) {
                    queue.offer(supplies[i]);
                    supplyIdx = i + 1;
                } else {
                    break;
                }
            }
            stock += queue.poll();
            answer++;
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(4, new int[]{4, 10, 15}, new int[]{20, 5, 10}, 30));
    }
}
