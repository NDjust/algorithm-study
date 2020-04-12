package practice.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Spicy {

    public static int solution(int[] scoville, int k) {
        int answer = 0;

        Arrays.sort(scoville);
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < scoville.length; i++) {
            list.add(scoville[i]);
        }

        while (!(list.get(0) > k)) {
            if (list.size() == 1) {
                break;
            }
            int a = list.remove(0);
            int b = list.remove(0);

            list.add(0,a + b*2);
            Collections.sort(list);
            answer++;
        }

        if (list.get(0) < k) {
            return -1;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] sc = {1, 2, 3, 9, 10, 12};
        int k = 14;
        System.out.println(solution(sc, k));
    }
}
