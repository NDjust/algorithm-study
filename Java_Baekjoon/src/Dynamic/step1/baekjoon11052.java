package Dynamic.step1;

import java.util.Scanner;

public class baekjoon11052 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] cardPrice = new int[n + 1];
        int[] d = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            cardPrice[i] = sc.nextInt();
        }

        d[0] = 0;
        d[1] = cardPrice[1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (cardPrice[j] + d[i-j] >= d[i]) {
                    d[i] = d[i-j] + cardPrice[j];
                }
            }
        }
        System.out.println(d[n]);
    }
}
