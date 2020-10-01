package string;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Leetcode1249 {

    public String minRemoveToMakeValid(String s) {
        Stack<Character> bracket = new Stack<>();
        Stack<Integer> bracketIdx = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                bracket.add(c);
                bracketIdx.add(i);
            } else if (c == ')'){
                if (!bracket.isEmpty() && bracket.peek() == '(') {
                    bracket.pop();
                    bracketIdx.pop();
                } else {
                    bracket.add(c);
                    bracketIdx.add(i);
                }
            }
        }

        Set<Integer> idx = new HashSet<>();

        while (!bracketIdx.isEmpty()) {
            idx.add(bracketIdx.pop());
        }


        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!idx.contains(i)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
