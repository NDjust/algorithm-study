package kakao.intern2020;

import java.util.*;

public class Problem2 {
    static String[][] operatorCase = {{"+", "-", "*"},
            {"+", "*", "-"},
            {"-", "+", "*"},
            {"-", "*", "+"},
            {"*", "+", "-"},
            {"*", "-", "+"},};

    public static long operate(String left, String operator, String right) {
        long l = Long.parseLong(left);
        long r = Long.parseLong(right);
        if (operator.equals("*")) {
            return l * r;
        } else if (operator.equals("+")) {
            return l + r;
        } else {
            return l - r;
        }
    }


    public static long solution(String expression) {
        long answer = 0;
        long currentResult = 0;
        List<String> inputOperators = new ArrayList<>(Arrays.asList(expression.replaceAll("[0-9]", "").split("")));
        List<String> inputNumbers = new ArrayList<>(Arrays.asList(expression.split("[^0-9]")));
        List<String> values = new ArrayList<>();

        values.add(inputNumbers.remove(0));
        while (!inputNumbers.isEmpty()) {
            values.add(inputOperators.remove(0));
            values.add(inputNumbers.remove(0));
        }

        for (int i = 0; i < operatorCase.length; i++) {
            String[] operators = operatorCase[i];
            List<String> temp = new ArrayList<>(values);
            for (String operator : operators) {
                for (int j = 0; j < temp.size(); j++) {
                    if (temp.get(j).equals(operator)) {
                        String leftValue = temp.remove(j-1);
                        String currentOperator = temp.remove(j-1);
                        String rightValue = temp.remove(j-1);
                        temp.add(j-1, Long.toString(operate(leftValue, currentOperator, rightValue)));
                        j = j - 1;
                    }
                }
            }
            currentResult = Math.abs(Long.parseLong(temp.get(0)));

            if (answer < currentResult) {
                answer = currentResult;
            }

        }

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution("50*6-3*2"));
    }
}
