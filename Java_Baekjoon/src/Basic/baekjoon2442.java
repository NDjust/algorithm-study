package Basic;

import java.util.Scanner;

public class baekjoon2442 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            int starIdx = 2*i - 1;
            int side = (2*n - 1 - (starIdx)) / 2;
            for (int j = 1; j <= 2*n - 1; j++) {
                if (j <= side) {
                    System.out.printf(" ");
                } else if (j <= starIdx + side) {
                    System.out.printf("*");
                }
            }
            System.out.println();
        }
    }
}
