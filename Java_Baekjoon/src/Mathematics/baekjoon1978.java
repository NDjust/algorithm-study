package Mathematics;

import java.util.Scanner;

public class baekjoon1978 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int totalPrime = 0;

        for (int i = 0; i < num; i++) {
            int n = sc.nextInt();
            if (is_prime(n)) {
                totalPrime++;
            }
        }

        System.out.println(totalPrime);


    }

    public static boolean is_prime(int a) {
        if (a < 2) {
            return false;
        } else if (a == 2) {
            return true;
        }

        for (int i = 2; i * i <= a; i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }
}
