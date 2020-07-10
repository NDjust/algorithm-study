package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon1062 {

    private static int maxReadWordCount = Integer.MIN_VALUE;

    private static boolean[] visitedAlphabet = new boolean[26];

    private static String[] subWords;

    private static int n;

    private static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = br.readLine().split(" ");
        n = Integer.parseInt(nk[0]);
        k = Integer.parseInt(nk[1]);
        subWords = new String[n];

        if (k < 5) {
            System.out.println(0);
            return;
        } else if (k == 26) {
            System.out.println(n);
            return;
        } else {
            // 26Ck 가르쳤을 때, 읽을 수 있는 최대 단어.
            for (int i = 0; i < n; i++) {
                String word = br.readLine();
                subWords[i] = word.substring(4, word.length() - 4);
            }

            // antica는 무조건 나오니 미리 masking -> 20Ck-5로 복잡도가 확 줄게 됨.
            k -= 5;
            visitedAlphabet[0] = true;
            visitedAlphabet['c' - 'a'] = true;
            visitedAlphabet['n' - 'a'] = true;
            visitedAlphabet['t' - 'a'] = true;
            visitedAlphabet['i' - 'a'] = true;


            searchWords(0, 0);

            System.out.println(maxReadWordCount);
        }
    }

    private static void searchWords(int idx, int cnt) {
        if (cnt == k) {
            countReadWords();
            return;
        }

        for (int i = idx; i <= 25; i++) {
            if (!visitedAlphabet[i]) {
                visitedAlphabet[i] = true;
                searchWords(i, cnt + 1);
                visitedAlphabet[i] = false;
            }
        }
    }

    private static void countReadWords() {
        int canReadWordCount = 0;
        for (String word : subWords) {

            if (canReadWord(word)) {
                canReadWordCount++;
            }
        }

        if (maxReadWordCount < canReadWordCount) {
            maxReadWordCount = canReadWordCount;
        }
    }

    private static boolean canReadWord(final String word) {
        for (int i = 0; i < word.length(); i++) {
            int alphabetIdx = word.charAt(i) - 'a';
            if (!visitedAlphabet[alphabetIdx]) {
                return false;
            }
        }

        return true;
    }
}
