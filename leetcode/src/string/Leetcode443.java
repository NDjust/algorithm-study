package string;

import java.util.HashMap;
import java.util.Map;

public class Leetcode443 {

    public int compress(char[] chars) {
        Map<Character, Integer> map = new HashMap<>();

        StringBuilder sb = new StringBuilder();
        char prevKey = chars[0];

        for (char c : chars) {
            if (!map.isEmpty() && !map.containsKey(c)) {
                Integer count = map.get(prevKey);
                String value = String.valueOf(prevKey);
                if (count > 1) {
                    value = value + count;
                }

                sb.append(value);
                map.remove(prevKey);
                prevKey = c;
            }
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Character c : map.keySet()) {
            Integer count = map.get(c);
            String value = String.valueOf(c);
            if (count > 1) {
                value = value + count;
            }
            sb.append(value);
        }

        for (int i = 0; i < sb.length(); i++) {
            chars[i] = sb.charAt(i);
        }

        return sb.length();
    }

    public static void main(String[] args) {
        Leetcode443 leetcode443 = new Leetcode443();

        int compress = leetcode443.compress(new char[]{
                'a', 'a', 'b', 'b', 'c', 'c', 'c'
        });
        System.out.println(compress);
    }
}
