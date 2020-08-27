package kakao.prac;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DartGame {

    private char[] bonus = new char[] {'S', 'D', 'T'};

    private char[] option = new char[] {'*', '#'};

    public int solution(String dartResult) {
        int ans = 0;
        boolean isFirst = true;

        Queue<String> dartInfo = new LinkedList<>();
        StringBuilder number = new StringBuilder();

        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);

            if (!isBonus(c) && !isOption(c)) {
                number.append(c);
            } else if (isBonus(c)) {
                dartInfo.add(number.toString());
                dartInfo.add(String.valueOf(c));
                number = new StringBuilder();
            } else if (isOption(c)) {
                dartInfo.add(String.valueOf(c));
            }

        }


        Stack<String> stack = new Stack<>();
        Stack<Integer> score = new Stack<>();


        while (!dartInfo.isEmpty()){
            String info = dartInfo.poll();

            if (stack.size() < 2) {
                stack.add(info);
            } else {
                calculateScore(stack, score, info);
            }
        }


        while (!stack.isEmpty()) {
            String bonus = stack.pop();
            String num = stack.pop();

            int calculate = calculate(num, bonus);
            score.add(calculate);
        }

        System.out.println(score.toString());

        for (Integer integer : score) {
            ans += integer;
        }


        return ans;
    }

    private void calculateScore(final Stack<String> stack, final Stack<Integer> score, final String info) {
        String bonus = stack.pop();
        String num = stack.pop();

        int calculate = calculate(num, bonus);

        if (info.equals("*")) {
            calculate = calculate * 2;

            if (!score.isEmpty()) {
                int previous = score.pop();
                score.add(previous * 2);
            }
        } else if (info.equals("#")) {
            calculate = calculate * -1;
        } else {
            stack.add(info);
        }

        score.add(calculate);
    }

    private int calculate(final String num, final String bonus) {
        int number = Integer.parseInt(num);

        switch (bonus) {
            case "S":
                number = (int) Math.pow(number, 1);
                break;
            case "D":
                number = (int) Math.pow(number, 2);
                break;
            case "T":
                number = (int) Math.pow(number, 3);
                break;
        }

        return number;

    }

    private boolean isOption(final char c) {
        for (char op : option) {
            if (op == c) {
                return true;
            }
        }
        return false;
    }

    private boolean isBonus(final char c) {
        for (char b : bonus) {
            if (b == c) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        DartGame dartGame = new DartGame();
        String a = "1D2S3T*";
        int solution = dartGame.solution(a);

        System.out.println(solution);
    }
}
