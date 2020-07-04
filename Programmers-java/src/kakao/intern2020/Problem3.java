package kakao.intern2020;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem3 {

    static int end;

    public static int[] solution(String[] gems) {
        int[] answer = new int[]{gems.length, gems.length};
        int N = gems.length;
        Set<String> set = new HashSet<>();
        set.addAll(Arrays.asList(gems));

        if (set.size() == 1) {
            return new int[]{1, 1};
        }

        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = N-1;

        while (right >= left) {
            int mid = (left + right) / 2;
            end = 0;

            if (isPossible(mid, N, gems, new HashSet<>(set))) {
                int start = mid;
                if (min >= (end - start)) {
                    if (min == (end - start)) {
                        if (answer[0] > start) {
                            answer = new int[]{start+1, end+1};
                        }
                    } else {
                        min = end - start;
                        answer = new int[]{start+1, end+1};
                    }
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    public static boolean isPossible(int mid, int N, String[] germs, HashSet<String> set) {
        int i;
        for (i = mid; i < N; i++) {
            if (set.contains(germs[i])) {
                set.remove(germs[i]);
            }

            if (set.size() == 0) {
                end = i;
                return true;
            }

        }

        return false;
    }

    public static void main(String[] args) {
        int[] solution = solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"});
        for (int i : solution) {
            System.out.println(i);
        }
    }
}
