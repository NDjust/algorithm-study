package nctest;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Problem4 {
    public static String solution(String compressed) {
        String[] split = compressed.split("");
        Deque<String> deque = new LinkedList<>();
        String str = "";
        for (String s : split) {
            if (!s.equals("(") && !s.equals(")")) {
                str += s;
            } else {
                if (!isWord(str)) {
                    String nums = str.replaceAll("[^0-9]","");
                    String word = str.replaceAll("[0-9]","");
                    deque.add(word);
                    deque.add(nums);
                    str = "";
                } else {

                    deque.add(str);
                    str = "";
                    deque.add(s);
                }
            }
        }

        for (String s : deque) {
            System.out.println(s);
        }
        return "";
    }

    public static boolean isWord(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 48 && s.charAt(i) <= 57) {
                return false;
            }
        }
        return true;
    }
    public static String[] splitStr(String s) {
        String nums = s.replaceAll("[^0-9]","");
        String str = s.replaceAll("[0-9]","");
        String[] result = new String[2];
        result[0] = str;
        result[1] = nums;
        return result;
    }
    public static void main(String[] args) {
        solution("2(2(hi)2(co))x2(bo)");
    }
}
