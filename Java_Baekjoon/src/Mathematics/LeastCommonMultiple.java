package Mathematics;

import java.util.Scanner;

public class LeastCommonMultiple {
    public static int gcd(int a , int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int CommonDivisor = gcd(a, b);

        int l = CommonDivisor*(a / CommonDivisor) * (b / CommonDivisor);

        System.out.println(l);
    }



}
