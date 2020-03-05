package kakao.blind2020;

import java.util.Scanner;
import java.util.Stack;

public class StrCompression {

    public static int solution (String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length(); i++) {

            StringBuilder sb = new StringBuilder();
            Stack<String> stack = new Stack<>();
            int counts = 1;
            int sum = 0;

            stack.add(s.substring(0, i));

            for (int j = i; j < s.length(); j += i) {
                int start = j;
                int end = Math.min(j + i, s.length());

                String temp = s.substring(start, end);

                if (stack.peek().equals(temp)) {
                    counts++;
                } else {
                    if (counts != 1) {
                        sum += (int)Math.log10(counts)+1;
                    }
                    sum += stack.pop().length();
                    stack.add(temp);
                    counts = 1;
                }
            }

            if (!stack.isEmpty()) {
                if (counts != 1) {
                    sum += (int)Math.log10(counts) + 1;
                }
                sum += stack.pop().length();
            }

            answer = Math.min(sum, answer);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();


        System.out.println(solution(s));
    }
}
