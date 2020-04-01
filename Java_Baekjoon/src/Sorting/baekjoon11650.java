package Sorting;

import java.util.*;

public class baekjoon11650 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> xy = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> a = new ArrayList<>();
            a.add(sc.nextInt());
            a.add(sc.nextInt());
            xy.add(a);
        }

        xy.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> t1, List<Integer> t2) {
                if (t1.get(0).equals(t2.get(0))) {
                    return t1.get(1) - t2.get(1);
                } else {
                    return t1.get(0) - t2.get(0);
                }
            }
        });

        for (int i = 0; i < n; i++) {
            System.out.printf("%d %d\n", xy.get(i).get(0), xy.get(i).get(1));
        }
    }
}
