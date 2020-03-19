package practice.stackQueue;

import java.util.Stack;

public class stick {

    public static int solution(String arrangement) {
        int answer = 0;

        Stack<Character> bracket = new Stack<>();

        for (int i = 0; i < arrangement.length(); i++) {

            if (arrangement.charAt(i) == '(') {
                bracket.add(arrangement.charAt(i));
            } else {

                if (arrangement.charAt(i - 1) == '(') {
                    bracket.pop();
                    answer += bracket.size();
                } else {
                    bracket.pop();
                    answer++;
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        String arr = "()(((()())(())()))(())";

        System.out.println(solution(arr));
    }
}
