package practice.sort;

import java.util.Arrays;
import java.util.Comparator;

public class MaxNum {

    public static void change(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void sortingNums(int[] numbers) {

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                String a = Integer.toString(numbers[i]);
                String b = Integer.toString(numbers[j]);
                if (Integer.parseInt(a + b) < Integer.parseInt(b + a)) {
                    change(numbers, i, j);
                }
            }

        }
    }

    public static String solution(int[] numbers) {
        String answer = "";

        Integer[] nums = new Integer[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            nums[i] = numbers[i];
        }
        Arrays.sort(nums,  new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                String x = a.toString();
                String y = b.toString();

                return ((y +  x)).compareTo(x + y);
            }
        });

        for (int i = 0; i < nums.length; i++) {
            answer += String.valueOf(nums[i]);
        }

        if (answer.charAt(0) == '0') {
            return "0";
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] input = {6, 10, 2};
        System.out.println(solution(input));
    }
}

