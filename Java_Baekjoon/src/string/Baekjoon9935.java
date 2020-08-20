package string;

import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

public class Baekjoon9935 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String bombStr = sc.nextLine();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            stack.add(str.charAt(i));

            if (stack.size() >= bombStr.length()) {
                boolean flag = true;
                for (int j = 0; j < bombStr.length(); j++) {
                    if (stack.get(stack.size() - j - 1) != bombStr.charAt(bombStr.length() - 1 - j)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    for (int j = 0; j < bombStr.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }

        String sb = stack.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
    }
}
