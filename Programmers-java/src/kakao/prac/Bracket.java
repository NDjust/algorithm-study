package kakao.prac;

import java.util.Stack;

public class Bracket {

    public String solution(String p) {

        if (p.length() == 0) {
            return "";
        }
        return recursive(p);
    }

    public String recursive(String p) {
        if (p.length() == 0) {
            return "";
        }


        int wStartidx = getStartidx(p);

        String u = p.substring(0, wStartidx);
        String v = p.substring(wStartidx);

        if (isCorrectBracket(u)) {
            return u + recursive(v);
        } else {
            String s = "(";
            String result = recursive(v);
            s = s + result + ")";
            String uSub = u.substring(1, u.length() - 1);
            String reverse = reverse(uSub);
            s = s + reverse;
            return s;
        }
    }

    private String reverse(final String uSub) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < uSub.length(); i++) {
            char c = uSub.charAt(i);
            if (c == '(') {
                sb.append(')');
            } else {
                sb.append("(");
            }
        }

        return sb.toString();
    }

    private boolean isCorrectBracket(final String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.add(c);
            } else {
                Character peek = stack.peek();

                if (peek == '(' && c == ')') {
                    stack.pop();
                } else {
                    stack.add(c);
                }
            }
        }

        return stack.isEmpty();
    }

    private int getStartidx(final String p) {
        int openCnt = 0;
        int closeCnt = 0;

        int wIdx = 0;

        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);

            if (c == '(') {
                openCnt++;
            } else {
                closeCnt++;
            }

            if (openCnt == closeCnt) {
                return i + 1;
            }
        }

        if (p.length() == 2) {
            return 2;
        }

        return wIdx;
    }

    public static void main(String[] args) {
        Bracket bracket = new Bracket();

        bracket.solution(")(");
    }
}
