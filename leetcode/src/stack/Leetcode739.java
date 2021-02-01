package stack;

import java.util.Arrays;

public class Leetcode739 {

    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        int idx = 0;

        for (int i = 0; i < T.length; i++) {
            int target = T[i];
            boolean flag = false;
            for (int j = 1 + i; j < T.length; j++) {
                int compare = T[j];

                if (target < compare) {
                    result[idx++] = j - i;
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                result[idx++] = 0;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Leetcode739 leetcode739 = new Leetcode739();
        int[] results = leetcode739.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});

        System.out.println(Arrays.toString(results));
    }
}
