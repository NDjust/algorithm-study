package Basic;

import java.util.Scanner;

public class baekjoon11021 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.printf("Case #%d: %d\n",i + 1,  (a + b));
        }
    }
}
