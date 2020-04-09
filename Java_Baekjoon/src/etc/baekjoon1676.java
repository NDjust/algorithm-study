package etc;

import java.util.Scanner;

public class baekjoon1676 {
    public static long cnt2;
    public static long cnt5;

    public static void result() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n == 0) {
            System.out.printf("0\n");
            return;
        }
        int count = 0;

        for (int i = 2; i <= n; ++i) {
            if (i % 5 == 0) {
                count++;
            }

            if (i % 25 == 0) {
                count++;
            }

            if (i % 125 == 0) {
                count++;
            }
        }

        System.out.printf("%d\n", count);
    }


    public static void main(String[] args) {
        result();
    }
}
