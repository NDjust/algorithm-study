package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Leetcode78 {

    private List<Integer> selectedNums = new ArrayList<>();

    private List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        answer.add(new ArrayList<>());
        for (int i = 1; i <= nums.length; i++) {
            backTracking(nums, 0, i, 0);
        }

        return answer;
    }

    private void backTracking(final int[] nums, int cnt, int k, final int idx) {

        if (selectedNums.size() == k) {
            answer.add(new ArrayList<>(selectedNums));
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            selectedNums.add(nums[i]);
            backTracking(nums, cnt + 1, k, i + 1);
            selectedNums.remove(selectedNums.size()-1);
        }
    }

    public static void main(String[] args) {
        Leetcode78 leetcode78 = new Leetcode78();

        List<List<Integer>> subsets = leetcode78.subsets(new int[]{1, 2, 3});

        for (List<Integer> subset : subsets) {
            System.out.println(subset.toString());
        }
    }
}
