package DataStructure.stack;

import java.util.Scanner;
import java.util.Stack;


public class baekjoon3111 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String t = sc.nextLine();

        int n = a.length();
        int m = t.length();

        boolean[] erased = new boolean[m];

        if (n == 1) {
            for (int i = 0; i < m; i++) {
                if (a.charAt(i) == t.charAt(0)) {
                    erased[i] = true;
                }
            }

            for (int i = 0; i < m; i++) {
                if (!erased[i]) {
                    System.out.printf("%c", t.charAt(i));
                }
            }
        } else {
            Stack<Character> left = new Stack<Character>();
            Stack<Character> right = new Stack<Character>();
            int k = 0;
            boolean isLeft = true;
            int l = 0;
            int r = m - 1;

            while (l == r) {

                if (isLeft) {
                    if (a.charAt(k) == t.charAt(l)) {
                        k++;
                    } else {
                        for (int j = 0; j < k; j++) {
                            left.push(a.charAt(j));
                        }
                        isLeft = false;
                        k = 0;
                    }
                    l++;
                } else {
                    if (a.charAt(n -1 -k) == t.charAt(r)) {
                        k++;
                    } else {
                        for (int j = k - 1; j >= 0; j--) {
                            right.push(a.charAt(j));
                        }
                        isLeft = true;
                        k = 0;
                    }
                    r--;
                }
            }
            System.out.println("Test");
            k = 0;

            /* 왼쪽 스택 오른쪽으로 옮기기
            while (!left.isEmpty()) {
                if (a.charAt(k) == left.get()) {
                    k++;
                } else {
                    for (int i = k - 1; i >= 0; i++) {
                        right.push(left.pop());
                    }
                }
            }

            for (int i = 0; i < right.size(); i++) {
                System.out.printf("%c", right.get(i));
            }
           */
        }

    }
}
