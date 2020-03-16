package practice.stack;

import java.util.*;

public class DevelopFunction {

    public static int[] shortCut(int[] progresses, int[] speeds) {
        int[] dayOfend = new int[100];
        int day = -1;
        for(int i=0; i<progresses.length; i++) {
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
        return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[speeds.length];
        for (int i = 0; i < speeds.length; i++) {
            if ((100 - progresses[i]) % speeds[i] == 0) {
                days[i] = ((100 - progresses[i]) / speeds[i]) + 1;
            } else {
                days[i]= ((100 - progresses[i]) / speeds[i]);
            }
        }

        Deque<Integer> stack = new LinkedList<>();
        Deque<Integer> stack1 = new LinkedList<>();
        stack.add(days[0]);

        for (int i = 1; i < days.length; i++) {
            if (stack.peek() >= days[i]) {
                stack.add(days[i]);
            } else if (stack.peek() < days[i]){
                stack1.add(stack.size());
                while (stack.size() != 0) {
                    int a = stack.pop();
                }
                stack.add(days[i]);
            }
        }

        stack1.add(stack.size());

        int end = stack1.size();
        int[] answer = new int[end];

        for (int i = 0; i < end; i++) {
            answer[i] = stack1.removeFirst();
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] progress = {93,30,55};
        int[] speed = {1,30,5};
        int[] ans = solution(progress, speed);

        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
