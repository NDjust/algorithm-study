package greedy;

import java.util.Arrays;

public class Leetcode16 {

    public int threeSumCloset(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int ans = Integer.MAX_VALUE;
        int value = Integer.MAX_VALUE;

        for (int start = 0; start < len; start++) {
            int mid = start + 1;
            int end = len - 1;
            while (mid < end)  {
                if (value > Math.abs(nums[start] + nums[mid] + nums[end] - target)) {
                    value = Math.abs(nums[start] + nums[mid] + nums[end] - target);
                    ans = nums[start] + nums[mid] + nums[end];
                } else if (nums[start] + nums[mid] + nums[end] == target) {
                    return nums[start] + nums[mid] + nums[end];
                } else if (nums[start] + nums[mid] + nums[end] < target){
                    mid++;
                } else {
                    end--;
                }
            }
        }
        return ans;
    }
}
