package kakao.intern2019;

import java.util.*;
import java.util.stream.Collectors;

public class Tuple {

    public static int[] solution(String s) {
        String[] split = s.split(",");
        List<List<Integer>> tuple = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        StringBuilder num = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) <= 57 && s.charAt(i) >= 48) {
                queue.add(s.charAt(i));
            }

            if (s.charAt(i) == '}' && !queue.isEmpty()) {
                while (!queue.isEmpty()) {
                    num.append(queue.poll());
                }
                nums.add(Integer.parseInt(String.valueOf(num)));
                tuple.add(nums);
                num = new StringBuilder();
                nums = new ArrayList<>();
            }

            if (s.charAt(i) == ',' && !queue.isEmpty()) {
                while (!queue.isEmpty()) {
                    num.append(queue.poll());
                }
                nums.add(Integer.parseInt(String.valueOf(num)));
                num = new StringBuilder();
            }
        }
        List<List<Integer>> sort = sort(tuple);

        List<HashSet> hashSetList = new ArrayList<>();
        for (List<Integer> list : sort) {
            HashSet hashSet = new HashSet();
            hashSet.addAll(list);
            hashSetList.add(hashSet);
        }
        List<Integer> list = new ArrayList<>();

        for (int i = hashSetList.size()-1; i > 0; i--) {
            hashSetList.get(i).removeAll(hashSetList.get(i-1));
            Iterator iterator = hashSetList.get(i).iterator();

            while (iterator.hasNext()) {
                list.add((Integer) iterator.next());
            }
        }
        list.add(sort.get(0).get(0));
        Collections.reverse(list);

        int[] ans = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static List<List<Integer>> sort(List<List<Integer>> tuple) {
        List<List<Integer>> sortedTuple = new ArrayList<>();
        for (int i = 0; i < tuple.size(); i++) {
            for (int j = 0; j < tuple.size(); j++) {
                if (tuple.get(j).size() == i+1) {
                    sortedTuple.add(tuple.get(j));
                }
            }
        }
        return sortedTuple;
    }
    public static void main(String[] args) {
        solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
        solution("{{20,111},{111}}");
    }
}
