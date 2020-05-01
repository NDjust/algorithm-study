package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class baekjoon10610 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.nextLine().toCharArray();
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] - '0';
        }
        Arrays.sort(arr);

        if (arr[0] == '0' && sum % 3 == 0) {
            for (int i = arr.length-1; i >= 0; i--) {
                System.out.print(arr[i]);
            }
            System.out.println();
        } else {
            System.out.println(-1);
        }
    }
}
