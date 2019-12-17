package Dynamic;

import java.util.*;

public class baekjoon2579 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nums = Integer.parseInt(sc.nextLine());
        int a[] = new int[nums + 1];
        int d[] = new int[nums + 1];

        for (int i = 1; i <= nums; i++) {
            a[i] = sc.nextInt();
        }

        d[1] = a[1];
        d[2] = a[1] + a[2];

        for (int i = 3; i <= nums; i++) {
            d[i] = Math.max(d[i - 2] + a[i], d[i -3] + a[i] + a[i - 1]);
        }

        System.out.printf("%d", d[nums]);
    }
}
