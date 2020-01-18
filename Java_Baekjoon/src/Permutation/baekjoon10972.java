package Permutation;

import java.util.Scanner;

public class baekjoon10972 {
    public static boolean nextPermutation (int[] a){
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
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        if (nextPermutation(a)) {
            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("-1");
        }

    }
}
