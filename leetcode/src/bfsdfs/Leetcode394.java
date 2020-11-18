package bfsdfs;

import java.util.Stack;

public class Leetcode394 {

    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (stack.isEmpty()) {
                stack.add(c);
            } else {

                if (c == ']') {
                    StringBuilder sb = new StringBuilder();

                    while (true) {
                        char last = stack.pop();

                        if (last == '[') {
                            break;
                        } else {
                            sb.append(last);
                        }
                    }

                    StringBuilder value = new StringBuilder();

                    while (true) {

                        if (stack.isEmpty()) {
                            break;
                        }

                        char pop = stack.pop();

                        if (pop < 48 || pop > 57) {
                            stack.add(pop);
                            break;
                        } else {
                            value.append(pop);
                        }
                    }

                    String multipleValue = reverseString(value.toString());

                    for (int j = 0; j < Integer.parseInt(multipleValue); j++) {
                        for (int k = 0; k < sb.length(); k++) {
                            stack.add(sb.charAt(sb.length() - 1 - k));
                        }
                    }
                } else {
                    stack.add(c);
                }
            }
        }

        for (char c : stack) {
            answer.append(c);
        }

        return answer.toString();
    }

    private String reverseString(final String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(s.length() - 1 - i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Leetcode394 leetcode394 = new Leetcode394();

        String s = leetcode394.decodeString("3[a]2[bc]");

        System.out.println(s);
    }
}
