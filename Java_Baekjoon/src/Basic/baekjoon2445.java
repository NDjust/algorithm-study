package Basic;

import java.util.Scanner;

public class baekjoon2445 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();


        for (int i = 1; i <= 2*n-1; i++) {
            for (int j = 1; j <= 2*n; j++) {
                int k = i;
                if (i > n) {
                    k = 2*n-i;
                }
                if (k >= j) {
                    System.out.printf("*");
                } else if (j > 2*n-k) {
                    System.out.printf("*");
                } else {
                    System.out.printf(" ");
                }
            }
            System.out.println();
        }
    }
}
