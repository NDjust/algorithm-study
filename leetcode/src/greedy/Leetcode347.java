package greedy;

import java.util.*;

public class Leetcode347 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] ans = new int[k];
        List<Integer> sortedKey = new ArrayList<>(map.keySet());


        sortedKey.sort((k1, k2) -> {
            Integer value1 = map.get(k1);
            Integer value2 = map.get(k2);
            return value2.compareTo(value1);
        });

        for (int i = 0; i < k; i++) {
            ans[i] = sortedKey.get(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        Leetcode347 leetcode347 = new Leetcode347();
        int[] output = leetcode347.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        System.out.println(Arrays.toString(output));
    }
}
