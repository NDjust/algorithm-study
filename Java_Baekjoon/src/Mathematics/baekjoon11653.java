package Mathematics;

import java.util.ArrayList;
import java.util.Scanner;

public class baekjoon11653 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int a = 2;

        while (n != 1) {
            if (n % a == 0) {
                n = n / a;
                ans.add(a);
            } else {
                a++;
            }
        }

        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
}
