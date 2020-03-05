package NotSolve;

import java.util.ArrayList;
import java.util.Scanner;

public class baekjoon4949 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> ans = new ArrayList<String>();

        while (true) {
            String sentence = sc.nextLine();
            ArrayList<Character> stack = new ArrayList<Character>();

            if (sentence.equals(".")) {
                break;
            }

            for (int i = 0; i < sentence.length(); i++) {
                char c = sentence.charAt(i);
                if (c == '[' || c == '(') {
                    stack.add(c);
                } else if (c == ']' && stack.size() > 0) {
                    if (stack.get(stack.size() - 1) == '[') {
                        stack.remove(stack.size() - 1);
                    }
                } else if (c == ')' && stack.size() > 0) {
                    if (stack.get(stack.size() - 1) == '(') {
                        stack.remove(stack.size() - 1);
                    }
                }
            }

            if (stack.size() > 0) {
                ans.add("no");
            } else {
                ans.add("yes");
            }
        }

        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
}
