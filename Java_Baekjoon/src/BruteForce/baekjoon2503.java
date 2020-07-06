package BruteForce;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class baekjoon2503 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<String> baseballNumbers = IntStream.range(100, 1000)
                .boxed()
                .map(num -> Integer.toString(num))
                .filter(num -> !num.contains("0") && new HashSet<>(Arrays.asList(num.split(""))).size() == 3)
                .collect(Collectors.toList());

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            String target= input[0];
            int strikeCount = Integer.parseInt(input[1]);
            int ballCount = Integer.parseInt(input[2]);

            baseballNumbers.removeIf(compareNum -> !isPass(compareNum, target, strikeCount, ballCount));
        }

        System.out.println(baseballNumbers.size());
    }

    public static boolean isPass(String compareNum, String targetNum, int strikeNum, int ballNum) {
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
}
