package greedy;

public class Leetcode11 {
    public int maxArea(int[] height) {
        int ans = 0;

        for (int i = 0; i < height.length; i++) {

            for (int j = i + 1; j < height.length; j++) {
                int frontHeight = height[i];
                int endHeight = height[j];

                ans = Math.max((j - i) * Math.min(frontHeight, endHeight), ans);
            }
        }
        return ans;
    }
}
