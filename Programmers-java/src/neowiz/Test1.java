package neowiz;

import java.util.*;

public class Test1 {

    private static Map<Character, Integer> operPriorityMap;
    private static Stack<Character> operStack;

    static {
        operPriorityMap = new HashMap<>();
        operPriorityMap.put('(', 0);
        operPriorityMap.put('+', 1);
        operPriorityMap.put('-', 1);
        operPriorityMap.put('x', 2);

        operStack = new Stack<>();
    }

    public static long solution(String expression) {
        long ans = Long.MIN_VALUE;

        for (int i = 0; i < expression.length(); i+=2) {
            for (int j = i+3; j < expression.length()+1; j += 2) {
                StringBuilder sb = new StringBuilder();
                sb.append("(");
                String front = expression.substring(0,i);
                String mid = expression.substring(i,j);
                String end = expression.substring(j);
                sb.append(front);
                sb.append("(");
                sb.append(mid);
                sb.append(")");
                sb.append(end);
                sb.append(")");
                Long calculate = calculate(sb.toString());
                if (calculate > ans) {
                    ans = calculate;
                }
            }
        }

        return ans;
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

    private static Long calculate(final String expression) {
        List<Character> characters = makePrefix(expression);
        Stack<Long> numberStack = new Stack<>();

        for(int i=0; i<characters.size(); i++) {
            char c = characters.get(i);

            // 피연산자이면 스택에 추가
            if(!isOperationPreFix(c)) {
                long num = Long.parseLong(Character.toString(c));
                numberStack.push(num);
            }
            else {
                long num1 = numberStack.pop();
                long num2 = numberStack.pop();
                long result = 0;
                switch(c) {
                    case '+' :
                        result = num2 + num1;
                        break;
                    case '-' :
                        result = num2 - num1;
                        break;
                    case 'x' :
                        result = num2 * num1;
                        break;
                }
                numberStack.push(result);
            }
        }

        return numberStack.pop();
    }

    public static boolean isOperationPreFix(char c) {
        char[] operations = {'(', ')', 'x', '+', '-'};
        for (final char operation : operations) {
            if (c == operation) {
                return true;
            }
        }
        return false;
    }

    private static boolean isOperation(final char exp) {
        if (')' == exp) {
            return true;
        }

        return operPriorityMap.containsKey(exp);
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        System.out.println(test1.solution("2-1x5-4x3+2"));
    }
}
