package Mathematics;

import java.util.Scanner;

public class baekjoon1934 {
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int LeastCommonMultiple[] =  new int[n];

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            sc.nextLine();
            int CommonDivisor = gcd(a, b);
            LeastCommonMultiple[i] = CommonDivisor * (a / CommonDivisor) * (b / CommonDivisor);
        }

        for (int i = 0; i < n; i++) {
            System.out.println(LeastCommonMultiple[i]);
        }

    }
}
