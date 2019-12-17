package Mathematics;

import java.util.Scanner;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int CommonDivisor = 1;

        for (int i = 2; i <= Math.min(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                CommonDivisor = i;
            }
        }

        System.out.println(CommonDivisor);

        GreatestCommonDivisor gcd = new GreatestCommonDivisor();
        CommonDivisor = gcd.RecursiveGcd(a, b);
        CommonDivisor = gcd.RecursiveGcd(CommonDivisor, c);  // Ternary.

        System.out.println(CommonDivisor);

        CommonDivisor = gcd.Euclidean(a , b);
        System.out.println(CommonDivisor);
    }

    public int RecursiveGcd(int a, int b) {
        if (b== 0) {
            return a;
        } else {
            return RecursiveGcd(b, a % b);
        }
    }

    public int Euclidean(int a , int b) {
        /* Quick better than Simple gcd Algorithms */
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
