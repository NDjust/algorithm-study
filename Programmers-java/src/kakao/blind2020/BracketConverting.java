package kakao.blind2020;

import java.util.Scanner;

public class BracketConverting {

    public static int division(String p) {
        int close = 0;
        int open = 0;
        int i;
        for (i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }

            if (open == close) {
                return i + 1;
            }
        }
        return i;
    }

    public static String reverse(String p) {
        StringBuffer ret = new StringBuffer();

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == ')') {
                ret.append('(');
            } else {
                ret.append(')');
            }
        }
        return ret.toString();
    }

    public static boolean isRight(String p) {
        int count = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }

            if (count == -1) {
                return false;
            }
        }
        return true;
    }

    public static String solution(String p) {
        String answer = "";

        if (p.length() == 0) {
            return "";
        }

        int cut = division(p);
        String u = p.substring(0, cut);
        String v = p.substring(cut, p.length());

        if (isRight(u)) {
            return u + solution(v);
        } else {
            String temp = '(' + solution(v) + ')';
            u = u.substring(1, u.length()-1);
            u = reverse(u);
            return temp + u;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        solution(s);
    }
}
