package Greedy;
// Fail.
import java.util.Arrays;
import java.util.Scanner;

public class baekjoon1049 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        int n = Integer.valueOf(line[0]);
        int m = Integer.valueOf(line[1]);
        int[] packPrice = new int[m];
        int[] eachPrice = new int[m];

        for (int i = 0; i < m; i++) {
            String[] l = sc.nextLine().split(" ");
            packPrice[i] = Integer.valueOf(l[0]);
            eachPrice[i] = Integer.valueOf(l[0]);
        }

        Arrays.sort(packPrice);
        Arrays.sort(eachPrice);
        int ans = 0;

        if ((eachPrice[0] * 6) <= packPrice[0]) {
            ans = eachPrice[0] * n;
        } else {
            int counts = n;
            while ((counts - 6) > 0) {
                ans += packPrice[0];
                counts -= 6;
            }

            if (packPrice[0] < (counts * eachPrice[0])) {
                ans += packPrice[0];
            } else {
                ans += eachPrice[0] * counts;
            }
        }

        System.out.println(ans);
    }
}
