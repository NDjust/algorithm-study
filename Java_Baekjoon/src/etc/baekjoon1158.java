package etc;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon1158 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> list = new LinkedList<>();
        List<Integer> ans = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < k; j++) {
                list.add(list.remove());
            }
            ans.add(list.remove());
        }

        System.out.printf("<");
        for (int i = 0; i < n; i++) {
            if (i == n-1) {
                System.out.printf("%d>", ans.get(i));
            } else {
                System.out.printf("%d, ", ans.get(i));
            }
        }
    }
}
