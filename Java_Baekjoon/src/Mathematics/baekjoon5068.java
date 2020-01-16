package Mathematics;

import java.util.ArrayList;
import java.util.Scanner;

public class baekjoon5068 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> ans = new ArrayList<String>();
        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (a == 0 && b == 0) {
                break;
            }

            if (b % a == 0) {
                ans.add("factor");
            }else if (a % b == 0) {
                ans.add("multiple");
            } else {
                ans.add("neither");
            }

            sc.nextLine();
        }

        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
}
