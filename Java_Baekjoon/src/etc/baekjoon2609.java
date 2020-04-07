package etc;

import java.util.Scanner;

public class baekjoon2609 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(getGcd(a, b));
        System.out.println(getLcm(a, b));
    }

    public static int getGcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static int RecursiveGcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return RecursiveGcd(b, a % b);
    }

    public static int getLcm(int a, int b) {
        int gcd = getGcd(a, b);
        int i = a / gcd;
        int j = b / gcd;

        return i * j * gcd;
    }
}
