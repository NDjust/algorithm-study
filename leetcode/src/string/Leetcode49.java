package string;

import java.util.*;

public class Leetcode49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Anagram, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            int[] mask = new int[26];

            for (char c : chars) {
                mask[c - 'a']++;
            }

            Anagram anagram = new Anagram(mask);
            if (map.isEmpty()) {
                List<String> values = new ArrayList<>();
                values.add(str);

                map.put(anagram, values);
            } else {
                List<String> values;

                if (map.containsKey(anagram)) {
                    values = map.get(anagram);
                } else {
                    values = new ArrayList<>();

                }
                values.add(str);
                map.put(anagram, values);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (Anagram anagram : map.keySet()) {
            List<String> strings = map.get(anagram);
            result.add(strings);
        }

        return result;
    }

    private static class Anagram {
        int[] counts;

        public Anagram(final int[] counts) {
            this.counts = counts;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            final Anagram anagram = (Anagram) o;
            return Arrays.equals(counts, anagram.counts);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(counts);
        }
    }

    public static void main(String[] args) {
        Leetcode49 leetcode49 = new Leetcode49();
        String[] strs = {
                "eat","tea","tan","ate","nat","bat"
        };

        List<List<String>> lists = leetcode49.groupAnagrams(strs);

        for (List<String> list : lists) {
            System.out.println(list.toString());
        }
    }
}
