package Dynamic.step1;/*
* BaekJoon https://www.acmicpc.net/problem/1463
* */

import java.util.ArrayList;
import java.util.Scanner;

public class baekjoon1463 {
    public static int[] d;

    public static int topDown(int n) {
        if (n <= 1) {
            return 0;
        }

        if (d[n] > 0) {
            return d[n]; // memorization. -> 기억해두기 (중복 제거)
        }

        d[n] = topDown(n - 1) + 1;

        if (n % 2 == 0 && d[n] > d[n/2] + 1) {
            d[n] = topDown(n/2) + 1;
        }

        if (n % 3 == 0 && d[n] > d[n/3] + 1) {
            d[n] = topDown(n/3) + 1;
        }

        return d[n];
    }

    public static int bottomUp(int n) {
        d[1] = 0;

        for (int i = 2; i <= n; i++) {
            d[i] = d[i-1] + 1;

            if (i % 2 == 0 && (d[i] > (d[i/2] + 1))) {
                d[i] = d[i/2] + 1;
            }

            if (i % 3 == 0 && (d[i] > (d[i/3] + 1))) {
                d[i] = d[i/3] + 1;
            }
        }

        return d[n];
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        d = new int[num + 1];

        System.out.println(bottomUp(num));
        System.out.println(topDown(num));
    }
}
