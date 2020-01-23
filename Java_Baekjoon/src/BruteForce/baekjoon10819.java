package BruteForce;

import java.util.Arrays;
import java.util.Scanner;

public class baekjoon10819 {

    public static int calculate(int[] a) {
        int sum = 0;

        for (int i = 1; i < a.length; i++) {
            sum += Math.abs(a[i] - a[i - 1]);
        }

        return sum;
    }

    public static boolean nextPermutation(int[] a) {
        int i = a.length - 1;

        while (i > 0 && a[i - 1] >= a[i]) {
            i--;
        }

        if (i <= 0) {
            return false;
        }

        int j = a.length - 1;

        while (a[j] <= a[i - 1]) {
            j--;
        }

        int tmp = a[i - 1];
        a[i - 1] = a[j];
        a[j] = tmp;

        j = a.length - 1;

        while (i < j) {
            tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] nums = new int[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);

        do {
            int tmep = calculate(nums);
            ans = Math.max(tmep, ans);

        } while(nextPermutation(nums));

        System.out.println(ans);
    }
}
