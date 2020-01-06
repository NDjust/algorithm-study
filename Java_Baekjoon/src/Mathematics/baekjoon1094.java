package Mathematics;

import java.util.Scanner;

public class baekjoon1094 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;

        while (n >= 2) {
            if (n % 2 == 1) {
                ans += 1;
            }
            n = n / 2;
        }

        ans += 1;
        System.out.println(ans);
    }
}
