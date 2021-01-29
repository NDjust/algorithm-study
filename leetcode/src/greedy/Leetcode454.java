package greedy;

import java.util.HashMap;
import java.util.Map;

public class Leetcode454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int a : A) {
            for (int b : B) {
                map.put(a + b, map.getOrDefault(a + b, 0) + 1);
            }
        }

        int res = 0;
        for (int c : C) {
            for (int d : D) {
                res += map.getOrDefault(-1 * (c + d), 0);
            }
        }

        return res;
    }
}
