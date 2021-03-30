package greedy;

import java.util.Arrays;

public class Leetcode875 {

    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = Arrays.stream(piles).max().getAsInt();

        while (min <= max) {
            int mid = (max + min) / 2;
            int costHours = getCostHours(piles, mid);

            if (costHours <= h) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return min;
    }

    private int getCostHours(final int[] piles, final int mid) {
        int hours = 0;

        for (int pile : piles) {
            hours += (pile / mid) + ((pile % mid) == 0 ? 0 : 1);
        }

        return hours;
    }

    public static void main(String[] args) {
        Leetcode875 leetcode875 = new Leetcode875();
        final int i = leetcode875.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5);
        System.out.println(i);
    }
}
