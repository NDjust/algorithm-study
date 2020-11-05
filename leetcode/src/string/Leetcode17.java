package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode17 {

    private List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {

        if (digits.length() == 0) {
            return new ArrayList<>();
        }

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> choices = new ArrayList<>();

        for (char c : digits.toCharArray()) {
            choices.add(map.get(c));
        }

        int len = digits.length();
        char[] arr = new char[len];

        backTracking(choices, arr, 0, len);
        return result;
    }

    private void backTracking(final List<String> choices, final char[] arr, final int i, final int len) {
        if (i == len) {
            result.add(String.valueOf(arr));
            return;
        }

        for (char c : choices.get(i).toCharArray()) {
            arr[i] = c;

            backTracking(choices, arr, i + 1, len);
        }
    }

    public static void main(String[] args) {
        Leetcode17 leetcode17 = new Leetcode17();

        List<String> strings = leetcode17.letterCombinations("23");

        System.out.println(strings);
    }
}
