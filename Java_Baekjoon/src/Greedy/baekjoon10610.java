package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class baekjoon10610 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] nums = sc.nextLine().toCharArray();
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] - '0';
        }

        Arrays.sort(nums);

        if (nums[0] == '0' && sum % 3 == 0) {
            for (int i = nums.length - 1; i >= 0; i--) {
                System.out.print(nums[i]);
            }
            System.out.println();
        } else {
            System.out.println(-1);
        }
    }
}
