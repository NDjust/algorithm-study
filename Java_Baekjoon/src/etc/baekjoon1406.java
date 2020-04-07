package etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class baekjoon1406 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());

        Stack<Character> left = new Stack<Character>();
        Stack<Character> right = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            left.add(str.charAt(i));
        }

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");

            if (s.length == 2) {
                left.add(s[1].charAt(0));
            } else {
                String c = s[0];
                if (c.equals("L") && !left.isEmpty()) {
                    right.add(left.pop());
                }

                if (c.equals("D") && !right.isEmpty()) {
                    left.add(right.pop());
                }

                if (c.equals("B") && !left.isEmpty()) {
                    left.pop();
                }
            }
        }

        while (!left.isEmpty()) {
            right.add(left.pop());
        }
        StringBuilder sb = new StringBuilder();

        while (!right.isEmpty()) {
            sb.append(right.pop());
        }

        System.out.println(sb);
    }
}
