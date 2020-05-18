package practice.dfsbfs;

import java.util.Arrays;
import java.util.stream.Collectors;

public class WordTransformer {

    private static boolean[] visited;

    private static int count;
    private static int min = Integer.MAX_VALUE;

    private static int getCount() {
        int cnt = 0;
        for (boolean b : visited) {
            if (b) {
                cnt++;
            }
        }
        return cnt;
    }

    private static int diffCount(String begin, String word) {
        int cnt = 0;
        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) != word.charAt(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    private static char getDiffChar(String begin, String word, String target) {
        if (diffCount(begin, word) == 1) {
            for (int i = 0; i < target.length(); i++) {
                if (word.charAt(i) == target.charAt(i)) {
                    return word.charAt(i);
                }
            }
        }
        return '0';
    }

    private static boolean canNext(String begin, String word, String target) {
        char diffChar = getDiffChar(begin, word, target);
        return diffChar != '0';
    }

    private static void dfs(int r, String begin, String target, String[] words) {
        if (begin.equals(target)) {
            int count = getCount();
            if (min > count) {
                min = count;
            }
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (canNext(begin, words[i], target) && !visited[i]) {
                visited[i] = true;
                dfs(i, words[i], target, words);
                visited[i] = false;
            }
        }
    }

    public static int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];

        if (!Arrays.stream(words).collect(Collectors.toList()).contains(target)) {
            return 0;
        }

        dfs(0, begin, target, words);

        return min;
    }
    public static void main(String[] args) {
        String b = "hit";
        String t = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log"};

        System.out.println(solution(b, t, words));
    }
}
