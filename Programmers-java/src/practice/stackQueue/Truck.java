package practice.stackQueue;

import java.util.Deque;
import java.util.LinkedList;

public class Truck {

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int wnum = 0;
        int bridge_sum = 0;

        Deque<Integer> bridge = new LinkedList<>();

        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }

        while (wnum < truck_weights.length) {
            answer++;

            bridge_sum -= bridge.removeFirst();

            if (bridge_sum + truck_weights[wnum] <= weight) {
                bridge.add(truck_weights[wnum]);
                bridge_sum += truck_weights[wnum];
                wnum++;
            } else {
                bridge.add(0);
            }

        }

        return answer + bridge_length;
    }


    public static void main(String[] args) {
        int bridgeLen = 2;
        int weight = 10;
        int[] truckWeight = {7, 4, 5 ,6};
        System.out.println(solution(bridgeLen, weight, truckWeight));
    }
}
