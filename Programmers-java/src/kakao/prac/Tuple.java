package kakao.prac;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Tuple {

    public int[] solution(String s) {
        List<String> numbers = Arrays.stream(
                        s.replaceAll("[{]", "")
                        .replaceAll("[}]", "")
                        .trim()
                        .split(","))
                        .collect(Collectors.toList());

        Set<String> unique = new HashSet<>(numbers);

        List<Num> nums = new ArrayList<>();

        for (String num : unique) {
            long count = numbers.stream()
                    .filter(num::equals)
                    .count();
            nums.add(new Num(Integer.parseInt(num), count));
        }


        nums.sort((n1, n2) -> (Long.compare(n2.count, n1.count)));
        int[] ans = new int[nums.size()];

        for (int i = 0; i < nums.size(); i++) {
            ans[i] = nums.get(i).value;
        }

        return ans;
    }

    private static class Num {
        int value;
        long count;

        public Num(final int value, final long count) {
            this.value = value;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Num{" +
                    "value=" + value +
                    ", count=" + count +
                    '}';
        }
    }

    public static void main(String[] args) {
        Tuple tuple = new Tuple();

        int[] solution = tuple.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
        System.out.println(Arrays.toString(solution));
    }
}
