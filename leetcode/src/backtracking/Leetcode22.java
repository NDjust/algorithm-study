package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode22 {

    private char[] bracket = new char[]{'(', ')'};

    private int[] bracketCount;

    List<String> parenthesisBrackets = new ArrayList<>();

    private StringBuilder selected = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        bracketCount = new int[2];
        bracketCount[0] = n;
        bracketCount[1] = n;

//        searchParenthesis(n);
        backTracking(n, n);

        return parenthesisBrackets;
    }


    private void backTracking(int l, int r) {
        if (l == 0 && r == 0) {
            parenthesisBrackets.add(selected.toString());
            return;
        }

        if (l > 0) {
            selected.append("(");
            backTracking(l-1, r);
            selected.delete(selected.length()-1, selected.length());
        }

        if (l < r && r > 0) {
            selected.append(")");
            backTracking(l, r-1);
            selected.delete(selected.length()-1, selected.length());
        }

    }

    private void searchParenthesis(final int n) {
        if (selected.length() == n * 2) {
            if (isParenthesis()) {
                parenthesisBrackets.add(selected.toString());
            }
            return;
        }

        for (int i = 0; i < 2; i++) {

            if (selected.length() == 0 && bracket[i] == ')') {
                continue;
            }

            selected.append(bracket[i]);
            searchParenthesis(n);
            selected.delete(selected.length() - 1, selected.length());
        }
    }

    private boolean isParenthesis() {
        Stack<Character> stack = new Stack<>();

        stack.add(selected.charAt(0));

        for (int i = 1; i < selected.length(); i++) {
            char c = selected.charAt(i);

            if (stack.isEmpty()) {
                stack.add(c);
                continue;
            }

            if (stack.peek() == '(') {
                if (c == ')') {
                    stack.pop();
                } else {
                    stack.add(c);
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Leetcode22 leetcode22 = new Leetcode22();
        List<String> list = leetcode22.generateParenthesis(3);

        for (String s : list) {
            System.out.println(s);
        }
    }

}
