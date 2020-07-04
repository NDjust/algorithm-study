package nctest;

import java.util.Stack;

public class Problem3 {

    public static int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.add(c);
            } else {
                char peek = stack.peek();
                if (peek == '0' && c == '1') {
                    stack.pop();
                } else if (peek == '1' && c == '0') {
                    stack.pop();
                } else {
                    stack.add(c);
                }
            }
        }

        return stack.size();
    }

    public static void main(String[] args) {
        System.out.println(solution("0110011"));
    }
}
