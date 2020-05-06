package kakao.intern2019;

import java.util.*;
import java.util.stream.Collectors;

public class Tuple {

    public static int[] solution(String s) {
        Set<String> set = new HashSet<>();
        String[] arr = s.replaceAll("[{]", " ")
                .replaceAll("[}]", " ")
                .trim().split(" , ");
        int[] ans = new int[arr.length];
        int idx = 0;

        Arrays.sort(arr, (a, b) -> {
            return a.length() - b.length();
        } );

        for (String s1 : arr) {
            for (String a : s1.split(",")) {
                if (set.add(a)) {
                    ans[idx++] = Integer.parseInt(a);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
        solution("{{20,111},{111}}");
    }
}
