package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class baekjoon11399 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Integer> times = new ArrayList<Integer>();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            times.add(sc.nextInt());
        }

        sc.nextLine();

        Collections.sort(times);
        int[] result = new int[n];
        int r = 0;

        for (int i = 0; i < n; i++) {
            sum += times.get(i);
            r += sum;

        }

        System.out.println(r);
    }
}
