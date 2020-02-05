package DataStructure.stack;

import java.util.Scanner;
import java.util.Stack;

public class baekjoon6549 {
    private static int [] a = new int[100000];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int n = sc.nextInt();

            if (n == 0) {
                break;
            }

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            Stack<Integer> s = new Stack<Integer>();
            long ans = 0;

            for (int i = 0; i < n; i++) {
                int left = i;

                while (!s.empty() && a[s.peek()] > a[i]) {
                    long height = a[s.peek()];
                    s.pop();
                    long width = i;

                    if (!s.empty()) {
                        width = (i - s.peek() - 1);
                    }

                    if (ans < width * height) {
                        ans = width * height;
                    }
                }
                s.push(i);
            }
            while (!s.empty()) {
                long height = a[s.peek()];

                s.pop();
                long width = n;

                if (!s.empty()) {
                    width = n - s.peek() - 1;
                }

                if (ans < width * height) {
                    ans = width * height;
                }
            }
            System.out.println(ans);
        }
    }
}
