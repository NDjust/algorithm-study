package Basic;

import java.util.Scanner;

public class baekjoon10992 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2* n - 1; j++) {

                if (i == n - 1) {
                    System.out.printf("*");
                } else if (i == j - n + 1) {
                    System.out.printf("*");
                } else if (i + j == n - 1) {
                    System.out.printf("*");
                } else if (j < n + i){
                    System.out.printf(" ");
                }
            }

            if (i < n - 1) {
                System.out.println();
            }
        }
    }
}
