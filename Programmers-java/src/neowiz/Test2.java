package neowiz;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test2 {

    private static int n;

    private static int d[];

    private static int count = 0;
    public static int solution(int[] s) {
        n = s.length;
        d = new int[s.length];

        Arrays.fill(d, -1);

        List<Integer> numbers = Arrays.stream(s)
                .boxed()
                .collect(Collectors.toList());

        if (isCorrect(0, numbers)) {
            d[0] = 0;
        } else {
            d[0] = 1;
        }

        int a = findMinCount(numbers, 1);

        return a;
    }

    private static int findMinCount(List<Integer> numbers, int i) {
        if (i == n) {
            return count;
        }

        if (d[i] != -1) {
            return d[i];
        }

        if (isCorrect(i, numbers)) {
            d[i] = d[i-1];
            return findMinCount(numbers, i+1);
        } else {
            if (i % 2 == 0) {
                numbers.add(i, Integer.MIN_VALUE);
                count++;
                int minCount1 = findMinCount(numbers, i + 1);
                numbers.remove(i);
                count--;
                numbers.add(i+1, Integer.MAX_VALUE);
                int minCount2 = findMinCount(numbers, i + 1);
                count++;
                numbers.remove(i+1);
                count--;
                d[i] = Math.min(minCount1, minCount2);
                return Math.min(minCount1, minCount2);
            } else {
                numbers.add(i, Integer.MAX_VALUE);
                count++;
                int minCount1 = findMinCount(numbers, i + 1);
                numbers.remove(i);
                count--;
                numbers.add(i+1, Integer.MIN_VALUE);
                count++;
                int minCount2 = findMinCount(numbers, i + 1);
                numbers.remove(i+1);
                count--;
                d[i] = Math.min(minCount1, minCount2);
                return Math.min(minCount1, minCount2);
            }
        }
    }

    private static boolean isCorrect(int i, List<Integer> numbers) {
        if (i % 2 == 0) {
            return numbers.get(i) < numbers.get(i+1);
        } else {
            return numbers.get(i) > numbers.get(i+1);
        }
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        int[] s = new int[] {1,2,3};
        System.out.println(test2.solution(s));
    }
}
