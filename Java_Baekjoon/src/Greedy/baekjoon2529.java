package Greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class baekjoon2529 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int[] nums = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        Integer[] nums1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int j = 0;

        String[] inEqual = new String[n];

        for (int i = 0; i < n; i++) {
            inEqual[i] = sc.next();
        }
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            if (inEqual[i].equals("<")) {
                Arrays.sort(nums, j, i + 2);
            } else {
                j = i + 1;
            }
        }

        j = 0;
        for (int i = 0; i < n; i++) {
            if (inEqual[i].equals(">")) {
                Arrays.sort(nums1, j, i + 2, Collections.reverseOrder());
            } else {
                j = i + 1;

            }

        }

        for (int i = 0; i < n + 1; i++) {
            System.out.print(nums[i]);
        }

        System.out.println();
        for (int i = 0; i < n + 1; i++) {
            System.out.print(nums1[i]);
        }


    }
}
