package Basic;

import java.util.Scanner;

public class baekjoon2446 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < 2*n-1; i++) {
            int k = i;
            if (i > n - 1) {
                k = 2*n - i - 2;
            }
            for (int j = 1; j <= 2*n-1-k; j++) {
                if (j <= k) {
                    System.out.printf(" ");
                } else {
                    System.out.printf("*");
                }
            }
            System.out.println();
        }
    }
}
