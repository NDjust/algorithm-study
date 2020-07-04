package nctest;

import java.util.Stack;

public class Problem2 {

    public static String solution(String compressed) {
        Stack<Character> stack = new Stack<>();
        String ans = "";
        String str = "";
        for (int i = 0; i < compressed.length(); i++) {
            char c = compressed.charAt(i);
            if (c == ')') {
                String word = "";
                while (true) {
                    char p = stack.pop();
                    if (p == '(') {
                        break;
                    }
                    word = p + word;
                }
                char pop = stack.pop();
                if (0 <= pop - 48 && 9 >= pop - 48) {
                    int cnt = pop - 48;
                    if (stack.contains('(')) {
                        for (int j = 0; j < cnt; j++) {
                            str = str + word;
                        }
                    } else {
                        if (str.equals("")) {
                            str = word;
                        }

                        for (int j = 0; j < cnt; j++) {
                            ans = ans + str;
                        }
                        str = "";
                    }
                }
            } else if (stack.isEmpty() && c >= 97 && c <= 122){
                ans += c;
            } else {
                stack.add(c);
            }
        }

        while (!stack.isEmpty()) {
            ans += stack.pop();
        }

        return ans;
    }
    public static void main(String[] args) {
        solution("2(2(hi)2(co))x2(bo)");
        System.out.println(solution("10(p)"));
    }
}
