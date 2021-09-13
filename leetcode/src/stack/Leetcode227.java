package stack;

import java.util.Stack;

public class Leetcode227 {
    public int calculate(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        s = s.replace(" ", "");

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                sb.append(c);
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    sb.append(s.charAt(++i));
                }
                stack.add(sb.toString());
            } else {
                if (c == '*') {
                    int a = Integer.parseInt(stack.pop());
                    while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                        sb.append(s.charAt(++i));
                    }
                    int b = Integer.parseInt(sb.toString());
                    stack.add(String.valueOf(a * b));
                } else if (c == '/') {
                    int a = Integer.parseInt(stack.pop());

                    while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                        sb.append(s.charAt(++i));
                    }
                    int b = Integer.parseInt(sb.toString());
                    stack.add(String.valueOf(a / b));
                } else if (c == '-') {
                    while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                        sb.append(s.charAt(++i));
                    }
                    stack.add(String.valueOf(-Integer.parseInt(sb.toString())));
                } else {
                    while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                        sb.append(s.charAt(++i));
                    }
                    stack.add(sb.toString());
                }
            }
            sb.delete(0, sb.length());
        }

        int result = 0;

        for (String value : stack) {
            result += Integer.parseInt(value);
        }
        return result;
    }

    public int simple(String s) {
        if (s.length() == 1) {
            return Character.getNumericValue(s.charAt(0));
        }
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char operator = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = (num * 10) + Character.getNumericValue(c);
            }

            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                switch (operator) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                }

                operator = c;
                num = 0;
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        Leetcode227 leetcode227 = new Leetcode227();
        int calculate = leetcode227.simple("0-2147483647 / 22");
        System.out.println(calculate);
    }
}
