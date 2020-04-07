package etc;

import java.util.Arrays;
import java.util.Scanner;

public class baekjoon11656 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] ans = new String[str.length()];

        for (int i = 0; i < str.length(); i++) {
            ans[i] = str.substring(i, str.length());
        }

        Arrays.sort(ans);
        for (int i = 0; i < str.length(); i++) {
            System.out.println(ans[i]);
        }

    }
}
