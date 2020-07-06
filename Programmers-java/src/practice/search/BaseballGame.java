package practice.search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BaseballGame {

    public int solution(int[][] baseball) {
        List<String> numbers = IntStream.range(111, 1000)
                .boxed()
                .map(num -> Integer.toString(num))
                .filter(num -> !num.contains("0") && new HashSet<>(Arrays.asList(num.split(""))).size() == 3)
                .collect(Collectors.toList());


        for (int[] balls : baseball) {
            String targetNum = Integer.toString(balls[0]);
            int strike = balls[1];
            int ball = balls[2];

            numbers.removeIf(compareNum -> !isPass(compareNum, targetNum, strike, ball));
        }

        return numbers.size();
    }

    public boolean isPass(String compareNum, String targetNum, int strikeNum, int ballNum) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < compareNum.length(); i++) {
            if (compareNum.charAt(i) == targetNum.charAt(i)) {
                strike++;
            } else if (compareNum.charAt(i) != targetNum.charAt(i) && targetNum.contains(Character.toString(compareNum.charAt(i)))) {
                ball++;
            }
        }

        return strike == strikeNum && ball == ballNum;
    }

    public static void main(String[] args) {
        String a = "123";
        String b = "35";

        System.out.println(a.contains(Character.toString(b.charAt(0))));

        BaseballGame baseballGame = new BaseballGame();
        int solution = baseballGame.solution(new int[][]{{123, 1, 0}});
        System.out.println(solution);
    }
}
