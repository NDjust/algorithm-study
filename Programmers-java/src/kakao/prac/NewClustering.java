package kakao.prac;

import java.util.*;
import java.util.regex.Pattern;

public class NewClustering {

    public int solution(String str1, String str2) {

        List<String> list1 = subset(str1.toLowerCase());
        List<String> list2 = subset(str2.toLowerCase());

        int intersection = 0;

        List<Integer> check = new ArrayList<Integer>(); // 교집합 구할 떄, 중복제거

        for (int a = 0; a < list1.size(); a++) { // 교집합 개수 구하기
            String s1 = list1.get(a);
            for (int b = 0; b < list2.size(); b++) {
                String s2 = list2.get(b);
                if (s1.equals(s2) && !check.contains(b)) {
                    intersection++;
                    check.add(b);
                    break;
                }

            }
        }

        int union = list1.size() + list2.size() - intersection; // 합집합

        if (union == 0 && intersection == 0) {
            return 65536;
        }

        return (int) (((float) intersection / union) * 65536);
    }

    List<String> subset(String s) { // 문자열 s의 다중집합

        List<String> list = new ArrayList<String>();
        char[] arr = s.toCharArray();
        int size = arr.length - 1;
        String str;
        int start = 0;
        int end = 1;

        while (end <= size) {
            str = String.valueOf(arr[start]) + String.valueOf(arr[end]);
            boolean isMatch = Pattern.matches("^[a-z]*$", str); // 부분집합의 원소가 영어로만 구성되어 있는지 확인
            if (isMatch) {
                list.add(str);
            }
            start++;
            end++;
        }
        return list;
    }


    public static void main(String[] args) {
        String s1 = "aa1+aa2";
        String s2 = "AAAA12";

        NewClustering newClustering = new NewClustering();
        int solution = newClustering.solution(s1, s2);

        System.out.println(solution);
    }
}
