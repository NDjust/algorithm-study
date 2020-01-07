package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class baekjoon2217 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ropeWeight = new int[n];

        for (int i = 0; i < n; i++) {
            ropeWeight[i] = sc.nextInt();
        }

        Arrays.sort(ropeWeight);

        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (ans < ropeWeight[i] * (n - i)) {
                ans = ropeWeight[i] * (n - i);
            }
        }

        System.out.println(ans);
    }
}
