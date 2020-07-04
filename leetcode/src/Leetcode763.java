import java.util.*;

public class Leetcode763 {


    public List<Integer> partitionLabelsMethod2(String s) {
        int[] map = new int[256];
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map[c] = i;
        }

        int i = 0;
        int idx = 0;

        for (int j = 0; j < s.length(); j++) {
            i = Math.max(i, map[s.charAt(j)]);

            if (i == j) {
                ans.add(i - idx + 1);
                idx = i + 1;
            }
        }

        return ans;
    }

    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        Map<Character, List<Integer>> map = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.get(c).add(i);
            } else {
                ArrayList<Integer> index = new ArrayList<>();
                index.add(i);
                map.put(c, index);
            }
        }

        int i = 0;
        while (i < s.length()){
            char alphabet = s.charAt(i);
            int lastIndex = findNextAlphabetIndex(map, alphabet);

            ans.add(s.substring(s.indexOf(alphabet), lastIndex+1).length());
            i = lastIndex + 1;

        }

        return ans;
    }

    public int findNextAlphabetIndex(Map<Character, List<Integer>> map, char currentAlphabet) {
        List<Integer> index = map.get(currentAlphabet);
        int lastIndex = index.get(index.size() - 1);

        for (Character character : map.keySet()) {
            List<Integer> next = map.get(character);
            int nextLastIndex = next.get(next.size() - 1);
            if (next.get(0) < lastIndex && lastIndex < nextLastIndex) {
                lastIndex = nextLastIndex;
            }
        }

        return lastIndex;
    }


    static class Alphabet {
        char value;
        List<Integer> idx;

    }

    public static void main(String[] args) {
       Leetcode763 leetcode763 = new Leetcode763();
        String s = "ababcbacadefegdehijhklij";
        List<Integer> list = leetcode763.partitionLabels(s);

        System.out.println(list.toString());
        List<Integer> list1 = leetcode763.partitionLabelsMethod2(s);
        System.out.println(list1.toString());
    }
}
