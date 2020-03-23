package Basic;

import java.util.Scanner;

public class baekjoon2443 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int a = 2*(n-i) - 1;
            int blankSize = ((2*n) - 1 - a) / 2;

            for (int j = 1; j <= 2*n-1; j++) {
                if (j <= blankSize) {
                    System.out.printf(" ");
                } else if (j <= a + blankSize){
                    System.out.printf("*");
                }
            }
            System.out.println();
        }
    }
}
