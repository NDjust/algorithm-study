package Dynamic.step1;

import java.util.*;

public class baekjoon11054 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int a[] = new int[n];
        int d1[] = new int[n]; // increase max length
        int d2[] = new int[n]; // decrease max length

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            d1[i] = 1;
            d2[n - i - 1] = 1;
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i] && d1[i] < d1[j] + 1) { // increase
                    d1[i] = d1[j] + 1;
                }
                if (a[n - j - 1] < a[n -i -1] && d2[n - i - 1] < d2[n - j -1] + 1) { // decrease
                    d2[n -i -1] = d2[n -j - 1] + 1;
                }
            }
        }

        int maxLength = d1[0] + d2[0] - 1;

        for (int i = 0; i < n; i++) {
            if (maxLength < (d1[i] + d2[i] - 1)) {
                maxLength = d1[i] + d2[i] - 1;
            }
        }
        System.out.printf("%d", maxLength);
    }
}
