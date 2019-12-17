package Dynamic;

import java.util.*;

public class baekjoon11054 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int input_nums = Integer.parseInt(sc.nextLine());
        int a[] = new int[input_nums];
        int d1[] = new int[input_nums]; // increase max length
        int d2[] = new int[input_nums]; // decrease max length

        for (int i = 0; i < input_nums; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < input_nums; i++) {
            d1[i] = 1;
            d2[input_nums - i - 1] = 1;
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i] && d1[i] < d1[j] + 1) { // increase
                    d1[i] = d1[j] + 1;
                }
                if (a[input_nums - j - 1] < a[input_nums -i -1] && d2[input_nums - i - 1] < d2[input_nums - j -1] + 1) { // decrease
                    d2[input_nums -i -1] = d2[input_nums -j - 1] + 1;
                }
            }
        }

        int max_length = d1[0] + d2[0] - 1;

        for (int i = 0; i < input_nums; i++) {
            if (max_length < (d1[i] + d2[i] - 1)) {
                max_length = d1[i] + d2[i] - 1;
            }
        }
        System.out.printf("%d", max_length);
    }
}
