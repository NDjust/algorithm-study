package Basic;

import java.util.Scanner;

public class baekjoon11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String num = sc.nextLine();
        int ans = 0;

        for (int i = 0; i <num.length() ; i++) {
            ans += Integer.parseInt(Character.toString(num.charAt(i)));
        }
        System.out.println(ans);
    }
}
