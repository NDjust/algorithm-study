package etc;

import java.util.*;
import java.util.stream.Collectors;

public class baekjoon10814 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<String, Integer> a = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            String str = sc.next();

            a.put(str, k);
        }


        TreeMap<String, Integer> sortedMap = sortMapByValue(a);

        Set<String> strings = sortedMap.keySet();
        Iterator<String> iterator = strings.iterator();
        Iterator<Integer> values = sortedMap.values().iterator();

        while (iterator.hasNext()) {
            String s = iterator.next();
            int k = values.next();
            System.out.printf("%d %s\n", k, s);
        }
    }

    public static TreeMap<String, Integer> sortMapByValue(HashMap<String, Integer> map){
        Comparator<String> comparator = new ValueComparator(map);
        //TreeMap is a map sorted by its keys.
        //The comparator is used to sort the TreeMap by keys.
        TreeMap<String, Integer> result = new TreeMap<String, Integer>(comparator);
        result.putAll(map);
        return result;
    }
}

// a comparator that compares Strings
class ValueComparator implements Comparator<String>{

    HashMap<String, Integer> map = new HashMap<String, Integer>();

    public ValueComparator(HashMap<String, Integer> map){
        this.map.putAll(map);
    }

    @Override
    public int compare(String s1, String s2) {
        if(map.get(s1) <= map.get(s2)){
            return -1;
        }else{
            return 1;
        }
    }
}