package practice.heap;

import java.util.Comparator;
import java.util.Optional;
import java.util.PriorityQueue;

public class DoublePriorityQueue {

    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> priorityQueueMax = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> priorityQueueMin = new PriorityQueue<>();

        for (String operation : operations) {
            String[] splits = operation.split(" ");
            String op = splits[0];
            String num = splits[1];

            if (op.equals("I")) {
                priorityQueueMax.add(Integer.parseInt(num));
                priorityQueueMin.add(Integer.parseInt(num));
            } else {
                if (!priorityQueueMax.isEmpty() && !priorityQueueMin.isEmpty()) {
                    if (num.equals("-1")) {
                        int min = priorityQueueMin.peek();
                        priorityQueueMax.remove(min);
                        priorityQueueMin.remove(min);
                    } else {
                        int max = priorityQueueMax.peek();
                        priorityQueueMax.remove(max);
                        priorityQueueMin.remove(max);
                    }
                }
            }
        }

        if (!priorityQueueMax.isEmpty()) {
            answer[0] = priorityQueueMax.peek();
            answer[1] = priorityQueueMin.poll();
        }


        return answer;
    }
    public static void main(String[] args) {

    }
}
