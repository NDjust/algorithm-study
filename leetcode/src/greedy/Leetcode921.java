package greedy;

import java.util.List;
import java.util.Stack;

public class Leetcode921 {

    public int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack<>();

        if (S.length() == 0) {
            return 0;
        }

        stack.add(S.charAt(0));

        for (int i = 1; i < S.length(); i++) {
            char nextChar = S.charAt(i);
            if (stack.isEmpty()) {
                stack.add(nextChar);
                continue;

            }
            char peek = stack.peek();

            if (peek == '(' && nextChar == ')') {
                stack.pop();
            } else {
                stack.add(nextChar);
            }
        }

        return stack.size();
    }
}
