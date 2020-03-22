package Basic;

import java.util.Scanner;

public class baekjoon10950 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] c = sc.nextLine().split(" ");
            int a = Integer.parseInt(c[0]);
            int b = Integer.parseInt(c[1]);

            System.out.println(a + b);
        }
    }
}
