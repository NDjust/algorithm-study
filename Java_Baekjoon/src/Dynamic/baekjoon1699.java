package Dynamic;

import java.util.*;

public class baekjoon1699 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nums = Integer.parseInt(sc.nextLine());

        int d[] = new int[nums + 1];

        for (int i = 1; i <= nums; i++) {
            d[i] = i;
            for (int j = 0; j*j <= i; j++) {
                if (d[i] > d[i - j*j] + 1) {
                    d[i] = d[i - j*j] + 1;
                }
            }
        }
        System.out.println(d[nums]);
    }
}
