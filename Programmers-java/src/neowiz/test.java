package neowiz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class test {
    // 스택 내에서 연산자 우선순위 맵
    private static Map<Character, Integer> operPriorityMap;
    private static Stack<Character> operStack;

    static {
        operPriorityMap = new HashMap<>();
        operPriorityMap.put('(', 0);
        operPriorityMap.put('+', 1);
        operPriorityMap.put('-', 1);
        operPriorityMap.put('*', 2);
        operPriorityMap.put('/', 2);

        operStack = new Stack<>();
    }

    public static List<Character> makePrefix(String input) {
        List<Character> output = new ArrayList<>();

        char[] inputChars = input.toCharArray();

        for (int i = 0; i < inputChars.length; i++) {
            char c = inputChars[i];

            // 연산자
            if (isOperation(c)) {
                // 연산자 스택이 비었다면 push
                if (operStack.isEmpty()) {
                    operStack.push(c);
                } // 연산자 우선순위 비교
                else {
                    // 닫는 괄호일경우 여는 괄호 '(' 가 나올떄까지 pop
                    if (c == ')') {
                        char top = ' ';
                        do {
                            top = operStack.pop();
                            if (top != '(') {
                                output.add(top);
                            }
                        } while (top != '(');
                    } // 여는 괄호는 무조건 push
                    else if (c == '(') {
                        operStack.push(c);
                    } // 그외 연산자인 경우
                    else {
                        int tokenPriority = operPriorityMap.get(c);

                        char top = operStack.peek();
                        int topPriority = operPriorityMap.get(top);
                        // 토큰의 우선순위가 더 높다면 스택에 추가
                        if (tokenPriority > topPriority) {
                            operStack.push(c);
                        } // 토큰의 우선순위가 더 높을때까지 pop 한 후 push
                        else {
                            top = operStack.pop();
                            output.add(top);

                            do {
                                if (operStack.isEmpty()) {
                                    operStack.push(c);
                                } else {
                                    top = operStack.peek();
                                    topPriority = operPriorityMap.get(top);
                                    if (tokenPriority > topPriority) {
                                        operStack.push(c);
                                    } else {
                                        top = operStack.pop();
                                        output.add(top);
                                    }
                                }
                            } while (tokenPriority <= topPriority);
                        }
                    }
                }
            } // 피연산자
            else {
                output.add(c);
            }
        }
        return output;
    }
    public static void main(String[] args) {
        String input = "(6+5*(2-8)/2)";
        List<Character> output = new ArrayList<>();

        char[] inputChars = input.toCharArray();

        for (int i = 0; i < inputChars.length; i++) {
            char c = inputChars[i];

            // 연산자
            if (isOperation(c)) {
                // 연산자 스택이 비었다면 push 
                if (operStack.isEmpty()) {
                    operStack.push(c);
                } // 연산자 우선순위 비교 
                else {
                    // 닫는 괄호일경우 여는 괄호 '(' 가 나올떄까지 pop
                    if (c == ')') {
                        char top = ' ';
                        do {
                            top = operStack.pop();
                            if (top != '(') {
                                output.add(top);
                            }
                        } while (top != '(');
                    } // 여는 괄호는 무조건 push 
                    else if (c == '(') {
                        operStack.push(c);
                    } // 그외 연산자인 경우 
                    else {
                        int tokenPriority = operPriorityMap.get(c);

                        char top = operStack.peek();
                        int topPriority = operPriorityMap.get(top);
                        // 토큰의 우선순위가 더 높다면 스택에 추가
                        if (tokenPriority > topPriority) {
                            operStack.push(c);
                        } // 토큰의 우선순위가 더 높을때까지 pop 한 후 push 
                        else {
                            top = operStack.pop();
                            output.add(top);

                            do {
                                if (operStack.isEmpty()) {
                                    operStack.push(c);
                                } else {
                                    top = operStack.peek();
                                    topPriority = operPriorityMap.get(top);
                                    if (tokenPriority > topPriority) {
                                        operStack.push(c);
                                    } else {
                                        top = operStack.pop();
                                        output.add(top);
                                    }
                                }
                            } while (tokenPriority <= topPriority);
                        }
                    }
                }
            } // 피연산자
            else {
                output.add(c);
            }
        }

        // 6528-*2/+
        for (int i = 0; i < output.size(); i++) {
            System.out.printf("%c", output.get(i));
        }
    }

    /**
     * 연산자 여부 확인
     *
     * @param c
     * @return
     */
    public static boolean isOperation(char c) {
        if (')' == c) {
            return true;
        }

        return operPriorityMap.containsKey(c);
    }

}