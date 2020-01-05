package Greedy;

import java.util.Scanner;

public class baekjoon2875 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int ans = 0;

        while (n + m >= k + 3 && n >= 2 && m >= 1) {
            n -= 2;
            m -= 1;
            ans += 1;
        }

        System.out.println(ans);

    }
}
