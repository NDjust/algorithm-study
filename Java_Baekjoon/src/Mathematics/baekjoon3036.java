package Mathematics;

import java.util.Scanner;

public class baekjoon3036 {

    public static int getGcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return getGcd(b, a % b);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] ring = new int[n];

        for (int i = 0; i < n; i++) {
            ring[i] = sc.nextInt();
        }

        for (int i = 1; i < n; i++) {
            int gcd = getGcd(ring[0], ring[i]);

            System.out.printf("%d/%d\n", ring[0] / gcd, ring[i] / gcd);
        }
    }
}
