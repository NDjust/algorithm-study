package Basic;

import java.util.Scanner;

public class baekjoon1316 {
    public static boolean checker(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toChars(s.charAt(0)));
        for (int i = 1; i < s.length(); i++) {
            String a = Character.toString(s.charAt(i));
            if (sb.charAt(sb.length() - 1) == a.charAt(0)) {
                sb.append(a);
            } else {
                for (int j = 0; j < sb.length(); j++) {
                    if (Character.toString(sb.charAt(j)).equals(a)) {
                        return false;
                    }
                }
                sb.append(a);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int ans = 0;

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            if (checker(s)) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
