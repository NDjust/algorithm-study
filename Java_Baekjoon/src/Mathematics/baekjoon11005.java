package Mathematics;

import java.util.Scanner;

public class baekjoon11005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        sc.nextLine();

        StringBuilder result = new StringBuilder();
        while (n > 0) {
            int r = n % b;

            if (r < 10) {
                result.append((char)(r + '0'));
            } else {
                result.append((char)(r - 10 + 'A'));
            }
            n /= b;
        }
        System.out.println(result.reverse());
    }
}
