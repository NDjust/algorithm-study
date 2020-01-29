package DataStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon2164 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> q = new LinkedList<Integer>();

        for (int i = 0; i < n; i++) {
            q.add(i + 1);
        }

        while (q.size() != 1) {
            q.remove();
            int a = q.remove();
            q.add(a);
        }
        System.out.println(q.peek());
    }
}
