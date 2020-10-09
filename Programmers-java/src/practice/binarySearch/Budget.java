package practice.binarySearch;

import java.util.Arrays;

public class Budget {
    public static int solution(int[] budgets, int M) {
        Arrays.sort(budgets);
        int min = 0;
        int max = budgets[budgets.length-1];

        while (max >= min) {
            int mid = (max + min) / 2;
            long sum = 0;
            for (int i = 0; i < budgets.length; i++) {
                if (budgets[i] > mid) {
                    sum += (mid * (budgets.length-i));
                    break;
                }
                sum += budgets[i];
            }

            if (sum > M) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{120, 110, 140, 150}, 485));
    }
}
