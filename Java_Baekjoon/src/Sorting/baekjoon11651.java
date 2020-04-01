package Sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class baekjoon11651 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> a = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> b = new ArrayList<>();
            b.add(sc.nextInt());
            b.add(sc.nextInt());
            a.add(b);
        }

        a.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> t1, List<Integer> t2) {
                if (t1.get(1).equals(t2.get(1))) {
                    return t1.get(0) - t2.get(0);
                } else {
                    return t1.get(1) - t2.get(1);
                }
            }
        });

        for (int i = 0; i < n; i++) {
            System.out.printf("%d %d\n", a.get(i).get(0), a.get(i).get(1));
        }
    }
}
