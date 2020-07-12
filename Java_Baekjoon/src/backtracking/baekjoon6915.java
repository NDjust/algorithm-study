package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class baekjoon6915 {

    private static int l;

    private static int c;

    private static String[] alphabets;

    private static boolean[] visited;

    private static char[] vowels = new char[] {'a', 'e', 'i', 'o', 'u'};
    private static StringBuilder chosenChar = new StringBuilder();

    private static List<String> anwser = new ArrayList<>();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] lc = sc.nextLine().split(" ");
        l = Integer.parseInt(lc[0]);
        c = Integer.parseInt(lc[1]);
        alphabets = new String[c];
        visited = new boolean[c];

        for (int i = 0; i < c; i++) {
            alphabets[i] = sc.next();
        }

        Arrays.sort(alphabets);

        backTracking(0, 0);

        for (String s : anwser) {
            System.out.println(s);
        }

    }

    private static void backTracking(int idx, final int cnt) {
        if (cnt == l) {
            if (isPossible()) {
                anwser.add(chosenChar.toString());
            }
            return;
        }


        for (int i = idx; i < alphabets.length; i++) {

            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            chosenChar.append(alphabets[i]);
            backTracking(i+1,cnt + 1);
            visited[i] = false;
            chosenChar.delete(chosenChar.length()-1, chosenChar.length());
        }
    }

    private static boolean isPossible() {
        int vowelsCount = 0;
        int consCount = 0;
        for (int i = 0; i < chosenChar.length(); i++) {
            if (isVowel(chosenChar.charAt(i))) {
                vowelsCount++;
            } else {
                consCount++;
            }
        }


        return vowelsCount >= 1 && consCount >= 2;
    }

    private static boolean isVowel(final char c) {
        for (char vowel : vowels) {
            if (vowel == c) {
                return true;
            }
        }
        return false;
    }
}
