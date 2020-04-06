package etc;

import java.io.IOException;
import java.util.Scanner;

public class baekjoon10808 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] ans = new int[26];

        for (int i = 0; i < str.length(); i++) {
            int alpha = str.charAt(i);
            int index = alpha - 97;
            ans[index] += 1;
        }

        for (int i = 0; i < 26; i++) {
            System.out.printf("%d ", ans[i]);
        }
    }
}
