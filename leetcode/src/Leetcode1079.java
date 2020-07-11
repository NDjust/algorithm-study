import java.util.HashSet;
import java.util.Set;

public class Leetcode1079 {

    private int tilesCount;

    private boolean[] selectedLetter;

    private Set<String> allTiles = new HashSet<>();

    private String tiles;

    public int numTilePossibilities(String tiles) {
        Set<Character> titleSet = new HashSet<>();

        for (int i = 0; i < tiles.length(); i++) {
            titleSet.add(tiles.charAt(i));
        }
        this.tiles = tiles;
        tilesCount = tiles.length();
        selectedLetter = new boolean[tilesCount];

        for (int i = 1; i <= tilesCount; i++) {
            searchTiles(0, 0, i);
        }

        for (String allTile : allTiles) {
            System.out.println(allTile);
        }
        return allTiles.size();
    }

    public void searchTiles(int idx, int cnt, final int k) {
        if (cnt == k) {
            addTiles();
            return;
        }


        for (int i = idx; i < this.tiles.length(); i++) {
            if (!selectedLetter[i]) {
                selectedLetter[i] = true;
                searchTiles(i, cnt + 1, k);
                selectedLetter[i] = false;
            }
        }

    }

    private void addTiles() {
        StringBuilder tile = new StringBuilder();

        for (int i = 0; i < selectedLetter.length; i++) {
            if (selectedLetter[i]) {
                tile.append(this.tiles.charAt(i));
            }
        }

        permutation("", tile.toString(), tile.length());
        allTiles.add(tile.toString());
    }

    private void permutation(String prefix, final String tile, final int n) {

        if (prefix.length() == n) {
            allTiles.add(prefix);
        }

        for (int i = 0; i < tile.length(); i++) {
            permutation(prefix + tile.charAt(i), tile.substring(0, i) + tile.substring(i + 1, tile.length()), n);
        }
    }

    public static void main(String[] args) {
        Leetcode1079 leetcode1079 = new Leetcode1079();
        int aab = leetcode1079.numTilePossibilities("AAB");
    }
}
