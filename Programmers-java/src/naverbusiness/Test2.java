package naverbusiness;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Test2 {

    public int solution(int[] arr) {
        int answer = Integer.MAX_VALUE;

        Set<Integer> setId = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toSet());

        if (setId.size() == arr.length) {
            return -1;
        } else if (setId.size() == 1) {
            return 1;
        }

        List<Integer> uniqueId = new ArrayList<>(setId);

        for (Integer id : uniqueId) {
            int startIdx = 0;

            for (int i = 0; i < arr.length; i++) {
                if (id == arr[i] && startIdx == 0) {
                    startIdx = i;
                } else if (id == arr[i]){
                    int len = i - startIdx;
                    startIdx = i;

                    if (len < answer) {
                        answer = len;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        int[] arr = new int[]{2, 1, 3, 1, 4, 2, 1, 3};

        System.out.println(test2.solution(arr));

    }
}
