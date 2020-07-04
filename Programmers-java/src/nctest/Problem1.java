package nctest;

import java.util.*;
import java.util.stream.Collectors;

public class Problem1 {


    public static String[] solution(String[] movie) {
        HashMap<String, Integer> hashMap = new LinkedHashMap<>();

        for (String m : movie) {
            if (hashMap.keySet().contains(m)) {
                Integer count = hashMap.get(m);
                hashMap.put(m, count + 1);
            } else {
                hashMap.put(m, 1);
            }
        }
        List<String> keys = sortByValue(hashMap);
        String[] answer = new String[keys.size()];
        for (int i = 0; i < keys.size(); i++) {
            answer[i] = keys.get(i);
        }

        return answer;
    }

    public static List sortByValue(final HashMap<String, Integer> map) {
        List<String> list = new ArrayList<>();
        list.addAll(map.keySet());

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int v1 = map.get(o1);
                int v2 = map.get(o2);
                if (v1 == v2) {
                    return ((Comparable)o1).compareTo(o2);
                }
                return ((Comparable) v2).compareTo(v1);
            }
        });
        return list;
    }
    public static void main(String[] args) {
        String[] list = solution(new String[] {"spy","ray","spy","room","once","ray","spy","once"});
        for (String s : list) {
            System.out.print(s + " ");
        }
    }
}
