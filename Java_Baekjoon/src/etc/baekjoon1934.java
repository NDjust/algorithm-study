package etc;

import java.util.Scanner;

public class baekjoon1934 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int gcd = getGcd(a, b);
            System.out.println((a / gcd) * (b / gcd) * gcd);
        }
    }

    public static int getGcd(int a, int b){
        if (b == 0) {
            return a;
        }
        return getGcd(b, a % b);
    }
}
