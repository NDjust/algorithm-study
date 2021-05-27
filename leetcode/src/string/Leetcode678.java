package string;

import java.util.Stack;

public class Leetcode678 {

    public boolean checkValidString(String s) {
        Stack<Integer> bracket = new Stack<>();
        Stack<Integer> star = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                bracket.add(i);
            } else if (c == '*') {
                star.add(i);
            } else {
                if (!bracket.isEmpty()) {
                    bracket.pop();
                } else if (!star.isEmpty()) {
                    star.pop();
                } else {
                    return false;
                }
            }
        }

        while (!bracket.isEmpty()) {
            if (star.isEmpty()) {
                return false;
            } else if (bracket.peek() < star.peek()) {
                bracket.pop();
                star.pop();
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Leetcode678 leetcode678 = new Leetcode678();
        System.out.println(leetcode678.checkValidString("(*)"));
    }
}
