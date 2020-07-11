package backtracking;

import java.util.Arrays;

public class Leetcode1079 {

    private int tilesCount;

    private boolean[] selectedLetter;

    private String tiles;

    public int numTilePossibilities(String tiles) {
        selectedLetter = new boolean[tiles.toCharArray().length];
        char[] chars = tiles.toCharArray();
        Arrays.sort(chars);
        DFS(chars);
        return tilesCount;
    }

    private void DFS(final char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if (selectedLetter[i]) {
                continue;
            }

            selectedLetter[i] = true;
            tilesCount++;
            DFS(chars);
            selectedLetter[i] = false;

            while (i < chars.length - 1 && chars[i] == chars[i+1]) {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        Leetcode1079 leetcode1079 = new Leetcode1079();
        int aab = leetcode1079.numTilePossibilities("AAB");
        System.out.println(aab);
    }
}
