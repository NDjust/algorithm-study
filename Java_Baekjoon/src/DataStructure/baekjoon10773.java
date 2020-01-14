package DataStructure;

import java.util.ArrayList;
import java.util.Scanner;

public class baekjoon10773 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] input = new int[n];
        ArrayList<Integer> given = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(sc.nextLine());
        }

        given.add(input[0]);

        for (int i = 1; i < n; i++) {
            if (input[i] > 0) {
                given.add(input[i]);
            } else {
                given.remove(given.size() - 1);
            }
        }
        int ans = 0;
        for (int i = 0; i < given.size(); i++) {
            ans += given.get(i);
        }

        System.out.println(ans);
    }
}
