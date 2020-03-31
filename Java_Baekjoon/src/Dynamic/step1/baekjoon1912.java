package Dynamic.step1;
import java.util.*;

public class baekjoon1912 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int a[] = new int[n];
        int d[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        d[0] = a[0];
        for (int i = 1; i < n; i++) {
            d[i] = a[i];
            if (d[i] < d[i - 1] + a[i]) {
                d[i] = d[i - 1] + a[i];
            }
        }

        int maxNum = d[0];

        for (int i = 1; i < n; i++) {
            if (maxNum < d[i]) {
                maxNum = d[i];
            }
        }

        System.out.printf("%d", maxNum);
    }
}
