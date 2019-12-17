package Dynamic;
import java.util.*;

public class baekjoon1912 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nums = Integer.parseInt(sc.nextLine());
        int a[] = new int[nums];
        int d[] = new int[nums];

        for (int i = 0; i < nums; i++) {
            a[i] = sc.nextInt();
        }

        d[0] = a[0];
        for (int i = 1; i < nums; i++) {
            d[i] = a[i];
            if (d[i] < d[i - 1] + a[i]) {
                d[i] = d[i - 1] + a[i];
            }
        }

        int max_num = d[0];

        for (int i = 1; i < nums; i++) {
            if (max_num < d[i]) {
                max_num = d[i];
            }
        }

        System.out.printf("%d", max_num);
    }
}
