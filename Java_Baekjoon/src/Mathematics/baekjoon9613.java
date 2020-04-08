package Mathematics;

import java.util.Scanner;

public class baekjoon9613 {
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int inputCases = Integer.parseInt(sc.nextLine());


        for (int i = 0; i < inputCases; i++) {
            int nums = sc.nextInt();
            int testCase[] = new int[nums];

            long gcd_sum = 0;

            for (int j = 0; j < nums; j++) {
                testCase[j] = sc.nextInt();
            }

            for (int k = 0; k < nums - 1; k++) {
                for (int l = k + 1; l < nums; l++) {
                    gcd_sum += gcd(testCase[k], testCase[l]);
                }
            }
            System.out.println(gcd_sum);
        }
    }

}
