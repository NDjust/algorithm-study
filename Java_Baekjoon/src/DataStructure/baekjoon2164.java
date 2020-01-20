package DataStructure;

import java.util.ArrayList;
import java.util.Scanner;

public class baekjoon2164 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            if ((i + 1) % 2 == 0) {
                a.add(i + 1);
            } else {

            }
        }

        while (a.size() > 2) {
            a.remove(0);
            int k = a.remove(0);
            a.add(k);
        }

        System.out.println(a.get(1));
    }
}
