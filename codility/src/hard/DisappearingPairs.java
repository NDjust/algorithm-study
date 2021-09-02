package hard;

import java.util.Stack;

public class DisappearingPairs {

    public String solution(String S) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            if (stack.isEmpty()) {
                stack.add(c);
            } else {
                char peek = stack.peek();
                if (peek == 'A' && c == 'A') {
                    stack.pop();
                } else if (peek == 'B' && c == 'B') {
                    stack.pop();
                } else if (peek == 'C' && c == 'C') {
                    stack.pop();
                } else {
                    stack.add(c);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}
